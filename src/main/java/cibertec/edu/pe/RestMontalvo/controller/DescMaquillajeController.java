package cibertec.edu.pe.RestMontalvo.controller;

import cibertec.edu.pe.RestMontalvo.exception.ResourceNotFoundException;
import cibertec.edu.pe.RestMontalvo.model.bd.DescMaquillaje;
import cibertec.edu.pe.RestMontalvo.service.DescMaquillajeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@RestController
@RequestMapping(path = "api/v1/descmaquillaje")
public class DescMaquillajeController {
    private DescMaquillajeService descMaquillajeService;

    @GetMapping("")
    public ResponseEntity<List<DescMaquillaje>> listarDescMaquillaje(){
        List<DescMaquillaje> descMaquillajeList = new ArrayList<>();
        descMaquillajeService.listarDescMaquillaje()
                .forEach(descMaquillajeList::add);
        if(descMaquillajeList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(descMaquillajeList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DescMaquillaje> obtenerDescMaquillaje(
            @PathVariable("id") Integer id){
        DescMaquillaje descMaquillaje = descMaquillajeService
                .obtenerDescMaquillajePorId(id)
                .orElseThrow(() -> new ResourceNotFoundException("El descMaquillaje con el Id Nro. "+
                        id + " no existe."));

        return new ResponseEntity<>(descMaquillaje, HttpStatus.OK);
    }


    @GetMapping("/desc_maquillaje/{filtro}")
    public ResponseEntity<List<DescMaquillaje>> filtrarDescMaquillajePorNombre(
            @PathVariable("filtro") String filtro
    ){
        List<DescMaquillaje> descMaquillajeList = new ArrayList<>();
        descMaquillajeService.obtenerDescMaquillajePorFiltro(filtro)
                .forEach(descMaquillajeList::add);
        if(descMaquillajeList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(descMaquillajeList, HttpStatus.OK);
    }


    @PostMapping("")
    public ResponseEntity<DescMaquillaje> registrarDescMaquillaje(
            @RequestBody DescMaquillaje descMaquillaje
    ){
        return new ResponseEntity<>(
                descMaquillajeService.guardar(descMaquillaje), HttpStatus.CREATED
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<DescMaquillaje> actualizarDescMaquillaje(
            @PathVariable("id") Integer id,
            @RequestBody DescMaquillaje descMaquillaje
    ){
        DescMaquillaje viejoDescMaquillaje = descMaquillajeService
                .obtenerDescMaquillajePorId(id)
                .orElseThrow(() -> new ResourceNotFoundException("el descMaquillaje con el Id Nro. "+
                        id + " no existe."));
        viejoDescMaquillaje.setDesc_maquillaje(descMaquillaje.getDesc_maquillaje());
        return new ResponseEntity<>(
                descMaquillajeService.guardar(viejoDescMaquillaje), HttpStatus.OK
        );
    }

}




