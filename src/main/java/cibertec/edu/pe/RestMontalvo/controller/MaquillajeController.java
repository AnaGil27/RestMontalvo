package cibertec.edu.pe.RestMontalvo.controller;

import cibertec.edu.pe.RestMontalvo.model.dto.DtoEntity;
import cibertec.edu.pe.RestMontalvo.model.dto.MaquillajeDto;
import cibertec.edu.pe.RestMontalvo.util.DtoUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import cibertec.edu.pe.RestMontalvo.exception.ResourceNotFoundException;
import cibertec.edu.pe.RestMontalvo.model.bd.Maquillaje;
import cibertec.edu.pe.RestMontalvo.service.MaquillajeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/v1/maquillaje")
public class MaquillajeController {
    private MaquillajeService maquillajeService;

    @GetMapping("")
    public ResponseEntity<List<Maquillaje>> listarMaquillaje(){
        List<Maquillaje> maquillajeList = new ArrayList<>();
        maquillajeService.listarMaquillaje().forEach(maquillajeList::add);
        if(maquillajeList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return  new ResponseEntity<>(maquillajeList, HttpStatus.OK);
    }

    @GetMapping("/dto")
    public ResponseEntity<List<DtoEntity>> listarMaquillajeDto(){
        List<DtoEntity> maquillajeList = new ArrayList<>();
        maquillajeList = maquillajeService.listarMaquillaje()
                .stream()
                .map(maq -> new DtoUtil().convertirADto(maq, new MaquillajeDto()))
                .collect(Collectors.toList());
        if(maquillajeList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return  new ResponseEntity<>(maquillajeList, HttpStatus.OK);
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @PutMapping("/{id}")
    public ResponseEntity<String> actualizarMaquillaje(@PathVariable Integer id, @RequestBody Maquillaje maquillaje) {
        try {
            Optional<Maquillaje> maquillajeExistente = maquillajeService.obtenerMaquillajePorId(id);

            if (maquillajeExistente.isPresent()) {
                maquillaje.setIdmaquillaje(id);
                maquillajeService.actualizarMaquillaje(maquillaje);

                return new ResponseEntity<>("Maquillaje actualizado exitosamente", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("No se encontró el Maquillaje con el ID: " + id, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Error al actualizar el Maquillaje: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("")
    public ResponseEntity<Maquillaje> registrarMaquillaje(
            @RequestBody Maquillaje maquillaje
    ){
        return new ResponseEntity<>(
                maquillajeService.guardar(maquillaje), HttpStatus.CREATED
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarMaquillaje(@PathVariable Integer id) {
        try {
            maquillajeService.eliminarMaquillaje(id);
            return new ResponseEntity<>("Registro eliminado exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar el registro: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
