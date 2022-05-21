package com.example.postmornrad;


import com.example.postmornrad.filehandler.FileHandler;

public class ReadThread extends Thread {
    private FileHandler myFileHandler ;
    public ReadThread(FileHandler myFileHandler) {
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
