package cibertec.edu.pe.RestMontalvo.model.bd;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@Entity
@Table(name="maquillaje")
public class Maquillaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idmaquillaje;
    @Column(name="preciomaquillaje")
    private String preciomaquillaje;
    @Column(name="tiempomaquillaje")
    private String tiempomaquillaje;

    @ManyToOne
    @JoinColumn(name="iddescmaquillaje")
    private DescMaquillaje descmaquillaje;
}
