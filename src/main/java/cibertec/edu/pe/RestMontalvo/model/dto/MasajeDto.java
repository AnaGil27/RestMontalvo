package cibertec.edu.pe.RestMontalvo.model.dto;

import cibertec.edu.pe.RestMontalvo.model.bd.DescMasaje;
import lombok.Data;

@Data
public class MasajeDto implements DtoEntity {

    private Integer idmasaje;
    private String preciomasaje;
    private String tiempomasaje;
    private DescMasaje descmasaje;
}
