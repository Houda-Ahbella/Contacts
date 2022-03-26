package ma.fstm.ilisi.gestioncontactspring.model.bo;
import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name = "types")
public class Type implements Serializable {

    @Id
    private String type;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "types")
    private Set<Contact> contacts = new HashSet<>();

    public Type() {
    }


    public Type(String type) {
        this.type = type;
    }
    public Type(String type, Set contactses) {
        this.type = type;
        this.contacts = contactses;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public Set<Contact> getContacts() {
        return this.contacts;
    }

    public void setContacts(Set contacts) {
        this.contacts = contacts;
    }

    @Override
    public String toString() {
        return type;
    }





}
