package JAXBPractice;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlTransient;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import java.util.Date;
import java.util.Objects;


import java.util.Objects;

@XmlType(propOrder = { "firstName", "lastName", "age" })
public class Customer {
	private int id;
	private String firstName;
	private String lastName;
	private int age;
	
    public Customer(int id, String firstName, String lastName, int age) {
    	this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }


    public Customer() {
    }

	public int getId() {
        return id;
    }

    @XmlAttribute
    public void setId(int id) {
        this.id = id;  
    }
    
    public String getFirstName() {
        return firstName;
    }
    @XmlElement
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    @XmlElement
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }
    @XmlElement
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Customer{" +
    "id='" + id + '\'' +
    ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Customer customer = (Customer) obj;
        return age == customer.age &&
        		Objects.equals(id, customer.id) &&
                Objects.equals(firstName, customer.firstName) &&
                Objects.equals(lastName, customer.lastName) &&
                Objects.equals(age, customer.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, age);
    }
}
