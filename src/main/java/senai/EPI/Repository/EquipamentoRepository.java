package senai.EPI.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jakarta.transaction.Transactional;
import senai.EPI.Entities.Equipamento;

@Transactional
public interface EquipamentoRepository extends JpaRepository<Equipamento, Long> {
    
}
