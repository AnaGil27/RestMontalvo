package cibertec.edu.pe.RestMontalvo.model.bd;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Entity
@Table(name="peinado")
public class Peinado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_peinado;
    @Column(name="precio_peinado")
    private String precio_peinado;
    @Column(name="tiempo_peinado")
    private String tiempo_peinado;

    @ManyToOne
    @JoinColumn(name="id_desc_peinado")
    private DescPeinado descpeinado;
}