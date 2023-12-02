package cibertec.edu.pe.RestMontalvo.model.request;

import lombok.Data;

@Data
public class MasajeRequest {
    private Integer idmasaje;
    private String preciomasaje;
    private String tiempomasaje;
    private Integer iddescmasaje;
}
