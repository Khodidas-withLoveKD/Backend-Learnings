package com.example.employeecollection.threads;

import com.example.employeecollection.handler.MyFileHandler;

public class ReadThread extends Thread {
    MyFileHandler myFileHandler;

    public ReadThread(MyFileHandler myFileHandler){
        this.myFileHandler = myFileHandler;
    }

    @Override
    public void run() {
        try {
            myFileHandler.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
