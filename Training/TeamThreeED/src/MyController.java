public class MyController extends Thread{
    public MyController(String name){
        super(name);
    }

    public void run(){
        if((String)Thread.currentThread().getName() == "CSVThread"){
            ReadThread readThread = new ReadThread();
            readThread.readCSV();
        }
        else if((String)Thread.currentThread().getName() == "JSONThread"){
            ReadThread readThread = new ReadThread();
            readThread.readJSON();
        }
        else if((String)Thread.currentThread().getName() == "XMLThread"){
            ReadThread readThread = new ReadThread();
            readThread.readXML();
        }
        else if((String)Thread.currentThread().getName() == "CSVThreadWrite"){
            WriteThread writeThread = new WriteThread();
            writeThread.writeCSV();
        }
        else if((String)Thread.currentThread().getName() == "JSONThreadWrite"){
            WriteThread writeThread = new WriteThread();
            writeThread.writeJSON();
        }
        else if((String)Thread.currentThread().getName() == "XMLThreadWrite"){
            WriteThread writeThread = new WriteThread();
            writeThread.writeXML();
        }
    }
    public static void main(String[] args) {
        try {
            MyController thread1 = new MyController("CSVThread");
            thread1.start();
            MyController thread2 = new MyController("JSONThread");
            thread2.start();
            MyController thread3 = new MyController("XMLThread");
            thread3.start();
            thread1.join();
            thread2.join();
            thread3.join();

            MyCollection myCollection = MyCollection.getInstance();
            System.out.println(myCollection.getReadCounter());

            MyController thread1Write = new MyController("CSVThreadWrite");
            thread1Write.start();
            MyController thread2Write = new MyController("JSONThreadWrite");
            thread2Write.start();
            MyController thread3Write = new MyController("XMLThreadWrite");
            thread3Write.start();
            thread1Write.join();
            thread2Write.join();
            thread3Write.join();

        }catch (Exception exp){
            System.out.println(exp);
        }
    }
}
