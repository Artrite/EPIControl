package senai.EPI.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import senai.EPI.Entities.Colaborador;
import senai.EPI.Repository.ColaboradorRepository;

@Controller
@RequestMapping("/colaboradores")
public class ColaboradorViewController {

    private final ColaboradorRepository colaboradorRepository;

    public ColaboradorViewController(ColaboradorRepository colaboradorRepository) {
        this.colaboradorRepository = colaboradorRepository;
    }

    // Listar todos
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("colaboradores", colaboradorRepository.findAll());
        model.addAttribute("colaborador", new Colaborador()); // objeto vazio pro form
        return "colaboradores"; // chama o colaboradores.html
    }

    // Criar novo
    @PostMapping
    public String salvar(@ModelAttribute Colaborador colaborador) {
        colaboradorRepository.save(colaborador);
        return "redirect:/colaboradores";
    }

    // Excluir
    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) {
        colaboradorRepository.deleteById(id);
        return "redirect:/colaboradores";
    }
}
