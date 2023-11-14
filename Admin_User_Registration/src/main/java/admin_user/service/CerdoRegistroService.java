package admin_user.service;



import admin_user.model.CerdoRegistro;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface CerdoRegistroService {

 

public void crearUsuario(CerdoRegistro cerdoRegistro);
      


    

      public List<CerdoRegistro>obtenerTodosLosUsuarios();

      //metodo buscar por id si sirve 
 public CerdoRegistro obtenerAnimalPorId(Long id) ;

}
