package senai.EPI.DTO;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record EmprestimoDTO (@NotNull LocalDateTime data_emprestimo, 
@NotNull LocalDateTime data_devolucao, 
@NotNull Long idcolaborador,@NotNull Long idusuario, 
@NotNull List<Long> idequipamento,
@Min(1) Integer quantidade
 )
{}    

