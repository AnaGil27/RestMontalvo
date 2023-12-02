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
    private Integer iddescmaquillaje;
    @Column(name="nombremaquillaje")
    private String nombremaquillaje;
}
