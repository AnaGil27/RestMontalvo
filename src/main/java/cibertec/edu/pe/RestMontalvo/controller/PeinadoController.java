package cibertec.edu.pe.RestMontalvo.controller;

import cibertec.edu.pe.RestMontalvo.exception.ResourceNotFoundException;
import cibertec.edu.pe.RestMontalvo.model.bd.DescPeinado;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import cibertec.edu.pe.RestMontalvo.model.bd.Peinado;
import cibertec.edu.pe.RestMontalvo.model.dto.DtoEntity;
import cibertec.edu.pe.RestMontalvo.model.dto.PeinadoDto;
import cibertec.edu.pe.RestMontalvo.service.PeinadoService;
import cibertec.edu.pe.RestMontalvo.util.DtoUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
@AllArgsConstructor
@RequestMapping("api/v1/peinado")
public class PeinadoController {
    private PeinadoService peinadoService;
    @GetMapping("")
    public ResponseEntity<List<Peinado>> listarPeinado(){
        List<Peinado> peinadoList = new ArrayList<>();
        peinadoService.listarPeinado().forEach(peinadoList::add);
        if(peinadoList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return  new ResponseEntity<>(peinadoList, HttpStatus.OK);
    }

    @GetMapping("/dto")
    public ResponseEntity<List<DtoEntity>> listarPeinadoDto(){
        List<DtoEntity> peinadolist = new ArrayList<>();
        peinadolist = peinadoService.listarPeinado()
                .stream()
                .map(pei -> new DtoUtil().convertirADto(pei, new PeinadoDto()))
                .collect(Collectors.toList());
        if(peinadolist.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return  new ResponseEntity<>(peinadolist, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> actualizarPeinado(@PathVariable Integer id, @RequestBody Peinado peinado) {
        try {
            // Verifica si el peinado con el ID proporcionado existe
            Optional<Peinado> peinadoExistente = peinadoService.obtenerPeinadoPorId(id);

            if (peinadoExistente.isPresent()) {
                // Actualiza los datos del peinado existente
                peinado.setIdpeinado(id);
                peinadoService.actualizarPeinado(peinado);

                return new ResponseEntity<>("Peinado actualizado exitosamente", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("No se encontró el peinado con el ID: " + id, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Error al actualizar el peinado: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("")
    public ResponseEntity<Peinado> registrarPeinado(
            @RequestBody Peinado peinado
    ){
        return new ResponseEntity<>(
                peinadoService.guardar(peinado), HttpStatus.CREATED
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarPeinado(@PathVariable Integer id) {
        try {
            // Llama al servicio para eliminar el registro
            peinadoService.eliminarPeinado(id);
            return new ResponseEntity<>("Registro eliminado exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar el registro: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}


