package cibertec.edu.pe.RestMontalvo.model.dto;

import lombok.Data;

@Data
public class PeinadoDto implements DtoEntity{
    private Integer id_peinado;
    private String precio_peinado;
    private String tiempo_peinado;
    private DescPeinadoDto descPeinado;
}
