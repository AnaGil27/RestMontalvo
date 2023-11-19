package cibertec.edu.pe.RestMontalvo.model.request;
import lombok.Data;


@Data
public class PeinadoRequest {

    private Integer id_peinado;
    private String precio_peinado;
    private String tiempo_peinado;
    private Integer id_desc_peinado;
}