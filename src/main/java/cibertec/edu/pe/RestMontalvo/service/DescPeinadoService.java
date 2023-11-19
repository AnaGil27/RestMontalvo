package cibertec.edu.pe.RestMontalvo.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import cibertec.edu.pe.RestMontalvo.model.bd.DescPeinado;
import cibertec.edu.pe.RestMontalvo.repository.DescPeinadoRepository;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor

public class DescPeinadoService {

    private DescPeinadoRepository descPeinadoRepository;

    public List<DescPeinado> listarDescPeinado(){
        return descPeinadoRepository.findAll();
    }
    public DescPeinado guardar(DescPeinado descPeinado){
        return descPeinadoRepository.save(descPeinado);
    }
    public Optional<DescPeinado> obtenerDescPeinadoPorId(Integer id){
        Optional<DescPeinado> descPeinado = descPeinadoRepository.findById(id);
        if(descPeinado.isEmpty()){
            return Optional.empty();
        }else
            return descPeinado;
    }

    public Optional<DescPeinado> obtenerdesc_peinado(String desc_peinado){
        Optional<DescPeinado> descPeinado = descPeinadoRepository.findByDescPeinadoname(desc_peinado);
        if(descPeinado.isEmpty())
            return  Optional.empty();
        else
            return descPeinado;
    }

    public List<DescPeinado> obtenerDescPeinadoPorFiltro(String filtro){
        return descPeinadoRepository.filtrarDescPeinadoPorNombreSQL(filtro);
    }
}


