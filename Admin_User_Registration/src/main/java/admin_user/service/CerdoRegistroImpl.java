package admin_user.service;
import admin_user.model.Animal_for_user;
import admin_user.model.CerdoRegistro;
import java.util.List;
import admin_user.repositories.CerdoRegistroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CerdoRegistroImpl implements CerdoRegistroService {

    @Autowired
    CerdoRegistroRepository cerdoRegistroRepository;

  

   /* metodo 1
   @Override
    public CerdoRegistro save(CerdoRegistroDto cerdoRegistroDto) {
        Date fechaNacimiento = cerdoRegistroDto.getFecha_nacimiento_cerdo();
       CerdoRegistro  cerdo = new CerdoRegistro (cerdoRegistroDto.getNombreDelCerdo(),cerdoRegistroDto.getRaza_cerdo(),cerdoRegistroDto.getPeso_actual_cerdo(),fechaNacimiento);
        return cerdoRegistroRepository.save(cerdo);
    }

    */


   

    /*  arreglar este metodo para crear 
@Override
   public  CerdoRegistro registarCerdo(CerdoRegistroDto cerdoRegistroDto) {

        try {
            Date  fechaNacimiento  = cerdoRegistroDto.getFechaNacimientoCerdo();
       // SimpleDateFormat fechaNacimiento = new SimpleDateFormat("yyyy-MM-dd");
       // String fecha = fechaNacimiento.format(date);
            CerdoRegistro cerdoRegistro = new CerdoRegistro(cerdoRegistroDto.getNombreDelCerdo(),cerdoRegistroDto.getRaza_cerdo(),cerdoRegistroDto.getPeso_actual_cerdo(), fechaNacimiento);
            return  cerdoRegistroRepository.save(cerdoRegistro);
        } catch (Exception e){

            // Combina el mensaje personalizado con el mensaje de la excepción original
            String mensaje = "Ocurrió un error al guardar el cerdo. Detalles: " + e.getMessage();
            e.printStackTrace(); // Esto imprimirá la traza de la excepción en la consola
            throw new RuntimeException(mensaje); // Puedes lanzar la excepción original o una nueva con el mensaje personalizado

        }


    }   
    */




//metodo para listar servia en testController
    public List<CerdoRegistro>obtenerTodosLosUsuarios(){
        return  cerdoRegistroRepository.findAll();
        }
    
    
//metodo crear cerdo si sirve 
        @Override
        public void crearUsuario(CerdoRegistro cerdoRegistro){
        cerdoRegistroRepository.save(cerdoRegistro);
            }
        




            //metodo buscar cerdo por id 
            @Override
            public CerdoRegistro obtenerAnimalPorId(Long id) {
                return cerdoRegistroRepository.findById(id).orElse(null);
            }
            


}
