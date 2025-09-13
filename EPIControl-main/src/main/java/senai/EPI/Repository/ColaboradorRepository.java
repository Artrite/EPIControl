package senai.EPI.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jakarta.transaction.Transactional;
import senai.EPI.Entities.Colaborador;

@Transactional
public interface ColaboradorRepository extends JpaRepository<Colaborador, Long> {
}
