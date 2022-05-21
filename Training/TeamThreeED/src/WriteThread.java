public class WriteThread {
    public void writeCSV() {
        try {
            MyCollection myCollection = MyCollection.getInstance();
            CSVFileHandler csvFileHandler = new CSVFileHandler();
            for(int i=0;i<100;i++) {
                Employee emp = myCollection.WriteEmployee();
                csvFileHandler.write(emp);
            }
        } catch (Exception exp) {
            System.out.println(exp);
        }
    }

    public void writeXML(){
        try{
            MyCollection myCollection = MyCollection.getInstance();
            XMLFileHandler xmlFileHandler = new XMLFileHandler();
                xmlFileHandler.write(new Employee());
        }catch (Exception exp){
            System.out.println(exp);
        }
    }

    public void writeJSON(){
        try{
            MyCollection myCollection = MyCollection.getInstance();
            JsonFileHandler jsonFileHandler = new JsonFileHandler();
            for(int i=0;i<100;i++) {
                Employee emp = myCollection.WriteEmployee();
                jsonFileHandler.write(emp);
            }
        }catch (Exception exp){
            System.out.println(exp);
        }
    }
}
