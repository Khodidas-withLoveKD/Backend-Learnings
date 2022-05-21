package com.example.postmornrad.filehandler;

import com.example.postmornrad.entity.EmployeeMongo;


import com.example.postmornrad.repository.EmployeeRepositoryMongo;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class JSONFileHandler implements FileHandler {

    EmployeeRepositoryMongo employeeRepositoryMongo;

    public JSONFileHandler(EmployeeRepositoryMongo employeeRepositoryMongo){
        this.employeeRepositoryMongo= employeeRepositoryMongo;
    }

    public void read() {
        //JSON parser object to parse read file

        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader("/Users/vanditshihora/Downloads/postmornrad/src/main/java/com/example/postmornrad/employee.json")) {
            Object obj = jsonParser.parse(reader);
            JSONArray employeeList = (JSONArray) obj;
            for (Object employee : employeeList) {
                EmployeeMongo employee1 = new EmployeeMongo();
                Date date = null;
                Double experience = Double.parseDouble(String.valueOf(((JSONObject) employee).get("experience")));
                try {
                    date = new SimpleDateFormat("dd/MM/yyyy").parse((String) ((JSONObject) employee).get("dateOfBirth"));
                }catch (java.text.ParseException e) {
                    e.printStackTrace();
                }
                employee1.setFirstName((String) ((JSONObject) employee).get("firstName"));
                employee1.setLastName((String) ((JSONObject) employee).get("lastName"));
                employee1.setDateOfBirth(date);
                employee1.setExperience(experience);
                employeeRepositoryMongo.save(employee1);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }
    }
    public void write() {
        File file = new File("/Users/vanditshihora/Downloads/postmornrad/src/main/java/com/example/postmornrad/newEmployees.json");
        JSONArray jsonArray = new JSONArray();
        List<EmployeeMongo> employeeList=employeeRepositoryMongo.findAll();
        for (EmployeeMongo employee:employeeList) {

            JSONObject jsonObject = new JSONObject();
            SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
            jsonObject.put("firstName", employee.getFirstName());
            jsonObject.put("lastName", employee.getLastName());

            jsonObject.put("dateOfBirth", DATE_FORMAT.format(employee.getDateOfBirth()));
            jsonObject.put("experience", employee.getExperience());
            jsonArray.add(jsonObject);
        }
        try {
            FileWriter file1 = new FileWriter(file, true);
            file1.append(jsonArray.toJSONString());
            file1.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}



