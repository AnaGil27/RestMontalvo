package cibertec.edu.pe.RestMontalvo.service;

import cibertec.edu.pe.RestMontalvo.model.bd.DescMasaje;
import cibertec.edu.pe.RestMontalvo.model.bd.Masaje;
import cibertec.edu.pe.RestMontalvo.model.request.MasajeRequest;
import cibertec.edu.pe.RestMontalvo.repository.MasajeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class MasajeService {

    private MasajeRepository masajeRepository;

    public List<Masaje> listarMasaje(){
        return masajeRepository.findAll();
    }

    public Masaje guardarMasaje(MasajeRequest masaje){
        Masaje objMasaje = new Masaje();
        if(masaje.getId_masaje() > 0){
            objMasaje.setId_masaje(masaje.getId_masaje());
        }
        objMasaje.setTiempo_masaje(masaje.getTiempo_masaje());
        objMasaje.setPrecio_masaje(masaje.getPrecio_masaje());

        DescMasaje descMasaje = new DescMasaje();
        descMasaje.setId_desc_masaje(masaje.getId_desc_masaje());
        objMasaje.setDescmasaje(descMasaje);

        return masajeRepository.save(objMasaje);
    }
}
