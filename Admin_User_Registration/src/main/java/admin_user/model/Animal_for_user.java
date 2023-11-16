package admin_user.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import java.util.List;

//Entida Animal for user se esta usando por cerdoRegistro codigo de cerdoRegistro comentado 
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Animal_for_user {
 @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  private Long dni;
  private String raza;

  private Long peso;

  @Temporal(TemporalType.DATE)
  @DateTimeFormat(iso = ISO.DATE)
  @NonNull
  private Date fechaNacimientoCerdo;

  private String sexo;

 

  // Relación One-to-Many con Animal_celo
    @OneToMany(targetEntity = Animal_celo.class,fetch = FetchType.LAZY,mappedBy ="animalForUser" )
    private List<Animal_celo> celos;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;  

  @ManyToOne
  @JoinColumn(name = "animal_id")
  private Animal animal;

}