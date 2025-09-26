package senai.EPI.DTO;

import jakarta.validation.constraints.NotBlank;

public record UsuarioDTO(@NotBlank String nome, @NotBlank String email, @NotBlank String cpf, @NotBlank String senha) {
    
}
