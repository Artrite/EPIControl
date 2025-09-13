package senai.EPI.DTO;
import jakarta.validation.constraints.NotBlank;

public record EquipamentoDTO (@NotBlank String nome, @NotBlank int quantidade ) {
    
}
