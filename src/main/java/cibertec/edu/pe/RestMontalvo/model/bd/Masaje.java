package cibertec.edu.pe.RestMontalvo.model.bd;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@Entity
@Table(name="masaje")
public class Masaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idmasaje;
    @Column(name = "tiempomasaje")
    private String tiempomasaje;
    @Column(name = "preciomasaje")
    private String preciomasaje;

    @ManyToOne
    @JoinColumn(name = "iddescmasaje")
    private DescMasaje descmasaje;
}