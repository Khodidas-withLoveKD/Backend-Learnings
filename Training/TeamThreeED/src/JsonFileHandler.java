import java.io.FileReader;
import java.io.FileWriter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.lang.Object;

public class JsonFileHandler implements MyFileHandler{
    JSONParser jsonParser;
    JSONArray employeeList;
    JSONObject jsonObject;
    FileReader reader;
    Object obj;
    int counter;

    JsonFileHandler() throws Exception {
        jsonParser = new JSONParser();
        reader = new FileReader("/Users/khodidaschauhan/Downloads/TeamThreeED/src/employee.json");
        obj = jsonParser.parse(reader);
        counter = 0;
    }

    public void read(){
        JSONArray employeeList = (JSONArray) obj;
        employeeList.forEach( emp -> parseEmpObj( (JSONObject) emp) );
    }
    private static void parseEmpObj( JSONObject emp){

        MyCollection mc=MyCollection.getInstance();
        Employee employee = new Employee();
        String firstName = (String) emp.get("firstName");
        employee.setFirstName(firstName);

        String lastName = (String) emp.get("lastName");
        employee.setLastName(lastName);

        double experience =  Double.parseDouble(emp.get("experience").toString());
        employee.setExperience(experience);

        try {
            Date DOB = new SimpleDateFormat("MM/DD/YY").parse(emp.get("dateOfBirth").toString());
            employee.setDateOfBirth(DOB);
        }catch(Exception expMsg){
            System.out.println(expMsg);
        }

        mc.AddEmployee(employee);
    }



    public void write(Employee employee){   //getting an Employee object here as parameter
        //call it empObj
        JSONObject employeeObject = new JSONObject();

        String employeeFirstName = employee.getFirstName();
        employeeObject.put("firstName",employeeFirstName);

        String employeeLastName = employee.getLastName();
        employeeObject.put("lastName",employeeLastName);

        Date employeeDateOfBirth = employee.getDateOfBirth();
        employeeObject.put("dateOfBirth",employeeFirstName);

        double employeeExperience = employee.getExperience();
        employeeObject.put("experience",employeeExperience);

        try(FileWriter file = new FileWriter("/Users/khodidaschauhan/Downloads/TeamThreeED/src/emp.json",true)){
            file.write(employeeObject.toJSONString());
            file.write("\n");

        }catch(IOException expMsg){
            System.out.println(expMsg);
        }
    }

    public static void main(String[] args) {
        try {
            JsonFileHandler myhHandler = new JsonFileHandler();
            //Employee emp = myhHandler.read();
            //myhHandler.write(emp);
        } catch (Exception exp) {
            System.out.println(exp);
        }
    }
}