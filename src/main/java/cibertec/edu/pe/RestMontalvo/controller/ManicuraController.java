package cibertec.edu.pe.RestMontalvo.controller;

import cibertec.edu.pe.RestMontalvo.model.bd.Manicura;
import cibertec.edu.pe.RestMontalvo.model.dto.DtoEntity;
import cibertec.edu.pe.RestMontalvo.model.dto.ManicuraDto;
import cibertec.edu.pe.RestMontalvo.service.ManicuraService;
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
}


