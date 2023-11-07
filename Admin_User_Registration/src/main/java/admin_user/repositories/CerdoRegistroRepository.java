package admin_user.repositories;

import admin_user.model.CerdoRegistro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CerdoRegistroRepository extends JpaRepository<CerdoRegistro, Long> {

  // List<CerdoRegistro> findByNombre_cerdo(String name);



}
