package admin_user.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnimalCeloDTO {
     private Long id;
     private Long dni;
    //private String dniCelo;
    private Long cerdoHembraId;
    private String sexoHembra;
    private Date fechaCelo;


    // Agregar campos de Animal_for_user que deseas incluir en el DTO   
    private Long animalForUserId; // Id de Animal_for_user
    private String sexoAnimalForUser; // Sexo de Animal_for_user




    


}
