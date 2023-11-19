package cibertec.edu.pe.RestMontalvo.service;

import cibertec.edu.pe.RestMontalvo.model.bd.DescManicura;
import cibertec.edu.pe.RestMontalvo.repository.DescManicuraRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DescManicuraService {

    private DescManicuraRepository descManicuraRepository;

    public List<DescManicura> listardescManicura(){
        return descManicuraRepository.findAll();
    }
    public DescManicura guardar(DescManicura desc_maManicura){
        return descManicuraRepository.save(desc_maManicura);
    }
    public Optional<DescManicura> obtenerdescManicuraPorId(Integer id){
        Optional<DescManicura> descManicura = descManicuraRepository.findById(id);
        if(descManicura.isEmpty()){
            return Optional.empty();
        }else
            return descManicura;
    }

    public Optional<DescManicura> obtenerDescManicura(String desc_manicura){
        Optional<DescManicura> descManicura = descManicuraRepository.findByDescManicura(desc_manicura);
        if(descManicura.isEmpty())
            return  Optional.empty();
        else
            return descManicura;
    }

    public List<DescManicura> obtenerDescManicuraPorFiltro(String filtro){
        return descManicuraRepository.filtrardesc_manicuraPorNombreSQL(filtro);
    }
}
