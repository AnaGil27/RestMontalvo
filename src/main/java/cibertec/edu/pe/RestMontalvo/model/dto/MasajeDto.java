package cibertec.edu.pe.RestMontalvo.model.dto;

import cibertec.edu.pe.RestMontalvo.model.bd.DescMasaje;
import lombok.Data;

@Data
public class MasajeDto implements DtoEntity {

    private Integer id_masaje;
    private String precio_masaje;
    private String tiempo_masaje;
    private DescMasaje descmasaje;
}
