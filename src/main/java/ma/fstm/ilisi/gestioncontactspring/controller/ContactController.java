package ma.fstm.ilisi.gestioncontactspring.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import ma.fstm.ilisi.gestioncontactspring.model.bo.Contact;
import ma.fstm.ilisi.gestioncontactspring.model.bo.Type;
import ma.fstm.ilisi.gestioncontactspring.model.servise.ContactServise;
import ma.fstm.ilisi.gestioncontactspring.model.servise.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ContactController
{
    @Autowired
    private TypeService typeService;
    @Autowired
    private ContactServise contactServise;

    @RequestMapping("/")
    public String GethomePage(Model me){
        List<Contact> contacts =contactServise.getAllContacts();
        me.addAttribute("contacts",contacts);
        return "index";
    }
    @RequestMapping("/new")
    public String GetCreateContactPage(Model me)
    {
        List<Type> types=typeService.GetAllTypes();
        me.addAttribute("allType",types);
        Contact contact=new Contact();
        me.addAttribute("contact",contact);
        return "new_contact";
    }
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String saveContact(@ModelAttribute("contact") Contact contact){
        contactServise.insertContact(contact);
        return "redirect:/";
    }
    @RequestMapping("/edit/{id}")
    public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit_contact");
        Contact contact = contactServise.get(id);
        mav.addObject("contact", contact);
        List<Type> types=typeService.GetAllTypes();
        mav.addObject("allType",types);
        return mav;
    }
    @RequestMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") int id) {
        contactServise.deleteContact(contactServise.get(id));
        return "redirect:/";
    }
}
