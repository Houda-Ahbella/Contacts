package ma.fstm.ilisi.gestioncontactspring.model.dao;

import ma.fstm.ilisi.gestioncontactspring.model.bo.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Integer> {
}
