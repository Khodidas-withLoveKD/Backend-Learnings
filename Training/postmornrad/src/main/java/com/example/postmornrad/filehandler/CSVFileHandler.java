package com.example.postmornrad.filehandler;


import com.example.postmornrad.entity.EmployeePostgres;
import com.example.postmornrad.repository.EmployeeRepositoryPostgres;


import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVFileHandler implements FileHandler {

    EmployeeRepositoryPostgres employeeRepositoryPostgres;

    public CSVFileHandler(EmployeeRepositoryPostgres employeeRepositoryPostgres){
        this.employeeRepositoryPostgres= employeeRepositoryPostgres;
    }

    public void read() throws Exception
    {
        String Filename = "/Users/vanditshihora/Downloads/postmornrad/src/main/java/com/example/postmornrad/employee.csv";

        // Employee employee = new Employee();
        Scanner sc = new Scanner(new File(Filename));
        sc.useDelimiter("\n");   //sets the delimiter pattern
        while(sc.hasNext())  //returns a boolean value
        {

            EmployeePostgres employee = new EmployeePostgres();
            String[] k = sc.next().split(",");


            employee.setFirstName(k[0]);
            employee.setLastName(k[1]);
            employee.setDateOfBirth(new SimpleDateFormat("DD/MM/yyyy").parse(k[2]));
            employee.setExperience(Double.parseDouble(k[3]));
         //   employee.setI(employee.getI());
            employeeRepositoryPostgres.save(employee);
        }
        sc.close();

    }
    public void write() throws Exception{



        try {
            FileWriter writer = new FileWriter("//Users/vanditshihora/Downloads/postmornrad/src/main/java/com/example/postmornrad/GenerateCSV.csv");

                Iterable<EmployeePostgres> employees = employeeRepositoryPostgres.findAll();
                List<EmployeePostgres> employeeList = new ArrayList<>();
                employees.forEach(employeeList::add);

                for(EmployeePostgres employee:employees) {
                    writer.append(employee.getFirstName());
                    writer.append(',');
                    writer.append(employee.getLastName());
                    writer.append(',');
                    writer.append(String.valueOf(employee.getDateOfBirth()));
                    writer.append(',');
                    writer.append(Double.toString(employee.getExperience()));
                    writer.append('\n');
                }



            writer.flush();

            writer.close();
        }
        catch(Exception exp){
            System.out.println(exp);
        }

    }

}
