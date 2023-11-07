package admin_user.service;


import admin_user.model.Animal_for_user;
import admin_user.model.CerdoRegistro;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface CerdoRegistroService {

   // primer metodo 1  CerdoRegistro save (CerdoRegistroDto cerdoRegistroDto);

//CerdoRegistro registarCerdo(CerdoRegistroDto cerdoRegistroDto);

// falta arreglar este metodo ->    CerdoRegistro registarCerdo(CerdoRegistroDto cerdoRegistroDto);

public void crearUsuario(CerdoRegistro cerdoRegistro);
      


    

      public List<CerdoRegistro>obtenerTodosLosUsuarios();

      //metodo buscar por id si sirve 
 public CerdoRegistro obtenerAnimalPorId(Long id) ;

}
