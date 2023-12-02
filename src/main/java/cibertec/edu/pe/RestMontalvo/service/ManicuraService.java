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
        if(manicura.getIdmanicura() > 0){
            objManicura.setIdmanicura(manicura.getIdmanicura());
        }
        objManicura.setTiempomanicura(manicura.getTiempomanicura());
        objManicura.setPreciomanicura(manicura.getPreciomanicura());

        DescManicura descManicura = new DescManicura();
        descManicura.setIddescmanicura(manicura.getIddescmanicura());
        objManicura.setDescmanicura(descManicura);

        return manicuraRepository.save(objManicura);
    }

}


