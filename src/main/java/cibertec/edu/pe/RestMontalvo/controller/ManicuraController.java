package cibertec.edu.pe.RestMontalvo.controller;

import cibertec.edu.pe.RestMontalvo.model.bd.Manicura;
import cibertec.edu.pe.RestMontalvo.model.dto.DtoEntity;
import cibertec.edu.pe.RestMontalvo.model.dto.ManicuraDto;
import cibertec.edu.pe.RestMontalvo.service.ManicuraService;
import cibertec.edu.pe.RestMontalvo.util.DtoUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/manicura")
public class ManicuraController {

    private ManicuraService manicuraService;

    @GetMapping("")
    public ResponseEntity<List<Manicura>> listarManicura(){
        List<Manicura> manicuraList = new ArrayList<>();
        manicuraService.listarManicura().forEach(manicuraList::add);
        if(manicuraList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return  new ResponseEntity<>(manicuraList, HttpStatus.OK);
    }

    @GetMapping("/dto")
    public ResponseEntity<List<DtoEntity>> listarManicuraDto(){
        List<DtoEntity> manicuraList = new ArrayList<>();
        manicuraList = manicuraService.listarManicura()
                .stream()
                .map(man -> new DtoUtil().convertirADto(man, new ManicuraDto()))
                .collect(Collectors.toList());
        if(manicuraList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return  new ResponseEntity<>(manicuraList, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> actualizarManicura(@PathVariable Integer id, @RequestBody Manicura manicura) {
        try {
            Optional<Manicura> manicuraExistente = manicuraService.obtenerManicuraPorId(id);

            if (manicuraExistente.isPresent()) {
                manicura.setIdmanicura(id);
                manicuraService.actualizarManicura(manicura);

                return new ResponseEntity<>("manicura actualizada exitosamente", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("No se encontró la manicura con el ID: " + id, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Error al actualizar la manicura: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("")
    public ResponseEntity<Manicura> registrarManicura(
            @RequestBody Manicura manicura
    ){
        return new ResponseEntity<>(
                manicuraService.guardar(manicura), HttpStatus.CREATED
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarManicura(@PathVariable Integer id) {
        try {
            manicuraService.eliminarManicura(id);
            return new ResponseEntity<>("Registro eliminado exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar el registro: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}


