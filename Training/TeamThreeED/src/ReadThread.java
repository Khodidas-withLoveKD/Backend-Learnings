public class ReadThread {
    public void readCSV(){
        try{
            CSVFileHandler csvFileHandler = new CSVFileHandler();
            for(int i=0;i<100;i++) {
                csvFileHandler.read();
            }
        }catch (Exception exp){
            System.out.println(exp);
        }
    }
    public void readXML(){
        try{
            XMLFileHandler xmlFileHandler = new XMLFileHandler();
            xmlFileHandler.read();
        }catch (Exception exp){
            System.out.println(exp);
        }
    }

    public void readJSON(){
        try{
            JsonFileHandler jsonFileHandler = new JsonFileHandler();
            jsonFileHandler.read();
        }catch (Exception exp){
            System.out.println(exp);
        }
    }
}
