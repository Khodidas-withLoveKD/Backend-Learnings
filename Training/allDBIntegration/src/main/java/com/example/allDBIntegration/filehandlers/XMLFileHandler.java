package com.example.allDBIntegration.filehandlers;

import com.example.allDBIntegration.entities.XMLEmployee;
import com.example.allDBIntegration.services.XMLServices;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class XMLFileHandler implements FileHandler{

    XMLServices xmlServices;
    int counter;

    public XMLFileHandler(XMLServices xmlServices) {
        this.xmlServices = xmlServices;
        counter = 0;
    }

    @Override
    public void read() {
        try {
            File file = new File("/Users/khodidaschauhan/Downloads/allDBIntegration/src/main/java/com/example/allDBIntegration/employee.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("employee");
            for (int itr = 0; itr < nodeList.getLength(); itr++) {
                Node node = nodeList.item(itr);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) node;
                    XMLEmployee emp = new XMLEmployee();
                    emp.setId(counter++);
                    emp.setFirstName(eElement.getElementsByTagName("firstName").item(0).getTextContent());
                    emp.setLastName(eElement.getElementsByTagName("lastName").item(0).getTextContent());
                    emp.setDateOfBirth(new SimpleDateFormat("dd/MM/yyyy").parse(eElement.getElementsByTagName("dateOfBirth").item(0).getTextContent()));
                    emp.setExperience(Long.parseLong(eElement.getElementsByTagName("experience").item(0).getTextContent()));

                    //add write logic here
                    xmlServices.save(emp);
                    System.out.println("XMLEmp: "+emp);
                }
            }
        } catch (SAXException | ParserConfigurationException | IOException e1) {
            e1.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void write() {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder documentBuilder = dbFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();
            // root element
            Element root = document.createElement("employees");
            document.appendChild(root);
            Element employee = document.createElement("employee");
            root.appendChild(employee);

            List<XMLEmployee> employees = xmlServices.findAll();
            for(int i=0;i<100;i++) {
                XMLEmployee emp12 = employees.get(i);

                // firstname element
                Element firstName = document.createElement("firstname");
                firstName.appendChild(document.createTextNode(emp12.getFirstName()));
                employee.appendChild(firstName);

                // lastname element
                Element lastname = document.createElement("lastname");
                lastname.appendChild(document.createTextNode(emp12.getLastName()));
                employee.appendChild(lastname);

                /* dateOfBirth element */
                Element dateOfBirth = document.createElement("DateOfBirth");
                dateOfBirth.appendChild(document.createTextNode(String.valueOf(emp12.getDateOfBirth())));
                employee.appendChild(dateOfBirth);

                System.out.println("XMLEmployee: "+emp12);
            }
            // create the xml file
            //transform the DOM Object to an XML File
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File("/Users/khodidaschauhan/Downloads/allDBIntegration/src/main/java/com/example/allDBIntegration/employeeWrite.xml"));
            // If you use
            // StreamResult result = new StreamResult(System.out);
            // the output will be pushed to the standard output ...
            // You can use that for debugging
            transformer.transform(domSource, streamResult);
            System.out.println("Done creating XML File");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

