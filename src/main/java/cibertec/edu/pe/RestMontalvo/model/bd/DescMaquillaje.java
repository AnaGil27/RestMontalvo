package cibertec.edu.pe.RestMontalvo.model.bd;

import jakarta.persistence.*;
import lombok.*;
@Data
@NoArgsConstructor
@Entity
@Table(name="descmaquillaje")
public class DescMaquillaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_desc_maquillaje;
    @Column(name="desc_maquillaje")
    private String desc_maquillaje;
}
