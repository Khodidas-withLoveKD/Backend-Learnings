package com.example.allDBIntegration.filehandlers;

import com.example.allDBIntegration.entities.JSONEmployee;
import com.example.allDBIntegration.services.JSONServices;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class JSONFileHandler implements FileHandler {

    //create object of Services so you can use it without autowire
    JSONServices jsonServices;

    JSONParser jsonParser;
    JSONArray employeeList;
    FileReader reader;
    Object obj;
    int counter;

    public JSONFileHandler(JSONServices jsonServices){
        this.jsonServices = jsonServices;
        counter = 0;
    }
    @Override
    public void read(){
        try {
            jsonParser = new JSONParser();
            reader = new FileReader("/Users/khodidaschauhan/Downloads/allDBIntegration/src/main/java/com/example/allDBIntegration/employee.json");
            obj = jsonParser.parse(reader);
            System.out.println("Above JSON array");
            JSONArray employeeList = (JSONArray) obj;
            employeeList.forEach( emp -> parseEmpObj( (JSONObject) emp) );
            System.out.println("Below JSON Array");
        }catch(Exception expMsg){
            System.out.println(expMsg);
        }
    }

    private void parseEmpObj( JSONObject emp){

        JSONEmployee employee = new JSONEmployee();

        employee.setId(counter++);

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

        //write to mongodb here
        jsonServices.insert(employee);
        System.out.println("EMp: "+employee.getFirstName());
    }

    @Override
    public void write(){

        List<JSONEmployee> jsonEmployeeList = jsonServices.findAll();
        //JSONEmployee employee = new JSONEmployee();

        //iterate on by one and execute below in loop
        for(JSONEmployee employee: jsonEmployeeList) {
            //call it empObj
            JSONObject employeeObject = new JSONObject();

            String employeeFirstName = employee.getFirstName();
            employeeObject.put("firstName", employeeFirstName);

            String employeeLastName = employee.getLastName();
            employeeObject.put("lastName", employeeLastName);

            Date employeeDateOfBirth = employee.getDateOfBirth();
            employeeObject.put("dateOfBirth", employeeFirstName);

            double employeeExperience = employee.getExperience();
            employeeObject.put("experience", employeeExperience);

            try (FileWriter file = new FileWriter("/Users/khodidaschauhan/Downloads/allDBIntegration/src/main/java/com/example/allDBIntegration/employeeWrite.json", true)) {
                file.write(employeeObject.toJSONString());
                System.out.println("EmployeeObject: "+employeeObject);
                file.write("\n");

            } catch (IOException expMsg) {
                System.out.println(expMsg);
            }
        }
    }
}
