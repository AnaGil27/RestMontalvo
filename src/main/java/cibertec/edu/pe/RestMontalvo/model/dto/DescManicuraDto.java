package cibertec.edu.pe.RestMontalvo.model.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class DescManicuraDto  implements DtoEntity  {
    private Integer id_desc_manicura;
    private String desc_manicura;
}
