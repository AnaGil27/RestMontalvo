package cibertec.edu.pe.RestMontalvo.service;

import cibertec.edu.pe.RestMontalvo.model.bd.DescManicura;
import cibertec.edu.pe.RestMontalvo.model.bd.Manicura;

import cibertec.edu.pe.RestMontalvo.model.request.ManicuraRequest;
import cibertec.edu.pe.RestMontalvo.repository.ManicuraRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ManicuraService {

    private ManicuraRepository manicuraRepository;

    public List<Manicura> listarManicura(){
        return manicuraRepository.findAll();
    }

    public Manicura guardarManicura(ManicuraRequest manicura){
        Manicura objManicura = new Manicura();
        if(manicura.getId_manicura() > 0){
            objManicura.setId_manicura(manicura.getId_manicura());
        }
        objManicura.setTiempo_manicura(manicura.getTiempo_manicura());
        objManicura.setPrecio_manicura(manicura.getPrecio_manicura());

        DescManicura descManicura = new DescManicura();
        descManicura.setId_desc_manicura(manicura.getId_desc_manicura());
        objManicura.setDescmanicura(descManicura);

        return manicuraRepository.save(objManicura);
    }

}
