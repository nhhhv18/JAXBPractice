package JAXBPractice;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlTransient;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import java.util.Date;
import java.util.Objects;


@XmlType(propOrder = { "customer", "startDate", "endDate", "coverageAmount"  })
//@XmlType(propOrder = { "startDate", "endDate", "coverageAmount"  })
public class Policy {

	private int id; 
	private Customer customer;
	private Date startDate;
	private Date endDate;
	private int coverageAmount;
	
	
	   public Policy(int id, Customer customer, Date startDate, Date endDate, int coverageAmount) {
	        this.id = id;
	        this.customer = customer;
	        this.startDate = startDate;
	        this.endDate = endDate;
	        this.coverageAmount = coverageAmount;
	    }
	   
	   public Policy () {}
	   
	public int getId() {
	        return id;
	    }

	    @XmlAttribute
	    public void setId(int id) {
	        this.id = id;  
	    }
	    
	    public Customer getCustomer() {
	        return customer;
	    }
	    
	 @XmlElement
	 //   @XmlTransient
	    public void setCustomer(Customer customer) {
	        this.customer = customer;
	    }

	    
	    public Date getStartDate() {
	        return startDate;
	    }
	    @XmlJavaTypeAdapter(DateAdapter.class)
	    @XmlElement
	    public void setStartDate(Date startDate) {
	        this.startDate = startDate;
	    }
	    
	    
	    public Date getEndDate() {
	        return endDate;
	    }
	    @XmlJavaTypeAdapter(DateAdapter.class)
	    @XmlElement
	    public void setEndDate(Date endDate) {
	        this.endDate = endDate;
	    }
	    
	    public int getCoverageAmount() {
	    	return coverageAmount;
	    }
	    @XmlElement
	    public void setCoverageAmount(int coverageAmount) {
	    	this.coverageAmount = coverageAmount;
	    }
	    
	    
	   
@Override
public String toString() {
    return "Policy{" +
            "id=" + id +
            ", customer=" + customer +
            ", startDate=" + startDate +
            ", endDate=" + endDate +
            ", coverageAmount=" + coverageAmount +
            '}';
}


@Override
public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Policy policy = (Policy) obj;
    return id == policy.id &&
    		customer == policy.customer &&
            coverageAmount == policy.coverageAmount &&
            Objects.equals(startDate, policy.startDate) &&
            Objects.equals(endDate, policy.endDate);
}

@Override
public int hashCode() {
    return Objects.hash(id, customer, startDate, endDate, coverageAmount);
}
	
}
