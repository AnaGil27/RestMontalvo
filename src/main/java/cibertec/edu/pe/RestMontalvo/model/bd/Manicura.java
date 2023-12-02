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
    private Integer idmanicura;
    @Column(name = "preciomanicura")
    private String preciomanicura;
    @Column(name = "tiempomanicura")
    private String tiempomanicura;

    @ManyToOne
    @JoinColumn(name = "iddescmanicura")
    private DescManicura descmanicura;
}

