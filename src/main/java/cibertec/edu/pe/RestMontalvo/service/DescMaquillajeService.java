package cibertec.edu.pe.RestMontalvo.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import cibertec.edu.pe.RestMontalvo.model.bd.DescMaquillaje;
import cibertec.edu.pe.RestMontalvo.repository.DescMaquillajeRepository;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DescMaquillajeService {
    private DescMaquillajeRepository descMaquillajeRepository;

    public List<DescMaquillaje> listarDescMaquillaje(){
        return descMaquillajeRepository.findAll();
    }
    public DescMaquillaje guardar(DescMaquillaje descmaquillaje){
        return descMaquillajeRepository.save(descmaquillaje);
    }
    public Optional<DescMaquillaje> obtenerDescMaquillajePorId(Integer id){
        Optional<DescMaquillaje> descMaquillaje = descMaquillajeRepository.findById(id);
        if(descMaquillaje.isEmpty()){
            return Optional.empty();
        }else
            return descMaquillaje;
    }

    public Optional<DescMaquillaje> obtenerNombremaquillaje(String nombremaquillaje){
        Optional<DescMaquillaje> descMaquillaje = descMaquillajeRepository.findByNombremaquillaje(nombremaquillaje);
        if(descMaquillaje.isEmpty())
            return  Optional.empty();
        else
            return descMaquillaje;
    }

    public List<DescMaquillaje> obtenerDescMaquillajePorFiltro(String filtro){
        return descMaquillajeRepository.filtrarDescMaquillajePorNombreSQL(filtro);
    }


}


