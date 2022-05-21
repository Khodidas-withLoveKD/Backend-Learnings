package com.example.allDBIntegration.maincontroller;

import com.example.allDBIntegration.ReaderThread;
import com.example.allDBIntegration.WriterThread;
import com.example.allDBIntegration.services.CSVServices;
import com.example.allDBIntegration.filehandlers.CSVFileHandler;
import com.example.allDBIntegration.filehandlers.JSONFileHandler;
import com.example.allDBIntegration.filehandlers.XMLFileHandler;
import com.example.allDBIntegration.services.JSONServices;
import com.example.allDBIntegration.services.XMLServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping
public class MainController {

    @Autowired
    XMLServices xmlServices;

    @Autowired
    JSONServices jsonServices;

    @Autowired
    CSVServices csvServices;

    @GetMapping (value = "/employee")
    public void startAll() throws Exception{

        Thread jsonReaderThread = new ReaderThread(new JSONFileHandler(jsonServices));
        Thread csvReaderThread = new ReaderThread(new CSVFileHandler(csvServices));
        Thread xmlReaderThread = new ReaderThread(new XMLFileHandler(xmlServices));

        jsonReaderThread.start();
        csvReaderThread.start();
        xmlReaderThread.start();

        jsonReaderThread.join();
        csvReaderThread.join();
        xmlReaderThread.join();

        Thread jsonWriterThread = new WriterThread(new JSONFileHandler(jsonServices));
        Thread csvWriterThread = new WriterThread(new CSVFileHandler(csvServices));
        Thread xmlWriterThread = new WriterThread(new XMLFileHandler(xmlServices));

        jsonWriterThread.start();
        csvWriterThread.start();
        xmlWriterThread.start();

        jsonWriterThread.join();
        csvWriterThread.join();
        xmlWriterThread.join();

    }

}
