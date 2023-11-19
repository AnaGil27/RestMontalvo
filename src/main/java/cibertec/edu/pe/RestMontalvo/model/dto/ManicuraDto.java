package cibertec.edu.pe.RestMontalvo.model.dto;

import cibertec.edu.pe.RestMontalvo.model.bd.DescManicura;
import lombok.Data;

@Data
public class ManicuraDto  implements DtoEntity{
    private Integer id_manicura;
    private String precio_manicura;
    private String tiempo_manicura;
    private DescManicura descManicura;
}
