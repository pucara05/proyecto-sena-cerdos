package admin_user.model;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Animal_celo {

  @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long dniCelo;
   
    

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = ISO.DATE)
    @NonNull
    private Date fechaCelo;


   // Relación ManyToOne con Animal_for_user
   @ManyToOne
   @JoinColumn(name = "dniCerdoHembra") // Nombre de la columna que referencia al cerdo hembra
   private Animal_for_user cerdoHembra; // Referencia al cerdo hembra

    


      // Relación con Animal_for_user de sexo hembra
     /*  @ManyToOne
      @JoinColumn(name = "dniCerdoHembra", referencedColumnName = "dni")
      private Animal_for_user animalHembra;
*/

   /* @ManyToOne
    @JoinColumn(name = "animal_for_user_id") // Nombre de la columna en la tabla que contiene la relación
    private Animal_for_user animalForUser;
*/
  
   // @ManyToOne(targetEntity = Animal_for_user.class)
    //private Animal_for_user animalForUser;
   
    
}
