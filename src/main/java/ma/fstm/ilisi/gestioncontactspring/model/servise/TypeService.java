package ma.fstm.ilisi.gestioncontactspring.model.servise;

import ma.fstm.ilisi.gestioncontactspring.model.bo.Type;
import ma.fstm.ilisi.gestioncontactspring.model.dao.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TypeService {
    @Autowired
    private TypeRepository repository;

    public List<Type> GetAllTypes(){
        return repository.findAll();
    }
    public Optional<Type> getByid(String id){
        return repository.findById(id);
    }
}
