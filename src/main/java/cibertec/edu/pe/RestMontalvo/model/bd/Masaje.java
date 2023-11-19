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
    private Integer id_masaje;
    @Column(name = "tiempo_masaje")
    private String tiempo_masaje;
    @Column(name = "precio_masaje")
    private String precio_masaje;

    @ManyToOne
    @JoinColumn(name = "id_desc_masaje")
    private DescMasaje descmasaje;
}