import com.luxoft.inthr2.utilities.employeeCreation.EmployeeData;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Created with IntelliJ IDEA.
 * User: vshevchenko
 * Date: 27.11.13
 * Time: 19:09
 * To change this template use File | Settings | File Templates.
 */
public class SerializationTest {
    public static void main(String[] args) {
        XStream xstream = new XStream(new StaxDriver());
        EmployeeData newEmployee = new EmployeeData();


        newEmployee.setFirstName("Аркадий");
        newEmployee.setMiddleName("Александрович");
        newEmployee.setLastName("Рылов");
        newEmployee.setPin(200);
        xstream.alias("employee", Employee.class);


        try{
        FileOutputStream fs = new FileOutputStream("D:\\MY_PROJESTS\\TA_JBehave\\trunk\\TA_JBehave\\src\\main\\java\\com\\luxoft\\inthr2\\file.xml");
        xstream.toXML(newEmployee,fs);
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }


        /*String xml  = xstream.toXML(newEmployee);
        System.out.println(xml);

        Employee newEmployee1 = (Employee)xstream.fromXML(xml);
        newEmployee1.setLastName("Gnip");
        newEmployee1.setFirstName("Ruslan");
        newEmployee.setPin(200);
        xstream.alias("employee1", newEmployee1.getClass());//
        String xml1 = xstream.toXML(newEmployee1);
        System.out.println(xml1);
        Employee newEmployee2 = new Employee();


        try{
            FileInputStream fis = new FileInputStream("D:\\MY_PROJESTS\\TA_JBehave\\trunk\\TA_JBehave\\src\\main\\java\\com\\luxoft\\inthr2\\file.xml");
            xstream.fromXML(fis,newEmployee2);
            System.out.println(newEmployee2.toString());
        }catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } */

    }



    public static class Employee {
        private String firstName;
        private String lastName;
        private int pin;

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public void setPin(int pin) {
            this.pin = pin;
        }
    }
}
