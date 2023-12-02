package cibertec.edu.pe.RestMontalvo.model.bd;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "descmanicura")
public class DescManicura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer iddescmanicura;
    @Column(name = "descripcion")
    private String descripcion;
}

