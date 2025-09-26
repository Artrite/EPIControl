package senai.EPI.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record EquipamentoDTO (@NotBlank String nome, @Min(1) Integer quantidade) {
    
}
