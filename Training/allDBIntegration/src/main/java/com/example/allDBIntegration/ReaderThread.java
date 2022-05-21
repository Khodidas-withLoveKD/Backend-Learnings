package com.example.allDBIntegration;

import com.example.allDBIntegration.filehandlers.FileHandler;

public class ReaderThread extends Thread {
    private FileHandler fileHandler;

    public ReaderThread(FileHandler fileHandler) {
        this.fileHandler = fileHandler;
    }

    @Override
    public void run(){
        fileHandler.read();
    }
}
