package cibertec.edu.pe.RestMontalvo.controller;

import cibertec.edu.pe.RestMontalvo.exception.ResourceNotFoundException;
import cibertec.edu.pe.RestMontalvo.model.bd.DescMasaje;
import cibertec.edu.pe.RestMontalvo.service.DescMasajeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/v1/descmasaje")
public class DescMasajeController {

    private DescMasajeService descMasajeService;


    @GetMapping("")
    public ResponseEntity<List<DescMasaje>> listardescmasaje(){
        List<DescMasaje> descMasajeList = new ArrayList<>();
        descMasajeService.listardescmasaje()
                .forEach(descMasajeList::add);
        if(descMasajeList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(descMasajeList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DescMasaje> obtenerdescmasaje(
            @PathVariable("id") Integer id){
        DescMasaje masaje = descMasajeService
                .obtenerdescmansajePorId(id)
                .orElseThrow(() -> new ResourceNotFoundException("Masaje con el Id Nro. "+
                        id + " no existe."));

        return new ResponseEntity<>(masaje, HttpStatus.OK);
    }

    @GetMapping("/nombremasaje/{filtro}")
    public ResponseEntity<List<DescMasaje>> filtrarDescMasajePorNombre(
            @PathVariable("filtro") String filtro
    ){
        List<DescMasaje> descMasajeList = new ArrayList<>();
        descMasajeService.obtenerDescMasajePorFiltro(filtro)
                .forEach(descMasajeList::add);
        if(descMasajeList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(descMasajeList, HttpStatus.OK);
    }


    @PostMapping("")
    public ResponseEntity<DescMasaje> registrarDescMasaje(
            @RequestBody DescMasaje descMasaje
    ){
        return new ResponseEntity<>(
                descMasajeService.guardar(descMasaje), HttpStatus.CREATED
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<DescMasaje> actualizarDescMasaje(
            @PathVariable("id") Integer id,
            @RequestBody DescMasaje descMasaje
    ){
        DescMasaje oldDescMasaje = descMasajeService
                .obtenerdescmansajePorId(id)
                .orElseThrow(() -> new ResourceNotFoundException("La Descripcion Masaje con el Id Nro. "+
                        id + " no existe."));
        oldDescMasaje.setNombremasaje(descMasaje.getNombremasaje());
        return new ResponseEntity<>(
                descMasajeService.guardar(oldDescMasaje), HttpStatus.OK
        );
    }
}
