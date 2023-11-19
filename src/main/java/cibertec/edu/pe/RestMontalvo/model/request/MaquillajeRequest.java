package cibertec.edu.pe.RestMontalvo.model.request;

import lombok.Data;

@Data
public class MaquillajeRequest {
    private Integer id_maquillaje;
    private String precio_maquillaje;
    private String tiempo_maquillaje;
    private Integer id_desc_maquillaje;
}
