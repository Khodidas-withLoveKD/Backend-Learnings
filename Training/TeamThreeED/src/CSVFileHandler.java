import java.io.*;
import java.lang.Exception;
import java.text.SimpleDateFormat;

public class CSVFileHandler implements MyFileHandler{

    BufferedReader reader = null;
    BufferedWriter writer = null;
    private static CSVFileHandler instance = null;

    public static CSVFileHandler getInstance() throws Exception{
        if(instance == null){
            synchronized (CSVFileHandler.class){
                if(instance == null){
                    instance = new CSVFileHandler();
                }
            }
        }
        return instance;
    }

    CSVFileHandler() throws Exception{
        reader = new BufferedReader(new FileReader("/Users/khodidaschauhan/Downloads/TeamThreeED/src/employee.csv"));
        writer = new BufferedWriter(new FileWriter("/Users/khodidaschauhan/Downloads/TeamThreeED/src/employeeData.csv"));
    }
    public void read(){
        String line;
        Employee emp = new Employee();
        try {
            if ((line = reader.readLine()) != null) {
                String[] str = line.split(",");
                emp.setFirstName(str[0]);
                emp.setLastName(str[1]);
                emp.setDateOfBirth(new SimpleDateFormat("dd/MM/yyyy").parse(str[2]));
                emp.setExperience(Double.parseDouble(str[3]));
                MyCollection mc = MyCollection.getInstance();
                mc.AddEmployee(emp);
            }
        }catch (Exception exp){
            System.out.println(exp);
        }
    }

    public void write(Employee emp){
        try {
            writer.write(emp.getFirstName() + "," + emp.getLastName() + "," + emp.getDateOfBirth() + "," + emp.getExperience());
            writer.newLine();
            writer.flush();
        }catch (Exception exp){
            System.out.println(exp);
        }
    }
}
