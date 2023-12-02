package cibertec.edu.pe.RestMontalvo.model.bd;

import jakarta.persistence.*;
import lombok.*;


@Data
@NoArgsConstructor
@Entity
@Table(name="descpeinado")
public class DescPeinado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer iddescpeinado;
    @Column(name="nombrepeinado")
    private String nombrepeinado;
}