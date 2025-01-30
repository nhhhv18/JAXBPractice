package xmlPractice;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InsuranceCompanyParser {

    public static void main(String[] args) {
        try {
        	InputStream xmlStream = InsuranceCompanyParser.class.getClassLoader().getResourceAsStream("insuranceCompany.xml");

            if (xmlStream == null) {
                throw new RuntimeException("XML file not found in resources!");
            }

            // Parse XML
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = builder.parse(xmlStream);
            doc.getDocumentElement().normalize();

            // Call parsing methods
            parseCompany(doc);
            parsePolicies(doc);
            parseCustomers(doc);
            parseAgents(doc);
            parseClaims(doc);
            parsePayments(doc);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to parse the <Company> element
    public static void parseCompany(Document doc) {
        NodeList companyList = doc.getElementsByTagName("Company");
        Node firstCompanyNode = companyList.item(0);

         assertEquals(1, companyList.getLength());
         assertEquals(Node.ELEMENT_NODE, firstCompanyNode.getNodeType());
         assertEquals("Company", firstCompanyNode.getNodeName());

        System.out.println("Parsing Company...");
        System.out.println("Company Name: " + ((Element) firstCompanyNode).getAttribute("name"));
    }

    // Method to parse the <Policy> elements
    public static void parsePolicies(Document doc) {
        NodeList policies = doc.getElementsByTagName("Policy");

         assertEquals(2, policies.getLength());

        System.out.println("Parsing Policies...");
        for (int i = 0; i < policies.getLength(); i++) {
            Node policyNode = policies.item(i);
            Element policyElement = (Element) policyNode;

            String policyId = policyElement.getAttribute("id");
            String policyType = policyElement.getAttribute("type");

            System.out.println("Policy ID: " + policyId + ", Type: " + policyType);
        }
    }

    // Method to parse the <Customer> elements
    public static void parseCustomers(Document doc) {
        NodeList customers = doc.getElementsByTagName("Customer");

         assertEquals(2, customers.getLength());

        System.out.println("Parsing Customers...");
        for (int i = 0; i < customers.getLength(); i++) {
            Node customerNode = customers.item(i);
            Element customerElement = (Element) customerNode;

            String customerId = customerElement.getAttribute("id");
            String name = customerElement.getElementsByTagName("Name").item(0).getTextContent();
            String age = customerElement.getElementsByTagName("Age").item(0).getTextContent();
            String address = customerElement.getElementsByTagName("Address").item(0).getTextContent();

            System.out.println("Customer ID: " + customerId);
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Address: " + address);
        }
    }

    // Method to parse the <Agent> elements
    public static void parseAgents(Document doc) {
        NodeList agents = doc.getElementsByTagName("Agent");

        assertEquals(1, agents.getLength());

        System.out.println("Parsing Agents...");
        for (int i = 0; i < agents.getLength(); i++) {
            Node agentNode = agents.item(i);
            Element agentElement = (Element) agentNode;

            String agentId = agentElement.getAttribute("id");
            String agentType = agentElement.getElementsByTagName("Type").item(0).getTextContent();

            System.out.println("Agent ID: " + agentId);
            System.out.println("Agent Type: " + agentType);
        }
    }

    // Method to parse the <Claim> elements
    public static void parseClaims(Document doc) {
        NodeList claims = doc.getElementsByTagName("Claim");

         assertEquals(1, claims.getLength());

        System.out.println("Parsing Claims...");
        for (int i = 0; i < claims.getLength(); i++) {
            Node claimNode = claims.item(i);
            Element claimElement = (Element) claimNode;

            String claimId = claimElement.getAttribute("id");
            String policyId = claimElement.getElementsByTagName("PolicyId").item(0).getTextContent();
            String amount = claimElement.getElementsByTagName("Amount").item(0).getTextContent();
            String description = claimElement.getElementsByTagName("Description").item(0).getTextContent();
            String status = claimElement.getElementsByTagName("Status").item(0).getTextContent();

            System.out.println("Claim ID: " + claimId);
            System.out.println("Policy ID: " + policyId);
            System.out.println("Amount: " + amount);
            System.out.println("Description: " + description);
            System.out.println("Status: " + status);
        }
    }

    // Method to parse the <Payment> elements
    public static void parsePayments(Document doc) {
        NodeList payments = doc.getElementsByTagName("Payment");

         assertEquals(2, payments.getLength());

        System.out.println("Parsing Payments...");
        for (int i = 0; i < payments.getLength(); i++) {
            Node paymentNode = payments.item(i);
            Element paymentElement = (Element) paymentNode;

            String paymentId = paymentElement.getAttribute("id");
            String policyId = paymentElement.getElementsByTagName("PolicyId").item(0).getTextContent();
            String amount = paymentElement.getElementsByTagName("Amount").item(0).getTextContent();
            String date = paymentElement.getElementsByTagName("Date").item(0).getTextContent();
            String status = paymentElement.getElementsByTagName("Status").item(0).getTextContent();

            System.out.println("Payment ID: " + paymentId);
            System.out.println("Policy ID: " + policyId);
            System.out.println("Amount: " + amount);
            System.out.println("Date: " + date);
            System.out.println("Status: " + status);
        }
    }
}
