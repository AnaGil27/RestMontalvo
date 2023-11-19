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
    public ResponseEntity<List<Masaje>> listarProductos(){
        List<Masaje> productList = new ArrayList<>();
        masajeService.listarMasaje().forEach(productList::add);
        if(productList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return  new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @GetMapping("/dto")
    public ResponseEntity<List<DtoEntity>> listarProductosDto(){
        List<DtoEntity> productList = new ArrayList<>();
        productList = masajeService.listarMasaje()
                .stream()
                .map(prod -> new DtoUtil().convertirADto(prod, new MasajeDto()))
                .collect(Collectors.toList());
        if(productList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return  new ResponseEntity<>(productList, HttpStatus.OK);
    }
}
