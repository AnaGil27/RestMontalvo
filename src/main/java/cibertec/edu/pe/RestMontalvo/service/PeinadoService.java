package cibertec.edu.pe.RestMontalvo.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import cibertec.edu.pe.RestMontalvo.model.bd.DescPeinado;
import cibertec.edu.pe.RestMontalvo.model.bd.Peinado;
import cibertec.edu.pe.RestMontalvo.model.request.PeinadoRequest;
import cibertec.edu.pe.RestMontalvo.repository.PeinadoRepository;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PeinadoService {

    private PeinadoRepository peinadoRepository;

    public List<Peinado> listarPeinado(){
        return peinadoRepository.findAll();
    }

    public Optional<Peinado> obtenerPeinadoPorId(Integer id) {
        Optional<Peinado> peinado = peinadoRepository.findById(id);
        return peinado;
    }

    public void actualizarPeinado(Peinado peinado) {
        peinadoRepository.save(peinado);
    }

    public Peinado guardar(Peinado peinado){
        return peinadoRepository.save(peinado);
    }


    public Peinado guardarPeinado(PeinadoRequest peinado){
        Peinado objPeinado = new Peinado();
        if(peinado.getIdpeinado() > 0){
            objPeinado.setIdpeinado(peinado.getIdpeinado());
        }
        objPeinado.setPreciopeinado(peinado.getPreciopeinado());
        objPeinado.setTiempopeinado(peinado.getTiempopeinado());

        DescPeinado descPeinado = new DescPeinado();
        descPeinado.setIddescpeinado(descPeinado.getIddescpeinado());
        objPeinado.setDescpeinado(descPeinado);
        return peinadoRepository.save(objPeinado);
    }

    public void eliminarPeinado(Integer id) {
        // Verifica si el registro existe antes de intentar eliminarlo
        Optional<Peinado> opcionalPeinado = peinadoRepository.findById(id);
        if (opcionalPeinado.isPresent()) {
            // El registro existe, procede con la eliminación
            peinadoRepository.deleteById(id);
        } else {
            // El registro no existe, puedes manejar este caso según tus necesidades
            throw new IllegalArgumentException("No se encontró el registro con el ID: " + id);
        }
    }

}
