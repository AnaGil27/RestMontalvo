package cibertec.edu.pe.RestMontalvo.model.request;

import lombok.Data;

@Data
public class ManicuraRequest {
    private Integer id_manicura;
    private String precio_manicura;
    private String tiempo_manicura;
    private Integer id_desc_manicura;
}
