import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.xml.sax.SAXException;
import java.text.ParseException;
import java.util.List;

public class XMLFileHandler implements MyFileHandler {

    MyCollection clc = MyCollection.getInstance();

    @Override
    public void read() {
        try {
            File file = new File("/Users/khodidaschauhan/Downloads/TeamThreeED/src/employee.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("employee");
            for (int itr = 0; itr < nodeList.getLength(); itr++) {
                Node node = nodeList.item(itr);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) node;
                    Employee emp = new Employee();
                    emp.setFirstName(eElement.getElementsByTagName("firstName").item(0).getTextContent());
                    emp.setLastName(eElement.getElementsByTagName("lastName").item(0).getTextContent());
                    emp.setDateOfBirth(new SimpleDateFormat("dd/MM/yyyy").parse(eElement.getElementsByTagName("dateOfBirth").item(0).getTextContent()));
                    emp.setExperience(Long.parseLong(eElement.getElementsByTagName("experience").item(0).getTextContent()));
                    clc.AddEmployee(emp);
                }
            }
        } catch (SAXException | ParserConfigurationException | IOException e1) {
            e1.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void write(Employee emp) {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder documentBuilder = dbFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();
            // root element
            Element root = document.createElement("employees");
            document.appendChild(root);
            Element employee = document.createElement("employee");
            root.appendChild(employee);

            Employee[] employees = clc.getList();
            for(int i=200;i<299;i++) {
                Employee emp12 = employees[i];
                // firstname element
                Element firstName = document.createElement("firstname");
                firstName.appendChild(document.createTextNode(emp12.firstName));
                employee.appendChild(firstName);
                // lastname element
                Element lastname = document.createElement("lastname");
                lastname.appendChild(document.createTextNode(emp12.lastName));
                employee.appendChild(lastname);
                /* dateOfBirth element */
                Element dateOfBirth = document.createElement("DateOfBirth");
                dateOfBirth.appendChild(document.createTextNode(String.valueOf(emp12.dateOfBirth)));
                employee.appendChild(dateOfBirth);
            }
            // create the xml file
            //transform the DOM Object to an XML File
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File("/Users/khodidaschauhan/Downloads/TeamThreeED/src/newEmployeeXML.xml"));
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