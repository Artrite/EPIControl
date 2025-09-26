package senai.EPI.Services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import senai.EPI.Entities.Equipamento;
import senai.EPI.Repository.EquipamentoRepository;

@Service 
public class EquipamentoService {

    @Autowired 
    private EquipamentoRepository equipamentoRepository;

    public List<Equipamento> findAll() {
            return equipamentoRepository.findAll();
    }

    public Equipamento findById (Long id) {
        Equipamento equipamento = equipamentoRepository.findById(id).orElse(null);
        return equipamento;
    }

    public Equipamento salvarEquipamento (Equipamento equipamento){
        return equipamentoRepository.save(equipamento);
    }

    public Optional<Equipamento> atualizarEquipamento (Long id, Equipamento newequipamento) {
        Optional<Equipamento> id1 = equipamentoRepository.findById(id);

        if(id1.isEmpty()){
        return id1;
        }
        return Optional.of(equipamentoRepository.save(newequipamento));
    }

    public Optional<Equipamento> deleteEquipamento(Long id) {

        Optional<Equipamento> equipamento = equipamentoRepository.findById(id);

        if(equipamento.isPresent()) {
            equipamentoRepository.delete(equipamento.get());
        }
        return equipamento;
        }
    
}
