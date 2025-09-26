package senai.EPI.Entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Emprestimo implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idemprestimo")
    
    private Long id;

    private LocalDateTime data_emprestimo;

    private LocalDateTime data_devolucao;

    private int quantidade;

    @ManyToOne
    @JoinColumn(name = "idcolaborador", nullable = false)
    private Colaborador colaborador;

    @ManyToMany
    @JoinTable(
    joinColumns = @JoinColumn(name = "idemprestimo", nullable = false),
    inverseJoinColumns = @JoinColumn(name = "idequipamento")
    )
    private List<Equipamento> equipamento;
    
    @ManyToOne
    @JoinColumn(name = "idusuario", nullable = false)
    private Usuario usuario;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getData_devolucao() {
        return data_devolucao;
    }

    public void setData_devolucao(LocalDateTime data_devolucao) {
        this.data_devolucao = data_devolucao;
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

    public Colaborador getColaborador() {
        return colaborador;
    }

    public void setColaborador(Colaborador colaborador) {
        this.colaborador = colaborador;
    }

    public List<Equipamento> getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(List<Equipamento> equipamento) {
        this.equipamento = equipamento;
  }

    public Usuario getUsuario() {
       return usuario;
   }

    public void setUsuario(Usuario usuario) {
       this.usuario = usuario;
    }
}
