package com.luxoft.inthr2.pages;

import com.codeborne.selenide.Condition;
import com.luxoft.inthr2.controls.*;
import com.luxoft.inthr2.pages.base.Page;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created with IntelliJ IDEA.
 * User: vshevchenko
 * Date: 22.11.13
 * Time: 17:06
 * To change this template use File | Settings | File Templates.
 */
public class TransferToEmployeePage extends Page {
    public TransferToEmployeePage(EnvironmentConfiguration configuration) {
        super(configuration);
    }

    public Button getTransferButton() {
        return new Button("btn_transfer_to_employee");
    }

    public Button getCancelButton() {
        return new Button("btn_cancel_transfer_to_employee");
    }

    public void getGeneralDataTab() {
        $(By.id("tab-general-data")).shouldBe(Condition.visible).click();
    }

    public void getPersonalDataTab() {
        $(By.id("tab-personal-data")).shouldBe(Condition.visible).click();
    }

    public void getRegistrationDataTab() {
        $(By.id("tab-registration-data")).shouldBe(Condition.visible).click();
    }

    public void getEducationTab() {
        $(By.id("tab-education")).shouldBe(Condition.visible).click();
    }

    public void getPreviousEmpHistoryTab() {
        $(By.id("tab-previous-employment-history")).shouldBe(Condition.visible).click();
    }

    public void getAdditionalDataTab() {
        $(By.id("tab-employee-additional-data-view")).shouldBe(Condition.visible).click();
    }

    public TextBox getFirstNameNative() {
        return new TextBox("PersonalData-FirstNameNative");
    }

    public TextBox getMiddleNameNative() {
        return new TextBox("PersonalData-MiddleNameNative");
    }

    public TextBox getLastNameNative() {
        return new TextBox("PersonalData-LastNameNative");
    }

    public TextBox getFirstNameEnglish() {
        return new TextBox("PersonalData-FirstName");
    }

    public TextBox getMiddleNameEnglish() {
        return new TextBox("PersonalData-MiddleName");
    }

    public TextBox getLastNameEnglish() {
        return new TextBox("PersonalData-LastName");
    }

    public DatePicker getPersonalDataHireDate() {
        return new DatePicker("PersonalData-HireDate");
    }

    public DatePicker getLegalHireDate() {
        return new DatePicker("PersonalData-LegalHireDate");
    }

    public DropDownList getNationality() {
        return new DropDownList("//select[@id = 'PersonalData-Nationality']/ancestor::span");
    }

    public DropDownList getCountryPlaceOfBirth() {
        return new DropDownList("//select[@id = 'PersonalData-CountryOfBirth']/ancestor::span");
    }

    public TextBox getStateProvince() {
        return new TextBox("PersonalData-RegionOfBirth");
    }

    public TextBox getRegion() {
        return new TextBox("PersonalData-DistrictOfBirth");
    }

    public TextBox getCity() {
        return new TextBox("PersonalData-CityOfBirth");
    }

    public TextBox getIndividualTaxNumber() {
        //return new InputTextBox(By.xpath("//input[@id = 'EmployeeModel-PersonalData-TIN']/preceding-sibling::input"), "");
        return new InputTextBox("//input[@id = 'EmployeeModel-PersonalData-TIN']/preceding-sibling::input","EmployeeModel-PersonalData-TIN");
    }

    public DatePicker getDateOfBirth() {
        return new DatePicker("PersonalData-DateOfBirth");
    }

    public DropDownList getTypeOfInsuredPerson() {
        return new DropDownList("//select[@id = 'EmployeeModel_TypeOfInsuredPerson']/ancestor::span");
    }

    // Permanent Residence
    public DropDownList getPermanentResidenceCountry() {
        return new DropDownList("//h5[.='Permanent Residence']/parent::div//select[@id = 'country-select']/parent::span");
    }

    public TextBox getPermanentResidenceState() {
        return new TextBox(By.xpath("//h5[.='Permanent Residence']/parent::div//input[@id='stateAutoComplite']"));
    }

    public TextBox getPermanentResidenceRegion() {

         return new TextBox(By.xpath("//h5[.='Permanent Residence']/parent::div//input[@id='regionAutoComplite']"));
    }


    public TextBox getPermanentResidenceCity() {
        return new TextBox(By.xpath("//h5[.='Permanent Residence']/parent::div//input[@id='cityAutoComplite']"));
    }

    public TextBox getPermanentResidenceCommubity() {
        return new TextBox(By.xpath("//h5[.='Permanent Residence']/parent::div//input[@id='communityAutoComplite']"));
    }

    public TextBox getPermanentResidenceStreet() {
        return new TextBox(By.xpath("//h5[.='Permanent Residence']/parent::div//input[@id='streetAutoComplite']"));
    }

    public TextBox getPermanentResidenceBuildingText() {
        return new TextBox(By.xpath("//h5[.='Permanent Residence']/parent::div//input[@id='buildingAutoComplite']"));
    }

    public TextBox getPermanentResidenceBulkText() {
        return new TextBox(By.xpath("//h5[.='Permanent Residence']/parent::div//input[@id='bulkStructureValue']"));
    }

    public TextBox getPermanentResidenceAppartmentText() {
        return new TextBox(By.xpath("//h5[.='Permanent Residence']/parent::div//input[@id='apartmentOfficeValue']"));
    }

    public DropDownList getPermanentResidenceBuildingDropDown() {
        return new DropDownList("//h5[.='Permanent Residence']/parent::div//select[@id = 'building-estate']/parent::span");
    }

    public DropDownList getPermanentResidenceBulkDropDown() {
        return new DropDownList("//h5[.='Permanent Residence']/parent::div//select[@id = 'bulk-structure']/parent::span");
    }

    public DropDownList getPermanentResidenceAppartmentDropDown() {
        return new DropDownList("//h5[.='Permanent Residence']/parent::div//select[@id = 'apartment-office']/parent::span");
    }

    public InputTextBox getPermanentResidenceZipPostalCode() {
        return new InputTextBox(("//input[@id = 'zipCodeValue']/preceding-sibling::input"), "zipCodeValue");
    }

    //Residence Address
    public DropDownList getResidenceAddressCopyFrom() {
        return new DropDownList("//h5[.='Residence Address']/parent::div//select[@id = 'copy-from']/parent::span");
    }
    //Correspondence Address
    public DropDownList getCorrespondenceAddressCopyFrom(){
        return new DropDownList("//h5[.='Correspondence Address']/parent::div//select[@id = 'copy-from']/parent::span");
    }
    //HOME BLOCK
    public DropDownList getMaritalStatus() {
        return new DropDownList("//select[@id = 'personaldata_other_info_marital_status']/ancestor::span");
    }

    public DatePicker getDateOfMaritalStatusChange() {
        return new DatePicker("personaldata_other_info_marital_change_date");
    }
    // ID (IdentityCard) BLOCK
    public Button getAddIdentityCardButton()  {
        return new Button("IdentityCardGrid_toolbar_add_btn");
    }
    public Button getEditIdentityCardButton() {
        return new Button("IdentityCardGrid_toolbar_edit_btn");
    }
    public Button getRemoveIdentityCardButton() {
        return new Button("IdentityCardGrid_toolbar_delete_btn");
    }


    //REGISTRATION DATA
    public DropDownList getRegistrationDataContractType() {
        return new DropDownList("//select[@id = 'registration_data_contract_type']/ancestor::span");
    }

    public DropDownList getEmploymentType() {
        return new DropDownList("//select[@id = 'registration_data_employment_type']/ancestor::span");
    }

    public TextBox getContractNumber() {
        return new TextBox("registration_data_contract_number");
    }
    public TextBox getRegistrationDataComments() {
        return new TextBox("registration_data_comment");
    }
    public DropDownList getRegistrationDataLegalEntity() {
        return new DropDownList("//select[@id = 'registration_data_legal_entity']/ancestor::span");
    }
    public DropDownList getRegistrationDataEmploymentType() {
        return new DropDownList("//select[@id = 'registration_data_employment_type']/ancestor::span");
    }
    public DropDownList getRegistrationDataWorkingHours() {
        return new DropDownList("//select[@id = 'registration_data_schedule']/ancestor::span");
    }
    public TextBox getRegistrationDataContractNumber() {
        return new TextBox("registration_data_contract_number");
    }

    public DropDownList getRegistrationDataContractTerm() {
        return new DropDownList("//select[@id = 'registration_data_contract_term']/ancestor::span");
    }

    public DatePicker getRegistrationDataDateOfContract() {
        return new DatePicker("registration_data_contract_date");
    }

    public DatePicker getRegistrationDataContractStartDate() {
        return new DatePicker("registration_data_start_date");
    }
    public DatePicker getRegistrationDataContractExpiryDate() {
        return new DatePicker("registration_data_end_date");
    }

    @Override
    public String getTitle() {
        return $(By.xpath("//div[@id = 'mainContent']//h4")).getText();
    }
}
