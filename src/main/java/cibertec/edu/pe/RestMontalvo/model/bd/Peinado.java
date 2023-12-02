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
    private Integer idpeinado;
    @Column(name="preciopeinado")
    private String preciopeinado;
    @Column(name="tiempopeinado")
    private String tiempopeinado;

    @ManyToOne
    @JoinColumn(name="iddescpeinado")
    private DescPeinado descpeinado;
}