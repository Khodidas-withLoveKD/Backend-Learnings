package com.example.employeecollection.handler;

import com.example.employeecollection.entity.EmployeeMongo;
import com.example.employeecollection.services.EmployeeServicesMongo;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class JsonFileHandler implements MyFileHandler {
   // MyCollection myCollection;
    EmployeeServicesMongo employeeServicesMongo;
    private static final String absoulatePath = "/Users/mananpatel/IdeaProjects/EmployeeCollection/data/";


    public JsonFileHandler(EmployeeServicesMongo employeeServicesMongo){
        this.employeeServicesMongo = employeeServicesMongo;
    }

    @Override
    public void read() throws ParseException, IOException {
        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader("/Users/mananpatel/IdeaProjects/EmployeeCollection/data/employee.json"));
        JSONArray jsonArray = (JSONArray)obj;
        EmployeeMongo employee;
        Iterator it = jsonArray.iterator();
        while (it.hasNext()){
            JSONObject jsonObject = (JSONObject)it.next();
            employee = new EmployeeMongo();
            //employee = new Employee((String)jsonObject.get("firstName"), jsonObject.get("lastName"), new SimpleDateFormat("MM/dd/yyyy").parse(jsonObject.get("")), tempArr[3]);
            employee.setLastName((String)jsonObject.get("lastName"));
            employee.setFirstName((String)jsonObject.get("firstName"));
            employee.setExperience((Long)jsonObject.get("experience"));
            employee.setDateOfBirth(new Date(jsonObject.get("dateOfBirth").toString()));
            if (employee != null)
                employeeServicesMongo.insert(employee);
            System.out.println(employee.toString());
        }

    }

    @Override
    public void write() throws IOException {
        System.out.println("CALLLED");
        JSONObject jsonObject = new JSONObject();
        File file=new File("/Users/mananpatel/IdeaProjects/EmployeeCollection/data/employee2.json");
        FileWriter fileWriter=new FileWriter(file);
        EmployeeMongo employee;
        JSONArray jsonArray=new JSONArray();
        List<EmployeeMongo> employeeMongoList = employeeServicesMongo.findAll();
        for(int i=0;i<100;i++){
            employee = employeeMongoList.get(i);
            if (null == employee) break;

            jsonObject.put("firstName", employee.getFirstName());
            jsonObject.put("lastName", employee.getLastName());
            jsonObject.put("dateOfBirth", employee.getDateOfBirth());
            jsonObject.put("experience", employee.getExperience());
            jsonArray.add(jsonObject);
            fileWriter.write(jsonArray.toJSONString());
        }

        fileWriter.flush();
        fileWriter.close();
    }
}
