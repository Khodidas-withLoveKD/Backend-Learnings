package com.example.allDBIntegration;

import com.example.allDBIntegration.filehandlers.FileHandler;

public class WriterThread extends Thread {
    private FileHandler fileHandler;

    public WriterThread(FileHandler fileHandler) {
        this.fileHandler = fileHandler;
    }

    @Override
    public void run(){
        fileHandler.write();
    }
}
