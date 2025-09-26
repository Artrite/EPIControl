package senai.EPI.Services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import senai.EPI.Entities.Usuario;
import senai.EPI.Repository.UsuarioRepository;


@Service 
public class UsuarioService {

    @Autowired 
    private UsuarioRepository usuarioRepository;

    public List<Usuario> findAll() {
            return usuarioRepository.findAll();
    }

    public Usuario findById (Long id) {
        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        return usuario;
    }

    public Usuario salvarUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public Optional<Usuario> atualizarUsuario(Long id, Usuario newusuario) {
        Optional<Usuario> id1 = usuarioRepository.findById(id);

        if(id1.isEmpty()){
        return id1;
        }
        return Optional.of(usuarioRepository.save(newusuario));
    }

    public Optional<Usuario> deleteUsuario(Long id) {

        Optional<Usuario> usuario = usuarioRepository.findById(id);

        if(usuario.isPresent()) {
            usuarioRepository.delete(usuario.get());
        }
        return usuario;
        }
    
}
