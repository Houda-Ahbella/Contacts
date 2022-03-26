package ma.fstm.ilisi.gestioncontactspring.model.dao;

import ma.fstm.ilisi.gestioncontactspring.model.bo.Type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRepository extends JpaRepository<Type,String> {
}
