package senai.EPI.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import jakarta.transaction.Transactional;
import senai.EPI.Entities.Emprestimo;

@Transactional
public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {
    
}
