package JAXBPractice;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import java.text.ParseException;
import java.util.Date;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Main {
	
    public static void main(String[] args) throws JAXBException, IOException, ParseException {

      marshal();
     // Policies policies = unmarshal();
     // System.out.println(policies);
      
  }

  public static Policies unmarshal() throws JAXBException, IOException {
      JAXBContext context = JAXBContext.newInstance(Policies.class);
      return (Policies) context.createUnmarshaller()
              .unmarshal(new FileReader("policiesNoCustomers.xml"));
  }

  public static void marshal() throws JAXBException, IOException {
	  
	  Policy P10001 = new Policy(10001, new Customer(20001, "Yana", "Nehaeva", 27), new Date("12/12/2024"), new Date("12/12/2025"), 450);
	  Policy P10002 = new Policy(10002, new Customer(20002,"Akakii", "Borisovich", 42 ), new Date("28/10/2024"), new Date("28/10/2025"), 350);

      Policies policies = new Policies();
      List<Policy> list = new ArrayList<>();
      list.add(P10001);
      list.add(P10002);
      policies.setList(list);
      
      JAXBContext context = JAXBContext.newInstance(Policies.class);
      Marshaller mar= context.createMarshaller();
      mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
     // mar.marshal(policies, new File("policiesNoCustomers.xml"));
      mar.marshal(policies, new File("policiesWithCustomers.xml"));
  }
}
