package cibertec.edu.pe.RestMontalvo.service;

import cibertec.edu.pe.RestMontalvo.model.bd.DescPeinado;
import cibertec.edu.pe.RestMontalvo.repository.DescPeinadoRepository;
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
    public DescMaquillaje guardar(DescMaquillaje desc_maquillaje){
        return descMaquillajeRepository.save(desc_maquillaje);
    }
    public Optional<DescMaquillaje> obtenerDescMaquillajePorId(Integer id){
        Optional<DescMaquillaje> descMaquillaje = descMaquillajeRepository.findById(id);
        if(descMaquillaje.isEmpty()){
            return Optional.empty();
        }else
            return descMaquillaje;
    }

    public Optional<DescMaquillaje> obtenerdesc_peinado(String desc_maquillaje){
        Optional<DescMaquillaje> descPeinado = descMaquillajeRepository.findBydesc_maquillaje(desc_maquillaje);
        if(descPeinado.isEmpty())
            return  Optional.empty();
        else
            return descPeinado;
    }

    public List<DescMaquillaje> obtenerDescMaquillajePorFiltro(String filtro){
        return descMaquillajeRepository.filtrarDescMaquillajePorNombreSQL(filtro);
    }
}


