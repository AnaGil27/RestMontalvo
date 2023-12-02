package cibertec.edu.pe.RestMontalvo.model.dto;

import lombok.Data;

@Data
public class PeinadoDto implements DtoEntity{
    private Integer idpeinado;
    private String preciopeinado;
    private String tiempopeinado;
    private DescPeinadoDto descPeinado;
}
