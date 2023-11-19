package cibertec.edu.pe.RestMontalvo.model.dto;

import lombok.Data;

@Data
public class MaquillajeDto implements DtoEntity {
    private Integer id_maquillaje;
    private String precio_maquillaje;
    private String tiempo_maquillaje;
    private DescMaquillajeDto descMaquillaje;

}
