package com.example.allDBIntegration.filehandlers;

import com.example.allDBIntegration.entities.CSVEmployee;
import com.example.allDBIntegration.services.CSVServices;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.List;

public class CSVFileHandler implements FileHandler {

    CSVServices csvServices;

    BufferedReader reader = null;
    BufferedWriter writer = null;

    public CSVFileHandler(CSVServices csvServices) throws IOException, SecurityException {
        this.csvServices = csvServices;
    }

    @Override
    public void read(){
        try {
            reader = new BufferedReader(new FileReader("/Users/khodidaschauhan/Downloads/allDBIntegration/src/main/java/com/example/allDBIntegration/employee.csv"));
            System.out.println("Inside try of read");
        }catch(Exception expMsg){
            System.out.println(expMsg);
        }
        String line;
        CSVEmployee emp = new CSVEmployee();
        int i=0;
        for (i = 0; i < 100; i++) {
            try {
                if ((line = reader.readLine()) != null) {
                    String[] str = line.split(",");
                    emp.setId(i);
                    emp.setFirstName(str[0]);
                    emp.setLastName(str[1]);
                    emp.setDateOfBirth(new SimpleDateFormat("dd/MM/yyyy").parse(str[2]));
                    emp.setExperience(Double.parseDouble(str[3]));

                    //write to db here
                    csvServices.save(emp);
                }
            } catch (Exception exp) {
                System.out.println(exp);
            }
        }
    }

    @Override
    public void write(){
        List<CSVEmployee> csvEmployeeList = csvServices.findAll();
        try {
            writer = new BufferedWriter(new FileWriter("/Users/khodidaschauhan/Downloads/allDBIntegration/src/main/java/com/example/allDBIntegration/employeeWrite.csv"));
            for(int i=0; i<100; i++) {
                CSVEmployee csvEmployee = csvEmployeeList.get(i);
                writer.write(csvEmployee.getFirstName() + "," + csvEmployee.getLastName() + "," + csvEmployee.getDateOfBirth() + "," + csvEmployee.getExperience());
                writer.newLine();
                writer.flush();
            }
        }catch (Exception exp){
            System.out.println(exp);
        }
    }
}
