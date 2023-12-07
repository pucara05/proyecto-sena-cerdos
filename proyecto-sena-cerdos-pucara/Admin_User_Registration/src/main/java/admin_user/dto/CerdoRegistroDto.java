package admin_user.dto;

import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class CerdoRegistroDto {

    private String nombreDelCerdo;

    private String raza_cerdo;

    private Long peso_actual_cerdo;

    private Date fechaNacimientoCerdo;


}
