package cibertec.edu.pe.RestMontalvo.model.dto;

import lombok.Data;

@Data
public class MaquillajeDto implements DtoEntity {
    private Integer idmaquillaje;
    private String preciomaquillaje;
    private String tiempomaquillaje;
    private DescMaquillajeDto descMaquillaje;

}
