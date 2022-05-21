package com.example.employeecollection.handler;
import com.example.employeecollection.entity.EmployeePostgres;
import com.example.employeecollection.services.EmployeeServicesPostgres;

import java.lang.*;
import java.io.*;
import java.text.*;
import java.util.List;


public class CSVFileHandler implements  MyFileHandler
{
    //MyCollection myCollection;
    EmployeeServicesPostgres employeeServicesPostgres;
    private static final String absoulatePath = "/Users/mananpatel/IdeaProjects/EmployeeCollection/data/";
    private static final String delimiter = ",";

    public CSVFileHandler (EmployeeServicesPostgres employeeServicesPostgres){
        this.employeeServicesPostgres = employeeServicesPostgres;
    }

    public CSVFileHandler() {

    }

    @Override
    public void read() {
        try {
            File file = new File(absoulatePath+"employee.csv");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            String[] tempArr;
            EmployeePostgres employee;
            while((line = br.readLine()) != null) {
                tempArr = line.split(delimiter);
                employee = new EmployeePostgres(tempArr[0], tempArr[1],
                        new SimpleDateFormat("MM/dd/yyyy").parse(tempArr[2]), Double.parseDouble(tempArr[3]));
                employeeServicesPostgres.save(employee);

            }
            br.close();
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }catch (Exception exp){
            System.out.println(exp);

        }
    }

    @Override
    public void write() {
        try {

            FileWriter csvWriter = new FileWriter(absoulatePath+"newEmployee.csv");
            EmployeePostgres employee;
            //List<EmployeePostgres> employeePostgres = employeeServicesPostgres.findAll();
            for (int i=0;i<100;i++) {
              // employee = employeePostgres.get(i);
                employee = employeeServicesPostgres.findById(i);
                if (null == employee){
                    break;
                }
                csvWriter.append(String.join(",", employee.csvFormatData())+"\n");
            }
            csvWriter.flush();
            csvWriter.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }catch (Exception exp){
            System.out.println(exp+" ");
        }
    }
}