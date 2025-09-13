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
import senai.EPI.DTO.ColaboradorDTO;
import senai.EPI.Entities.Colaborador;
import senai.EPI.Services.ColaboradorService;

@RestController
@CrossOrigin("*")
@RequestMapping (value= "/colaboradores")
public class ColaboradorController {

    @Autowired
    private ColaboradorService colaboradorService;
    
    @GetMapping 
    public List<Colaborador> getColaboradores() {
        return colaboradorService.findAll();
    }

    @GetMapping( "/{id}")
    public Colaborador findByID(Long id) {
        return colaboradorService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Colaborador> salvarColaborador(@RequestBody @Valid ColaboradorDTO colaboradorDTO) {

        Colaborador colaborador = new Colaborador();
        BeanUtils.copyProperties(colaboradorDTO, colaborador);
 
        return ResponseEntity.status(HttpStatus.CREATED).body(colaboradorService.salvarColaborador(colaborador));
    }

    @PutMapping
    public Object atualizarColaborador(@PathVariable @Valid @RequestBody Long id, ColaboradorDTO colaboradorDTO) {

        Colaborador colaborador = new Colaborador();
        BeanUtils.copyProperties(colaboradorDTO, colaborador);

        var mudanca = colaboradorService.atualizarColaborador(id, colaborador);

        if(mudanca.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Colaborador inexistente");
        }

        return ResponseEntity.status(HttpStatus.OK).body(mudanca);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletebyID(@PathVariable long id) {
        var colaborador = colaboradorService.deleteColaborador(id);

        if (colaborador.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Inexistente");
        }
        return ResponseEntity.status(HttpStatus.OK).body("Colaborador deletado com sucesso!");
    }
}
