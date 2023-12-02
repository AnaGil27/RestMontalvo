package cibertec.edu.pe.RestMontalvo.model.request;

import lombok.Data;

@Data
public class MaquillajeRequest {
    private Integer idmaquillaje;
    private String preciomaquillaje;
    private String tiempomaquillaje;
    private Integer iddescmaquillaje;
}
