package senai.EPI.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import senai.EPI.Entities.Colaborador;
import senai.EPI.Repository.ColaboradorRepository;


@Service 
public class ColaboradorService {

    @Autowired 
    private ColaboradorRepository colaboradorRepository;

    public List<Colaborador> findAll() {
            return colaboradorRepository.findAll();
    }

    public Colaborador findById (Long id) {
        Colaborador colaborador = colaboradorRepository.findById(id).orElse(null);
        return colaborador;
    }

    public Colaborador salvarColaborador(Colaborador colaborador){
        return colaboradorRepository.save(colaborador);
    }

    public Optional<Colaborador> atualizarColaborador(Long id, Colaborador newcolaborador) {
        Optional<Colaborador> id1 = colaboradorRepository.findById(id);

        if(id1.isEmpty()){
        return id1;
        }
        return Optional.of(colaboradorRepository.save(newcolaborador));
    }

    public Optional<Colaborador> deleteColaborador(Long id) {

        Optional<Colaborador> colaborador = colaboradorRepository.findById(id);

        if(colaborador.isPresent()) {
            colaboradorRepository.delete(colaborador.get());
        }
        return colaborador;
        }
    
}
