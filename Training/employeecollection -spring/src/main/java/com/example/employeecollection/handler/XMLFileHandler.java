package com.example.employeecollection.handler;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.OutputKeys;

import com.example.employeecollection.entity.EmployeeRedix;
import com.example.employeecollection.services.EmployeeServicesRedix;
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
import java.util.List;

public class XMLFileHandler implements MyFileHandler {
    //MyCollection myCollection;
    EmployeeServicesRedix employeeServicesRedix;
    private static final String absoulatePath = "/Users/mananpatel/IdeaProjects/EmployeeCollection/data/";

    public XMLFileHandler(EmployeeServicesRedix employeeServicesRedix) {
        this.employeeServicesRedix = employeeServicesRedix;
    }

    @Override
    public void read() throws Exception{
        try {
            File file = new File(absoulatePath+"/employee.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc;
            doc = db.parse(file);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("employee");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                Element element=(Element)node;
                EmployeeRedix employee = new EmployeeRedix(element.getElementsByTagName("firstName").item(0).getTextContent(),
                        element.getElementsByTagName("lastName").item(0).getTextContent(),
                        new SimpleDateFormat("MM/dd/yyyy").parse(element.getElementsByTagName("dateOfBirth").item(0).getTextContent()),
                        Double.parseDouble(element.getElementsByTagName("experience").item(0).getTextContent()));
                //myCollection.add(employee);
                if (employee != null)
                    employeeServicesRedix.save(employee);
                System.out.println(employee.toString());
            }
        }
        catch (Exception exp){
            throw new Exception(exp);
        }
    }

    @Override
    public void write() throws Exception {
        try
        {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
            Document document = documentBuilder.newDocument();
            Element root = document.createElement("Employees");
            document.appendChild(root);

            EmployeeRedix employee;
            List<EmployeeRedix> employeeRedixList = employeeServicesRedix.findAll();
            for(int i = 0; i < Math.min(100 , employeeRedixList.size()); i++) {
                employee = employeeRedixList.get(i);
                if (null == employee){
                    break;
                }

                Element employeeElement = document.createElement("Employee");
                Element firstName = document.createElement("firstName");
                firstName.setTextContent(employee.getFirstName());
                Element lastName = document.createElement("lastName");
                lastName.setTextContent(employee.getLastName());
                Element dateOfBirth = document.createElement("dateOfBirth");
                DateFormat df = new SimpleDateFormat("dd/mm/yyyy");
                String dob = df.format(employee.getDateOfBirth());
                dateOfBirth.setTextContent(dob);
                Element experience = document.createElement("experience");
                experience.setTextContent(employee.getExperience());
                employeeElement.appendChild(firstName);
                employeeElement.appendChild(lastName);
                employeeElement.appendChild(dateOfBirth);
                employeeElement.appendChild(experience);
                root.appendChild(employeeElement);
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File(absoulatePath+"employee2.xml"));
            transformer.transform(domSource, streamResult);
        }
        catch (Exception e){
            throw new Exception(e);
        }
    }
}
