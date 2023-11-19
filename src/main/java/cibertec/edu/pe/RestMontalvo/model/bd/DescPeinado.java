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
    private Integer id_desc_peinado;
    @Column(name="desc_peinado")
    private String desc_peinado;
}