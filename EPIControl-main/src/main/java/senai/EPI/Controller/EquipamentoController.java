package senai.EPI.Controller;

import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import senai.EPI.DTO.EquipamentoDTO;
import senai.EPI.Entities.Equipamento;
import senai.EPI.Services.EquipamentoService;


@RestController
@CrossOrigin("*")
@RequestMapping (value= "/colaboradores")
public class EquipamentoController {

    @Autowired
    private EquipamentoService equipamentoService;
    
    @GetMapping 
    public List<Equipamento> getEquipamentos() {
        return equipamentoService.findAll();
    }

    @GetMapping( "/{id}")
    public Equipamento findByID(Long id) {
        return equipamentoService.findByID(id);
    }

    @PostMapping
    public ResponseEntity<Equipamento> salvarEquipamento(@RequestBody @Valid EquipamentoDTO equipamentoDTO) {

        Equipamento equipamento = new Equipamento();
        BeanUtils.copyProperties(equipamentoDTO, equipamento);
 
        return ResponseEntity.status(HttpStatus.CREATED).body(equipamentoService.salvarEquipamento(equipamento));
    }

    @PutMapping
    public Object atualizarEquipamento(@PathVariable @Valid @RequestBody Long id, EquipamentoDTO equipamentoDTO) {

        Equipamento equipamento = new Equipamento();
        BeanUtils.copyProperties(equipamentoDTO, equipamento);

        var mudanca = equipamentoService.atualizarEquipamento(id, equipamento);

        if(mudanca.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Equipamento inexistente");
        }

        return ResponseEntity.status(HttpStatus.OK).body(mudanca);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletebyID(@PathVariable long id) {
        var equipamento = equipamentoService.deleteEquipamento(id);

        if (equipamento.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Inexistente");
        }
        return ResponseEntity.status(HttpStatus.OK).body("Equipamento deletado com sucesso!");
    }
}


