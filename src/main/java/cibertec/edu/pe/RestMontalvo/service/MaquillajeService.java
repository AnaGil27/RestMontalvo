package cibertec.edu.pe.RestMontalvo.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import cibertec.edu.pe.RestMontalvo.model.bd.DescMaquillaje;
import cibertec.edu.pe.RestMontalvo.model.bd.Maquillaje;
import cibertec.edu.pe.RestMontalvo.model.request.MaquillajeRequest;
import cibertec.edu.pe.RestMontalvo.repository.MaquillajeRepository;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class MaquillajeService {

    private MaquillajeRepository maquillajeRepository;

    public List<Maquillaje> listarMaquillaje(){
        return maquillajeRepository.findAll();
    }

    public Optional<Maquillaje> obtenerMaquillajePorId(Integer id) {
        Optional<Maquillaje> maquillaje = maquillajeRepository.findById(id);
        return maquillaje;
    }

    public void actualizarMaquillaje(Maquillaje maquillaje) {
        maquillajeRepository.save(maquillaje);
    }

    public Maquillaje guardar(Maquillaje maquillaje){
        return maquillajeRepository.save(maquillaje);
    }

    public Maquillaje guardarMaquillaje(MaquillajeRequest maquillaje){
        Maquillaje objMaquillaje = new Maquillaje();
        if(maquillaje.getIdmaquillaje() > 0){
            objMaquillaje.setIdmaquillaje(maquillaje.getIdmaquillaje());
        }
        objMaquillaje.setPreciomaquillaje(maquillaje.getPreciomaquillaje());
        objMaquillaje.setTiempomaquillaje(maquillaje.getTiempomaquillaje());

        DescMaquillaje descMaquillaje = new DescMaquillaje();
        descMaquillaje.setIddescmaquillaje(maquillaje.getIddescmaquillaje());

        objMaquillaje.setDescmaquillaje(descMaquillaje);
        return maquillajeRepository.save(objMaquillaje);
    }

    public void eliminarMaquillaje(Integer id) {
        Optional<Maquillaje> opcionalMaquillaje = maquillajeRepository.findById(id);
        if (opcionalMaquillaje.isPresent()) {
            maquillajeRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("No se encontró el registro con el ID: " + id);
        }
    }


}


