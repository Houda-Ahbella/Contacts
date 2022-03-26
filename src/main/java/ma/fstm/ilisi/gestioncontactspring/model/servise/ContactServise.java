package ma.fstm.ilisi.gestioncontactspring.model.servise;


import ma.fstm.ilisi.gestioncontactspring.model.bo.Contact;
import ma.fstm.ilisi.gestioncontactspring.model.bo.Type;
import ma.fstm.ilisi.gestioncontactspring.model.dao.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ContactServise
{
    @Autowired
    private ContactRepository repository;

    public boolean insertContact(Contact contact){
        if(checkWrongContact(contact))return false;
        repository.save(contact);
        return true;
    }
    public boolean Update_Contact(Contact con)
    {
        /*if(checkWrongContact(Nom, Prenom, tel, email))return false;
        con.setEmail(email);
        con.setNom(Nom);
        con.setTel(tel);
        con.setPrenom(Prenom);
        con.setTypes(type);
        repository.save(con);*/
        return true;
    }
    private boolean checkWrongContact(Contact contact){
        if(contact.getNom().equals("")||contact.getPrenom().equals("")||contact.getTel().equals("")||contact.getEmail().equals(""))return true;
        if(!contact.getTel().matches("[+]212([0-9]){9}"))return true;
        if(!contact.getEmail().matches(".+@.+"))return true;
        return false;
    }
    public void deleteContact(Contact c){
        repository.delete(c);
    }
    public List<Contact> getAllContacts(){
        return repository.findAll();
    }

    public Contact get(int id) {
        return repository.getById(id);
    }


}
