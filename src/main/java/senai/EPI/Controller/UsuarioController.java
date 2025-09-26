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
import senai.EPI.DTO.UsuarioDTO;
import senai.EPI.Entities.Usuario;
import senai.EPI.Services.UsuarioService;

@RestController
@CrossOrigin("*")
@RequestMapping (value= "/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
    
    @GetMapping 
    public List<Usuario> getUsuarios() {
        return usuarioService.findAll();
    }

    @GetMapping( "/{id}")
    public Usuario findByID(@PathVariable Long id) {
        return usuarioService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Usuario> salvarUsuario(@RequestBody @Valid UsuarioDTO usuarioDTO) {

        Usuario usuario = new Usuario();
        BeanUtils.copyProperties(usuarioDTO, usuario);
 
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.salvarUsuario(usuario));
    }

    @PutMapping
    public Object atualizarUsuario(@PathVariable @Valid @RequestBody Long id, UsuarioDTO usuarioDTO) {

        Usuario usuario = new Usuario();
        BeanUtils.copyProperties(usuarioDTO, usuario);

        var mudanca = usuarioService.atualizarUsuario(id, usuario);

        if(mudanca.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario inexistente");
        }

        return ResponseEntity.status(HttpStatus.OK).body(mudanca);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletebyID(@PathVariable long id) {
        var usuario = usuarioService.deleteUsuario(id);

        if (usuario.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Inexistente");
        }
        return ResponseEntity.status(HttpStatus.OK).body("Usuario deletado com sucesso!");
    }
}
