package senai.EPI.Repository;
import senai.EPI.Entities.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import jakarta.transaction.Transactional;

@Transactional
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
    

