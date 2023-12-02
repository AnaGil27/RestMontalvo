package cibertec.edu.pe.RestMontalvo.service;

import cibertec.edu.pe.RestMontalvo.model.bd.DescManicura;
import cibertec.edu.pe.RestMontalvo.model.bd.Manicura;

import cibertec.edu.pe.RestMontalvo.model.bd.Peinado;
import cibertec.edu.pe.RestMontalvo.model.request.ManicuraRequest;
import cibertec.edu.pe.RestMontalvo.repository.ManicuraRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ManicuraService {

    private ManicuraRepository manicuraRepository;

    public List<Manicura> listarManicura(){
        return manicuraRepository.findAll();
    }

    public Optional<Manicura> obtenerManicuraPorId(Integer id) {
        Optional<Manicura> manicura = manicuraRepository.findById(id);
        return manicura;
    }

    public void actualizarManicura(Manicura manicura) {
        manicuraRepository.save(manicura);
    }

    public Manicura guardar(Manicura manicura){
        return manicuraRepository.save(manicura);
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

    public void eliminarManicura(Integer id) {
        Optional<Manicura> opcionalManicura = manicuraRepository.findById(id);
        if (opcionalManicura.isPresent()) {
            manicuraRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("No se encontró el registro con el ID: " + id);
        }
    }
}


