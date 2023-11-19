package cibertec.edu.pe.RestMontalvo.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cibertec.edu.pe.RestMontalvo.model.bd.Peinado;
import cibertec.edu.pe.RestMontalvo.model.dto.DtoEntity;
import cibertec.edu.pe.RestMontalvo.model.dto.PeinadoDto;
import cibertec.edu.pe.RestMontalvo.service.PeinadoService;
import cibertec.edu.pe.RestMontalvo.util.DtoUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@AllArgsConstructor
@RequestMapping("api/v1/peinado")
public class PeinadoController {
    private PeinadoService peinadoService;
    @GetMapping("")
    public ResponseEntity<List<Peinado>> listarPeinado(){
        List<Peinado> peinadoList = new ArrayList<>();
        peinadoService.listarPeinado().forEach(peinadoList::add);
        if(peinadoList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return  new ResponseEntity<>(peinadoList, HttpStatus.OK);
    }

    @GetMapping("/dto")
    public ResponseEntity<List<DtoEntity>> listarPeinadoDto(){
        List<DtoEntity> peinadolist = new ArrayList<>();
        peinadolist = peinadoService.listarPeinado()
                .stream()
                .map(pei -> new DtoUtil().convertirADto(pei, new PeinadoDto()))
                .collect(Collectors.toList());
        if(peinadolist.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return  new ResponseEntity<>(peinadolist, HttpStatus.OK);
    }

}


