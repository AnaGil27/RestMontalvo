package cibertec.edu.pe.RestMontalvo.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import cibertec.edu.pe.RestMontalvo.model.bd.DescMaquillaje;
import cibertec.edu.pe.RestMontalvo.model.bd.Maquillaje;
import cibertec.edu.pe.RestMontalvo.model.request.MaquillajeRequest;
import cibertec.edu.pe.RestMontalvo.repository.MaquillajeRepository;

import java.util.List;
@Service
@AllArgsConstructor


public class MaquillajeService {
    private MaquillajeRepository maquillajeRepository;

    public List<Maquillaje> listarMaquillaje(){
        return maquillajeRepository.findAll();
    }

    public Maquillaje guardarMaquillaje(MaquillajeRequest maquillaje){
        Maquillaje objMaquillaje = new Maquillaje();
        if(maquillaje.getId_maquillaje() > 0){
            objMaquillaje.setId_maquillaje(maquillaje.getId_maquillaje());
        }
        objMaquillaje.setPrecio_maquillaje(maquillaje.getPrecio_maquillaje());
        objMaquillaje.setTiempo_maquillaje(maquillaje.getTiempo_maquillaje());

        DescMaquillaje descMaquillaje = new DescMaquillaje();
        descMaquillaje.setId_desc_maquillaje(maquillaje.getId_desc_maquillaje());

        objMaquillaje.setDescmaquillaje(descMaquillaje);
        return maquillajeRepository.save(objMaquillaje);
    }

}


