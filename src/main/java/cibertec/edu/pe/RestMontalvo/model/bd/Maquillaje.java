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
    private Integer id_maquillaje;
    @Column(name="precio_maquillaje")
    private String precio_maquillaje;
    @Column(name="tiempo_maquillaje")
    private String tiempo_maquillaje;

    @ManyToOne
    @JoinColumn(name="id_desc_maquillaje")
    private DescMaquillaje descmaquillaje;
}
