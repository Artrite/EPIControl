package senai.EPI.Services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import senai.EPI.DTO.EmprestimoDTO;
import senai.EPI.Entities.Colaborador;
import senai.EPI.Entities.Emprestimo;
import senai.EPI.Entities.Equipamento;
import senai.EPI.Entities.Usuario;
import senai.EPI.Repository.ColaboradorRepository;
import senai.EPI.Repository.EmprestimoRepository;
import senai.EPI.Repository.EquipamentoRepository;
import senai.EPI.Repository.UsuarioRepository;

@Service
public class EmprestimoService {

    private final EmprestimoRepository emprestimoRepository;
    private final ColaboradorRepository colaboradorRepository;
    private final UsuarioRepository usuarioRepository;
    private final EquipamentoRepository equipamentoRepository;

    public EmprestimoService(EmprestimoRepository emprestimoRepository,
                             ColaboradorRepository colaboradorRepository,
                             UsuarioRepository usuarioRepository,
                             EquipamentoRepository equipamentoRepository) {
        this.emprestimoRepository = emprestimoRepository;
        this.colaboradorRepository = colaboradorRepository;
        this.usuarioRepository = usuarioRepository;
        this.equipamentoRepository = equipamentoRepository;
    }

    public Emprestimo criarEmprestimo(EmprestimoDTO dto) {
        Emprestimo emprestimo = new Emprestimo();

        Colaborador colaborador = colaboradorRepository.findById(dto.idcolaborador())
                .orElseThrow(() -> new RuntimeException("Colaborador não encontrado"));

        Usuario usuario = usuarioRepository.findById(dto.idusuario())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        List<Equipamento> equipamentos = dto.idequipamento().stream()
                .map(id -> equipamentoRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Equipamento " + id + " não encontrado")))
                .collect(Collectors.toList());

        emprestimo.setData_emprestimo(dto.data_emprestimo());
        emprestimo.setData_devolucao(dto.data_devolucao());
        emprestimo.setColaborador(colaborador);
        emprestimo.setUsuario(usuario);
        emprestimo.setEquipamento(equipamentos);
        emprestimo.setQuantidade(equipamentos.size());

        return emprestimoRepository.save(emprestimo);
    }

    public List<Emprestimo> listarTodos() {
        return emprestimoRepository.findAll();
    }

    public Optional<Emprestimo> buscarPorId(Long id) {
        return emprestimoRepository.findById(id);
    }

    public void deletar(Long id) {
        emprestimoRepository.deleteById(id);
    }
}
