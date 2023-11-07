package admin_user.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

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
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Animal_for_user {
 @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  private int dni;
  private String raza;

  private Long peso;

  @Temporal(TemporalType.DATE)
  @DateTimeFormat(iso = ISO.DATE)
  @NonNull
  private Date fechaNacimientoCerdo;

 

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  @ManyToOne
  @JoinColumn(name = "animal_id")
  private Animal animal;

}