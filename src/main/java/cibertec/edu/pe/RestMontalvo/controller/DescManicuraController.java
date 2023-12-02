package cibertec.edu.pe.RestMontalvo.controller;

import cibertec.edu.pe.RestMontalvo.exception.ResourceNotFoundException;
import cibertec.edu.pe.RestMontalvo.model.bd.DescManicura;
import cibertec.edu.pe.RestMontalvo.service.DescManicuraService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/v1/descmanicura")
public class DescManicuraController {

    private DescManicuraService descManicuraService;
    @GetMapping("")
    public ResponseEntity<List<DescManicura>> listardescmanicura(){
        List<DescManicura> descManicuraList = new ArrayList<>();
        descManicuraService.listardescManicura()
                .forEach(descManicuraList::add);
        if(descManicuraList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(descManicuraList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DescManicura> obtenerdescmanicura(
            @PathVariable("id") Integer id){
        DescManicura manicura = descManicuraService
                .obtenerdescManicuraPorId(id)
                .orElseThrow(() -> new ResourceNotFoundException("Manicura con el Id Nro. "+
                        id + " no existe."));

        return new ResponseEntity<>(manicura, HttpStatus.OK);
    }

    @GetMapping("/descripcion/{filtro}")
    public ResponseEntity<List<DescManicura>> filtrarDescManicuraPorNombre(
            @PathVariable("filtro") String filtro
    ){
        List<DescManicura> descManicuraList = new ArrayList<>();
        descManicuraService.obtenerDescManicuraPorFiltro(filtro)
                .forEach(descManicuraList::add);
        if(descManicuraList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(descManicuraList, HttpStatus.OK);
    }


    @PostMapping("")
    public ResponseEntity<DescManicura> registrarDescManicura(
            @RequestBody DescManicura descManicura
    ){
        return new ResponseEntity<>(
                descManicuraService.guardar(descManicura), HttpStatus.CREATED
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<DescManicura> actualizarDescManicura(
            @PathVariable("id") Integer id,
            @RequestBody DescManicura descManicura
    ){
        DescManicura oldDescManicura = descManicuraService
                .obtenerdescManicuraPorId(id)
                .orElseThrow(() -> new ResourceNotFoundException("La Descripción Manicura con el Id Nro. "+
                        id + " no existe."));
        oldDescManicura.setDescripcion(descManicura.getDescripcion());
        return new ResponseEntity<>(
                descManicuraService.guardar(oldDescManicura), HttpStatus.OK
        );
    }
}


