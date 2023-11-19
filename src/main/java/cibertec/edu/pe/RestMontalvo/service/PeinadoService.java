package cibertec.edu.pe.RestMontalvo.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import cibertec.edu.pe.RestMontalvo.model.bd.DescPeinado;
import cibertec.edu.pe.RestMontalvo.model.bd.Peinado;
import cibertec.edu.pe.RestMontalvo.model.request.PeinadoRequest;
import cibertec.edu.pe.RestMontalvo.repository.PeinadoRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class PeinadoService {

    private PeinadoRepository peinadoRepository;

    public List<Peinado> listarPeinado(){
        return peinadoRepository.findAll();
    }

    public Peinado guardarPeinado(PeinadoRequest peinado){
        Peinado objPeinado = new Peinado();
        if(peinado.getId_peinado() > 0){
            objPeinado.setId_peinado(peinado.getId_peinado());
        }
        objPeinado.setPrecio_peinado(peinado.getPrecio_peinado());
        objPeinado.setTiempo_peinado(peinado.getTiempo_peinado());

        DescPeinado descPeinado = new DescPeinado();
        descPeinado.setId_desc_peinado(descPeinado.getId_desc_peinado());
        objPeinado.setDescpeinado(descPeinado);
        return peinadoRepository.save(objPeinado);
    }

}
