package cibertec.edu.pe.RestMontalvo.controller;


import cibertec.edu.pe.RestMontalvo.model.bd.Masaje;
import cibertec.edu.pe.RestMontalvo.model.dto.DtoEntity;
import cibertec.edu.pe.RestMontalvo.model.dto.MasajeDto;
import cibertec.edu.pe.RestMontalvo.service.MasajeService;
import cibertec.edu.pe.RestMontalvo.util.DtoUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
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
}
