package cibertec.edu.pe.RestMontalvo.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import cibertec.edu.pe.RestMontalvo.exception.ResourceNotFoundException;
import cibertec.edu.pe.RestMontalvo.model.bd.DescPeinado;
import cibertec.edu.pe.RestMontalvo.service.DescPeinadoService;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/v1/descpeinado")
public class DescPeinadoController {
    private DescPeinadoService descPeinadoService;

    @GetMapping("")
    public ResponseEntity<List<DescPeinado>> listarDescPeinado(){
        List<DescPeinado> descPeinadoList = new ArrayList<>();
        descPeinadoService.listarDescPeinado()
                .forEach(descPeinadoList::add);
        if(descPeinadoList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(descPeinadoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DescPeinado> obtenerDescPeinado(
            @PathVariable("id") Integer id){
        DescPeinado descPeinado = descPeinadoService
                .obtenerDescPeinadoPorId(id)
                .orElseThrow(() -> new ResourceNotFoundException("El DescPeinado con el Id Nro. "+
                        id + " no existe."));

        return new ResponseEntity<>(descPeinado, HttpStatus.OK);
    }


    @GetMapping("/nombrepeinado/{filtro}")
    public ResponseEntity<List<DescPeinado>> filtrarDescPeinadoPorNombre(
            @PathVariable("filtro") String filtro
    ){
        List<DescPeinado> descPeinadoList = new ArrayList<>();
        descPeinadoService.obtenerDescPeinadoPorFiltro(filtro)
                .forEach(descPeinadoList::add);
        if(descPeinadoList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(descPeinadoList, HttpStatus.OK);
    }


    @PostMapping("")
    public ResponseEntity<DescPeinado> registrarDescPeinado(
            @RequestBody DescPeinado descPeinado
    ){
        return new ResponseEntity<>(
                descPeinadoService.guardar(descPeinado), HttpStatus.CREATED
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<DescPeinado> actualizarDescPeinado(
            @PathVariable("id") Integer id,
            @RequestBody DescPeinado descPeinado
    ){
        DescPeinado viejoDescPeinado = descPeinadoService
                .obtenerDescPeinadoPorId(id)
                .orElseThrow(() -> new ResourceNotFoundException("el DescPeinado con el Id Nro. "+
                        id + " no existe."));
        viejoDescPeinado.setNombrepeinado(descPeinado.getNombrepeinado());
        return new ResponseEntity<>(
                descPeinadoService.guardar(viejoDescPeinado), HttpStatus.OK
        );
    }

}


