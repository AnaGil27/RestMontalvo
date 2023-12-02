package cibertec.edu.pe.RestMontalvo.model.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class DescManicuraDto  implements DtoEntity  {
    private Integer iddescmanicura;
    private String descripcion;
}
