package com.example.employeecollection.services.impl;

import com.example.employeecollection.entity.EmployeeRedix;
import com.example.employeecollection.handler.MyFileHandler;
import com.example.employeecollection.repository.EmployeeRepositoryRedix;
import com.example.employeecollection.services.EmployeeServicesRedix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.OutputKeys;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import java.text.DateFormat;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.text.SimpleDateFormat;

@Service
public class EmployeeServicesImplRedix implements EmployeeServicesRedix {
    @Autowired
    EmployeeRepositoryRedix employeeRepositoryRedix;

    @Override
    public EmployeeRedix save(EmployeeRedix employee) {
        return employeeRepositoryRedix.save(employee);
    }

    @Override
    public EmployeeRedix findById(int id) {
        return employeeRepositoryRedix.findById(id).get();
    }

    @Override
    public void deleteById(int id) {
        employeeRepositoryRedix.deleteById(id);
    }

    @Override
    public List<EmployeeRedix> findAll() {
        Iterable<EmployeeRedix> employeeIterable = employeeRepositoryRedix.findAll();
        List<EmployeeRedix> employeeList = new ArrayList<>();
        employeeIterable.forEach(employeeList :: add);
        return employeeList;
    }
}


