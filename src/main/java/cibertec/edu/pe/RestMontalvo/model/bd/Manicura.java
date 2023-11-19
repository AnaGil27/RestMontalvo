package cibertec.edu.pe.RestMontalvo.model.bd;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "manicura")
public class Manicura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_manicura;
    @Column(name = "precio_manicura")
    private String precio_manicura;
    @Column(name = "tiempo_manicura")
    private String tiempo_manicura;

    @ManyToOne
    @JoinColumn(name = "id_desc_manicura")
    private DescManicura descmanicura;
}