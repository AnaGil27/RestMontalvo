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
        if(maquillaje.getIdmaquillaje() > 0){
            objMaquillaje.setIdmaquillaje(maquillaje.getIdmaquillaje());
        }
        objMaquillaje.setPreciomaquillaje(maquillaje.getPreciomaquillaje());
        objMaquillaje.setTiempomaquillaje(maquillaje.getTiempomaquillaje());

        DescMaquillaje descMaquillaje = new DescMaquillaje();
        descMaquillaje.setIddescmaquillaje(maquillaje.getIddescmaquillaje());

        objMaquillaje.setDescmaquillaje(descMaquillaje);
        return maquillajeRepository.save(objMaquillaje);
    }

}


