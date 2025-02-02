package JAXBPractice;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "policies")
public class Policies {

    private List<Policy> list;

    public List<Policy> getList() {
        return list;
    }

    @XmlElement(name = "policy")
    public void setList(List<Policy> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Policies{" +
                "list=" + list +
                '}';
    }
}

