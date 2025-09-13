package senai.EPI.DTO;

import jakarta.validation.constraints.NotBlank;

public record ColaboradorDTO(@NotBlank String nome, @NotBlank String email, @NotBlank String cpf, @NotBlank String senha) {
    
}
