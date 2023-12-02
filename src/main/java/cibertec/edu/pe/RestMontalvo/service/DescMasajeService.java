package cibertec.edu.pe.RestMontalvo.service;

import cibertec.edu.pe.RestMontalvo.model.bd.DescMasaje;
import cibertec.edu.pe.RestMontalvo.repository.DescMasajeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DescMasajeService {
    private DescMasajeRepository descMasajeRepository;
    public List<DescMasaje> listardescmasaje(){
        return descMasajeRepository.findAll();
    }
    public DescMasaje guardar(DescMasaje descMasaje){
        return descMasajeRepository.save(descMasaje);
    }
    public Optional<DescMasaje> obtenerdescmansajePorId(Integer id){
        Optional<DescMasaje> descMasaje = descMasajeRepository.findById(id);
        if(descMasaje.isEmpty()){
            return Optional.empty();
        }else
            return descMasaje;
    }

    public Optional<DescMasaje> obtenerNombremasaje(String nombremasaje){
        Optional<DescMasaje> descMasaje = descMasajeRepository.findByNombremasaje(nombremasaje);
        if(descMasaje.isEmpty())
            return  Optional.empty();
        else
            return descMasaje;
    }

    public List<DescMasaje> obtenerDescMasajePorFiltro(String filtro){
        return descMasajeRepository.filtrardescmasajeSQL(filtro);
    }




}
