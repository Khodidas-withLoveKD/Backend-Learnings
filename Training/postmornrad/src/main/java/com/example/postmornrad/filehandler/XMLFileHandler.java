package com.example.postmornrad.filehandler;


import com.example.postmornrad.entity.EmployeeRedis;

import com.example.postmornrad.repository.EmployeeRepositoryRedis;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


public class XMLFileHandler  implements FileHandler {


    EmployeeRepositoryRedis employeeRepositoryRedis;

    public XMLFileHandler(EmployeeRepositoryRedis employeeRepositoryRedis){
        this.employeeRepositoryRedis= employeeRepositoryRedis;
    }



    // XMLFileHandler xmlFileHandler=new XMLFileHandler();
    public void read() throws Exception {


        try {
            //TODO
            File xmlFile = new File("/Users/vanditshihora/Downloads/postmornrad/src/main/java/com/example/postmornrad/employee.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(xmlFile);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("employee");

            //TODO
            for(int itr=0;itr<100;itr++){
                Node node = nodeList.item(itr);
                EmployeeRedis emp=new EmployeeRedis();
                if (node.getNodeType() == Node.ELEMENT_NODE){
                    Element e=(Element) node;
                    emp.setFirstName(e.getElementsByTagName("firstName").item(0).getTextContent());
                    emp.setLastName(e.getElementsByTagName("lastName").item(0).getTextContent());
                    //TODO
                    emp.setDateOfBirth(new SimpleDateFormat("dd/MM/yyyy").parse(e.getElementsByTagName("dateOfBirth").item(0).getTextContent()));
                    emp.setExperience(Double.parseDouble(e.getElementsByTagName("experience").item(0).getTextContent()));
                    employeeRepositoryRedis.save(emp);

                }
            }
        }
        catch (Exception e){
            System.out.println(e); // E
        }


    }


    public void write(){
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();
            Element rootElement = doc.createElement("employees");
            doc.appendChild(rootElement);
            Iterable<EmployeeRedis> employees = employeeRepositoryRedis.findAll();

            List<EmployeeRedis> employeeList = new ArrayList<>();
            employees.forEach(employeeList::add);



            for(EmployeeRedis emp:employees) {
                Element employeeElement= doc.createElement("employee");
                rootElement.appendChild(employeeElement);
                Element firstName=doc.createElement("firstName");
                firstName.appendChild(doc.createTextNode(emp.getFirstName()));
                employeeElement.appendChild(firstName);
                Element lastName=doc.createElement("lastName");
                lastName.appendChild(doc.createTextNode(emp.getLastName()));
                employeeElement.appendChild(lastName);
                Element dateOfBirth=doc.createElement("dateOfBirth");
                dateOfBirth.appendChild(doc.createTextNode(emp.getDateOfBirth()+""));
                employeeElement.appendChild(dateOfBirth);
                Element experience=doc.createElement("experience");
                experience.appendChild(doc.createTextNode(emp.getExperience()+""));
                employeeElement.appendChild(experience);
                // System.out.println(emp.getFirstName());

            }
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(doc);
            StreamResult streamResult = new StreamResult(new File("/Users/vanditshihora/Downloads/postmornrad/src/main/java/com/example/postmornrad/employeeoutput.xml"));
            transformer.transform(domSource, streamResult);
        }
        catch (Exception ex){
            System.out.println(ex);
        }
    }


}
