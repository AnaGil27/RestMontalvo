package cibertec.edu.pe.RestMontalvo.service;

import cibertec.edu.pe.RestMontalvo.model.bd.DescMasaje;
import cibertec.edu.pe.RestMontalvo.model.bd.Masaje;
import cibertec.edu.pe.RestMontalvo.model.request.MasajeRequest;
import cibertec.edu.pe.RestMontalvo.repository.MasajeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class MasajeService {

    private MasajeRepository masajeRepository;

    public List<Masaje> listarMasaje(){
        return masajeRepository.findAll();
    }

    public Optional<Masaje>obtenerMasajePorId(Integer id){
        Optional<Masaje> masaje = masajeRepository.findById(id);
        return masaje;
    }

    public void actualizarMasaje(Masaje masaje){
        masajeRepository.save(masaje);
    }
    public Masaje guardar(Masaje masaje){return masajeRepository.save(masaje);}

    public Masaje guardarMasaje(MasajeRequest masaje){
        Masaje objMasaje = new Masaje();
        if(masaje.getIdmasaje() > 0){
            objMasaje.setIdmasaje(masaje.getIdmasaje());
        }
        objMasaje.setTiempomasaje(masaje.getTiempomasaje());
        objMasaje.setPreciomasaje(masaje.getPreciomasaje());

        DescMasaje descMasaje = new DescMasaje();
        descMasaje.setIddescmasaje(masaje.getIddescmasaje());
        objMasaje.setDescmasaje(descMasaje);
        return masajeRepository.save(objMasaje);
    }
    public void eliminarMasaje(Integer id){
        Optional<Masaje> optionalMasaje = masajeRepository.findById(id);
        if(optionalMasaje.isPresent()){
            masajeRepository.deleteById(id);
        }else{
            throw new IllegalArgumentException("No se encontró el registro con el ID: " + id);
        }
    }

}
