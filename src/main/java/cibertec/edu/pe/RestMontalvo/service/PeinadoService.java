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
        if(peinado.getIdpeinado() > 0){
            objPeinado.setIdpeinado(peinado.getIdpeinado());
        }
        objPeinado.setPreciopeinado(peinado.getPreciopeinado());
        objPeinado.setTiempopeinado(peinado.getTiempopeinado());

        DescPeinado descPeinado = new DescPeinado();
        descPeinado.setIddescpeinado(descPeinado.getIddescpeinado());
        objPeinado.setDescpeinado(descPeinado);
        return peinadoRepository.save(objPeinado);
    }

}
