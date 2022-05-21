package com.example.postmornrad;


import com.example.postmornrad.filehandler.FileHandler;

public class WriteThread extends Thread {
    FileHandler myFileHandler ;
    public WriteThread(FileHandler myFileHandler) {
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
