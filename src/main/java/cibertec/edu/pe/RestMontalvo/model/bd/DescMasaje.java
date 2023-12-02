package cibertec.edu.pe.RestMontalvo.model.bd;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "descmasaje")
public class DescMasaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer iddescmasaje;
    @Column(name = "nombremasaje")
    private String nombremasaje;
}