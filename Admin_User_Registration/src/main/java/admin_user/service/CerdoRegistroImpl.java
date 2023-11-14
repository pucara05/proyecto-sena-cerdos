package admin_user.service;

import admin_user.model.CerdoRegistro;
import java.util.List;
import admin_user.repositories.CerdoRegistroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CerdoRegistroImpl implements CerdoRegistroService {

    @Autowired
    CerdoRegistroRepository cerdoRegistroRepository;



    // metodo para listar sirve
    public List<CerdoRegistro> obtenerTodosLosUsuarios() {
        return cerdoRegistroRepository.findAll();
    }

    // metodo crear cerdo si sirve
    @Override
    public void crearUsuario(CerdoRegistro cerdoRegistro) {
        cerdoRegistroRepository.save(cerdoRegistro);
    }

    // metodo buscar cerdo por id
    @Override
    public CerdoRegistro obtenerAnimalPorId(Long id) {
        return cerdoRegistroRepository.findById(id).orElse(null);
    }

}
