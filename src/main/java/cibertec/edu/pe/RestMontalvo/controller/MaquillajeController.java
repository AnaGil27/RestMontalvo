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

}
