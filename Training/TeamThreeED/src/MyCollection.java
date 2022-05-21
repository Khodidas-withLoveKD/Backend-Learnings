import java.util.List;

public class MyCollection{
    private Employee[] listOfEmployees = new Employee[300];
    private int writeCounter = 0;
    private int readCounter = 0;
    private static MyCollection instance = null;

    public static MyCollection getInstance(){
        if(instance == null){
            synchronized (MyCollection.class){
                if(instance == null){
                    instance = new MyCollection();
                }
            }
        }
        return instance;
    }

    public void AddEmployee(Employee emp){
        listOfEmployees[readCounter++] = emp;
    }

    public Employee[] getList(){
        return listOfEmployees;

    }

    public Employee WriteEmployee(){
        return listOfEmployees[writeCounter++];
    }
    public int getWriteCounter(){
        return writeCounter;
    }
    public int getReadCounter(){
        return readCounter;
    }

}