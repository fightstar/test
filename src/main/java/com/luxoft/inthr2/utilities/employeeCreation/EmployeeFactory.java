package com.luxoft.inthr2.utilities.employeeCreation;

import com.luxoft.inthr2.pages.*;
import com.luxoft.inthr2.utilities.db.DB;
import com.luxoft.inthr2.utilities.soap.org.tempuri.ITimingService;
import com.luxoft.inthr2.utilities.soap.org.tempuri.TimingService;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static com.codeborne.selenide.Selenide.sleep;

/**
 * Created with IntelliJ IDEA.
 * User: ihnedysh
 * Date: 26.11.13
 * Time: 19:16
 * To change this template use File | Settings | File Templates.
 */
public class EmployeeFactory {



    public static void createEmployee(String configFile, EmployeeStatus status, EnvironmentConfiguration configuration) {
        EmployeeData data = deserializeEmployeeData(configFile);

        if (status.hasFlag(EmployeeStatus.CandidateRequest)) {
            createCandidateRequest(configFile);
        }
        if (status.hasFlag(EmployeeStatus.Candidate)) {
            createCandidate(configuration, configFile);
        }
        if (status.hasFlag(EmployeeStatus.Employee)) {
            createNewEmployee(configuration, configFile);
        }

    }

    private static EmployeeData deserializeEmployeeData(String configFile) {
        XStream xstream = new XStream(new StaxDriver());
        EmployeeData employeeData = new EmployeeData();
        try {
            FileInputStream fileInputStream = new FileInputStream(configFile);
            xstream.fromXML(fileInputStream, employeeData);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return employeeData;
    }

    public static void printDeserializeEmployeeFromXmlConfigFile(String configFile) {  //for test
        EmployeeData data = deserializeEmployeeData(configFile);

        System.out.println("First Name: " + data.firstName);
        System.out.println("Last Name: " + data.lastName);
        System.out.println("MiddleName" + data.middleName);
        System.out.println("Pin: " + data.pin);
    }

    private IEmployeeCreationChainElement GetChainStartForStatus(int status) {
        return null;

    }

    public static void createCandidateRequest(String configFile) {
        EmployeeData data = deserializeEmployeeData(configFile);


        DB db = new DB("jdbc:jtds:sqlserver://localhost:1433;", "sa","!QAZ2wsx");
        db.executeUpdateQuery("use IntHR2\n" +
                "declare @new_id uniqueidentifier = NEWID()\n" +
                "\n" +
                "insert into RequestBase(name, applyType, applyStatus, status, id, active)\n" +
                "       values('HrSysCandidateRequest', 2, 0, 'Pending', @new_id, 1)\n" +
                "\n" +
                "insert into HrSysCandidateRequest(jiraId, pin, lastNameNative, firstNameNative, middleNameNative, fullNameNative, email, recruiterId,\n" +
                "                                  recommendationDate, recommenderId, hireDate, financialBusinessUnitId, hiringManagerId, requestStatus,\n" +
                "                                  soppCurrencyId, soppGrossNet, soppSalary, soppSalaryPaymentPeriodId, soppBonus, soppBonusCalculationTypeId,\n" +
                "                                  soppBonusPaymentPeriodId, sappCurrencyId, sappGrossNet, sappSalary, sappSalaryPaymentPeriodId,\n" +
                "                                  sappBonus, sappBonusCalculationTypeId, sappBonusPaymentPeriodId, nationalityId, registrationTypeId,\n" +
                "                                  locationId, departmentId, positionId, relocatedFrom, roleId, roleDegreeId, specializations,\n" +
                "                                  probationaryPeriodDuration, id, isRelocated)\n" +
                "       values('HR-66667',--jiraId (вставляем уникальный jiraId)\n" +
                "              0,--pin\n" +
                "              N'"+data.lastName+"',--lastNameNative\n" +
                "              N'"+data.firstName+"',--firstNameNative\n" +
                "              N'"+data.middleName+"',--middleNameNative\n" +
                "              N'"+data.lastName+""+", " +""+data.firstName+""+" "+"" +data.middleName+"',--fullNameNative\n" +
                "              'mail@mail.com',--email\n" +
                "              (select top 1 id from Employee where lastNameNative = N'Кравченко' and active = 1),--recruiterId\n" +
                "              GETDATE(),--recommendationDate\n" +
                "              (select top 1 id from Employee where lastNameNative = N'Попельнюк' and active = 1),--recommenderId\n" +
                "              GETDATE(),--hireDate\n" +
                "              (select id from FinancialBusinessUnit where name = 'Quality Center' and active = 1),--financialBusinessUnitId\n" +
                "              (select top 1 id from Employee where lastNameNative = N'Шведов' and active = 1),--hiringManagerId\n" +
                "              1,--requestStatus\n" +
                "              (select id from Currency where code = 'RUB' and active = 1),--soppCurrencyId\n" +
                "              1,--soppGrossNet(Gross - 1, Net - 2)\n" +
                "              50000,--soppSalary\n" +
                "              (select id from PaymentPeriod where name = 'Per Month' and active = 1),--soppSalaryPaymentPeriodId\n" +
                "              0,--soppBonus\n" +
                "              (select id from BonusCalculationType where name = '%' and active = 1),--soppBonusCalculationTypeId\n" +
                "              (select id from BonusPaymentPeriod where name = 'Per Year' and active = 1),--soppBonusPaymentPeriodId\n" +
                "              (select id from Currency where code = 'RUB' and active = 1),--sappCurrencyId\n" +
                "              1,--soppGrossNet(Gross - 1, Net - 2)\n" +
                "              55000,--sappSalary\n" +
                "              (select id from PaymentPeriod where name = 'Per Month' and active = 1),--sappSalaryPaymentPeriodId\n" +
                "              0,--sappBonus\n" +
                "              (select id from BonusCalculationType where name = '%' and active = 1),--sappBonusCalculationTypeId\n" +
                "              (select id from BonusPaymentPeriod where name = 'Per Year' and active = 1),--sappBonusPaymentPeriodId\n" +
                "              (select id from Country where code = 'RU' and active = 1),--nationalityId\n" +
                "              (select id from TypeOfRegistration where name = 'Employee (Staff)' and active = 1),--registrationTypeId\n" +
                "              (select id from Location where name = 'Moscow' and active = 1),--locationId\n" +
                "              (select id from Department where name = 'Quality Department' and active = 1),--departmentId\n" +
                "              (select id from Position where name = 'Programmer' and active = 1 and locationId = (select id from Location where name = 'RUSSIA')),--positionId\n" +
                "              'Omsk',--relocatedFrom\n" +
                "              (select top 1 id from Role where name = 'Tester' and active = 1),--roleId\n" +
                "              (select top 1 id from RoleDegree where name = 'Regular' and active = 1),--roleDegreeId\n" +
                "              'Java',--specializations\n" +
                "              0,--probationaryPeriodDuration\n" +
                "              @new_id,--id\n" +
                "              1--isRelocated\n" +
                "              )\n");
                db.closeDBConnection();
        System.out.println("Candidate " + data.lastName + " " + data.firstName + " was successfully created in database");
    }

    public static void createCandidate(EnvironmentConfiguration configuration,String configFile ) {
        EmployeeData data = deserializeEmployeeData(configFile);

        CandidateMonitoringPage candidateMonitoringPage = new CandidateMonitoringPage(configuration);
        candidateMonitoringPage.open();
        candidateMonitoringPage.waitWhileLoaded();
        candidateMonitoringPage.getCandidatesRequestTab();
        candidateMonitoringPage.waitWhileLoaded();
        sleep(50000);  //нужно ждать загрузку всех записей гриды
        candidateMonitoringPage.getCandidatesRequestGrid().filter("Full Name Native", "Starts with", data.lastName);

        candidateMonitoringPage.waitWhileLoaded();
        candidateMonitoringPage.getApproveCandidateButton().click();
        ApproveCandidatePage approveCandidatePage  = new ApproveCandidatePage(configuration);

        approveCandidatePage.waitWhileLoaded();
        approveCandidatePage.getManagementBU().setValue("Default MBU");
        approveCandidatePage.getBudgetOnProbPeriod().setValue("Quality Center");
        approveCandidatePage.getBudgetAfterProbPeriod().setValue("Quality Center");
        approveCandidatePage.getApproveButton().click();
        candidateMonitoringPage.waitWhileLoaded();

        sleep(20000);
        candidateMonitoringPage.getHiringMonitoringGrid().filter("Full Name Native", "Starts with", data.lastName);
        //sleep(3000);
        candidateMonitoringPage.waitWhileLoaded();

        candidateMonitoringPage.getProcessSalaryInformationButton().click();
        candidateMonitoringPage.waitWhileLoaded();
        //sleep(200);
        ProcessSalaryInformationPage processSalaryInformationPage = new ProcessSalaryInformationPage(configuration);
        processSalaryInformationPage.waitWhileLoaded();
        processSalaryInformationPage.getSalaryArrows().increaseValue(2);
        processSalaryInformationPage.getCurrency().setValue("RUB");
        processSalaryInformationPage.getGrossNet().setValue("Gross");
        processSalaryInformationPage.getPaymentPeriod().setValue("Per Month");
        processSalaryInformationPage.clickOnTitle();
        processSalaryInformationPage.waitWhileLoaded();




        processSalaryInformationPage.getSaveSalaryProcessingButton().click();

        System.out.println("Candidate " + data.lastName + " was approved");
    }

    public static void createNewEmployee(EnvironmentConfiguration configuration,String configFile ) {
        CandidateMonitoringPage candidateMonitoringPage = new CandidateMonitoringPage(configuration);
        EmployeeData data = deserializeEmployeeData(configFile);
        candidateMonitoringPage.open();
        candidateMonitoringPage.waitWhileLoaded();


        candidateMonitoringPage.getTransferToEmployeeButton().click();
        TransferToEmployeePage transferToEmployeePage = new TransferToEmployeePage(configuration);
        transferToEmployeePage.waitWhileLoaded();
        transferToEmployeePage.getDateOfBirth().setSimpleDate("13 Feb 1985");
        transferToEmployeePage.getCountryPlaceOfBirth().setValue("Куба");
        transferToEmployeePage.getStateProvince().setText("TestStateProvince");
        transferToEmployeePage.getRegion().setText("TestRegion");
        transferToEmployeePage.getCity().setText("TestCity");
        transferToEmployeePage.getIndividualTaxNumber().setText("1234567890");
        transferToEmployeePage.getPermanentResidenceCountry().setValue("Самоа");
        transferToEmployeePage.getPermanentResidenceState().setText("testState");
        transferToEmployeePage.getPermanentResidenceRegion().setText("testRegion");
        transferToEmployeePage.getPermanentResidenceCity().setText("testCity");
        transferToEmployeePage.getPermanentResidenceCommubity().setText("testCommunity");
        transferToEmployeePage.getPermanentResidenceStreet().setText("testStreet");
        transferToEmployeePage.getPermanentResidenceBuildingDropDown().setValue("Estate");
        transferToEmployeePage.getPermanentResidenceBulkDropDown().setValue("Structure");
        transferToEmployeePage.getPermanentResidenceAppartmentDropDown().setValue("Office");
        transferToEmployeePage.getPermanentResidenceBuildingText().setText("testBuilding");
        transferToEmployeePage.getPermanentResidenceBulkText().setText("testBulk");
        transferToEmployeePage.getPermanentResidenceAppartmentText().setText("testAppartment");
        transferToEmployeePage.getPermanentResidenceZipPostalCode().setText("123");

        transferToEmployeePage.getResidenceAddressCopyFrom().setValue("copy from Permanent Residence");
        transferToEmployeePage.getCorrespondenceAddressCopyFrom().setValue("copy from Permanent Residence");

        transferToEmployeePage.getMaritalStatus().setValue("Состоит в зарегистрированном браке");
        transferToEmployeePage.getDateOfMaritalStatusChange().setSimpleDate("18 Dec 2013");

        fillIdentiityCardPage(configuration, transferToEmployeePage);


        fillRegistrationData(transferToEmployeePage);


        transferToEmployeePage.getTransferButton().click();
        candidateMonitoringPage.waitWhileLoaded(); //тут как то притормаживает и открывается Candidate Monitoring Page


        System.out.println("createNewEmployee");
    }

    private static void fillIdentiityCardPage(EnvironmentConfiguration configuration, TransferToEmployeePage transferToEmployeePage) {
        transferToEmployeePage.getAddIdentityCardButton().click();
        transferToEmployeePage.waitWhileLoaded();
        AddIdentityCardPage addIdentityCardPage = new AddIdentityCardPage(configuration);
        System.out.println(addIdentityCardPage.getTitle());
        addIdentityCardPage.getIdentityCardType().setValue("Вид на жительство");
        addIdentityCardPage.getPassportSeries().setText("TE 1234 ST");
        addIdentityCardPage.getPassportNumber().setText("123455");
        addIdentityCardPage.getDateOfIssue().setCurrentDate();
        addIdentityCardPage.getIssuedBy().setText("Test Person");
        addIdentityCardPage.getSubdivisionCode().setText("1234567");
        addIdentityCardPage.getDateOfRegistrationAtPlaceOfResidance().setCurrentDate();
        addIdentityCardPage.clickOnTitle();
        //addIdentityCardPage.waitWhileLoaded();
        addIdentityCardPage.getSaveButton().click();
        //addIdentityCardPage.waitWhileLoaded();
    }

    private static void fillRegistrationData(TransferToEmployeePage transferToEmployeePage) {
        transferToEmployeePage.getRegistrationDataTab();
        transferToEmployeePage.getRegistrationDataContractType().setValue("Трудовой договор");
        transferToEmployeePage.getRegistrationDataComments().setText("test comments");
        transferToEmployeePage.getRegistrationDataLegalEntity().setValue("ООО \"Люксофт Профешнл\"");
        transferToEmployeePage.getRegistrationDataEmploymentType().setValue("Основное место работы");
        transferToEmployeePage.getRegistrationDataWorkingHours().setValue("0.8");
        transferToEmployeePage.getRegistrationDataContractNumber().setText("test 12323 number");
        transferToEmployeePage.getRegistrationDataContractTerm().setValue("Terminal Contract");
        transferToEmployeePage.getRegistrationDataDateOfContract().setCurrentDate();
        transferToEmployeePage.getRegistrationDataContractStartDate().setCurrentDate();
        transferToEmployeePage.getRegistrationDataContractExpiryDate().addDateToCurrent(12);



    }
    //to get raiseProcessRequests() you need invoke
    //getService().raiseProcessRequests();
    private static ITimingService getService() {   //allows to connect webservice

        TimingService timingService = new TimingService();
        return timingService.getBasicHttpBindingITimingService();
    }



}
