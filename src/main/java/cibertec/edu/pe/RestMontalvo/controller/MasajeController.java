package cibertec.edu.pe.RestMontalvo.controller;


import cibertec.edu.pe.RestMontalvo.model.bd.Masaje;
import cibertec.edu.pe.RestMontalvo.model.dto.DtoEntity;
import cibertec.edu.pe.RestMontalvo.model.dto.MasajeDto;
import cibertec.edu.pe.RestMontalvo.service.MasajeService;
import cibertec.edu.pe.RestMontalvo.util.DtoUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/masaje")
public class MasajeController {
    private MasajeService masajeService;

    @GetMapping("")
    public ResponseEntity<List<Masaje>> listarMajase(){
        List<Masaje> masajeList = new ArrayList<>();
        masajeService.listarMasaje().forEach(masajeList ::add);
        if(masajeList .isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return  new ResponseEntity<>(masajeList, HttpStatus.OK);
    }

    @GetMapping("/dto")
    public ResponseEntity<List<DtoEntity>> listarMasajeDto(){
        List<DtoEntity> masajeList = new ArrayList<>();
        masajeList = masajeService.listarMasaje()
                .stream()
                .map(maj -> new DtoUtil().convertirADto(maj, new MasajeDto()))
                .collect(Collectors.toList());
        if(masajeList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return  new ResponseEntity<>(masajeList, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> actualizarMasaje(@PathVariable Integer id, @RequestBody Masaje masaje ){
        try {
            Optional<Masaje> masajeExistente = masajeService.obtenerMasajePorId(id);

            if (masajeExistente.isPresent()) {
                masaje.setIdmasaje(id);
                masajeService.actualizarMasaje(masaje);

                return new ResponseEntity<>("Masaje actualizado exitosamente", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("No se encontró el Masaje con el ID: " + id, HttpStatus.NOT_FOUND);

            }
        } catch(Exception e){
            return new ResponseEntity<>("Error al actualizar el Masaje: "+ e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("")
    public ResponseEntity<Masaje>registrarMasaje(
            @RequestBody Masaje masaje
    ){
        return new ResponseEntity<>(
                masajeService.guardar(masaje), HttpStatus.CREATED
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eleiminarMasaje(@PathVariable Integer id){
        try {
            masajeService.eliminarMasaje(id);
            return new ResponseEntity<>("Registro eliminado exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar el registro: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
