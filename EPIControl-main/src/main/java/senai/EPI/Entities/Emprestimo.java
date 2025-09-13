package senai.EPI.Entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Emprestimo implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idemprestimo")
    
    private Long id;

    private LocalDateTime data_emprestimo;

    private int quantidade;

    //@OneToMany
    //@JoinColumn(name = "idcolaborador", nullable = false)
    //private Colaborador colaborador;

    //@ManyToMany
    //@JoinColumn(name = "idequipamento", nullable = false)
    //private Equipamento equipamento;
    
   // @OneToMany
    //@JoinColumn(name = "idusuario", nullable = false)
    //private Usuario usuario;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getData_emprestimo() {
        return data_emprestimo;
    }

    public void setData_emprestimo(LocalDateTime data_emprestimo) {
        this.data_emprestimo = data_emprestimo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    //public Colaborador getColaborador() {
   //     return colaborador;
   // }

   // public void setColaborador(Colaborador colaborador) {
   //     this.colaborador = colaborador;
   // }

   // public Equipamento getEquipamento() {
    //    return equipamento;
   // }

   // public void setEquipamento(Equipamento equipamento) {
   //     this.equipamento = equipamento;
   // }

   // public Usuario getUsuario() {
   //     return usuario;
   // }

   // public void setUsuario(Usuario usuario) {
   //     this.usuario = usuario;
   // }
}
