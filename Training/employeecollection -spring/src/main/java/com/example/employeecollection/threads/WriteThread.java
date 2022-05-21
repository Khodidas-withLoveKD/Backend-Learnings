package com.example.employeecollection.threads;

import com.example.employeecollection.handler.MyFileHandler;

public class WriteThread extends Thread {
    MyFileHandler myFileHandler;

    public WriteThread(MyFileHandler myFileHandler){
        this.myFileHandler = myFileHandler;
    }

    @Override
    public void run() {
        try {
            myFileHandler.write();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
