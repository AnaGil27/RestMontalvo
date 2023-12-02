package cibertec.edu.pe.RestMontalvo.model.dto;

import cibertec.edu.pe.RestMontalvo.model.bd.DescManicura;
import lombok.Data;

@Data
public class ManicuraDto  implements DtoEntity{
    private Integer idmanicura;
    private String preciomanicura;
    private String tiempomanicura;
    private DescManicura descManicura;
}


