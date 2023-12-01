package admin_user.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnimalMontaDto {



private Long dni;


@Temporal(TemporalType.DATE)
@DateTimeFormat(iso = ISO.DATE)
@NonNull
private Date fechaMonta;



    
}
