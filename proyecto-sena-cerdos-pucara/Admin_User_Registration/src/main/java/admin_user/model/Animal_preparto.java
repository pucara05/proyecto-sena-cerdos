package admin_user.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.Column;
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
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Animal_preparto {
    
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

private Long dni;

@Column(name = "dni_preparto_hembra")
private  String dniPrepartoHembra;


@Temporal(TemporalType.DATE)
@DateTimeFormat(iso = ISO.DATE)
@NonNull
private  Date fechaPreparto;

private String estadoSalud;


@ManyToOne
@JoinColumn(name = "animal_monta_id")
private Animal_monta monta;


}
