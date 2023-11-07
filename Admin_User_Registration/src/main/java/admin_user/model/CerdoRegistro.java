package admin_user.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "registro_cerdos")
public class CerdoRegistro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cerdo;

    private String nombreDelCerdo;

    private String raza_cerdo;

    private Long peso_actual_cerdo;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = ISO.DATE)
    @NonNull
    private Date fechaNacimientoCerdo;


    public CerdoRegistro(String nombreDelCerdo, String raza_cerdo, Long peso_actual_cerdo, Date fechaNacimientoCerdo) {
        this.nombreDelCerdo = nombreDelCerdo;
        this.raza_cerdo = raza_cerdo;
        this.peso_actual_cerdo = peso_actual_cerdo;
        this.fechaNacimientoCerdo = fechaNacimientoCerdo;
    }
}
