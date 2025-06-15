package projarch.assignment.infra.database.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@Entity
@Table(name = "jogo")
@Inheritance(strategy = InheritanceType.JOINED)
public class Jogo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;
    private String nome;
    private double valorBase;
    public Jogo(){}
    public Jogo(Integer codigo, String nome, double valorBase) {
        this.codigo = codigo;
        this.nome = nome;
        this.valorBase = valorBase;
    }
    public Integer getCodigo() {
        return codigo;
    }
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public double getValorBase() {
        return valorBase;
    }
    public void setValorBase(double valorBase) {
        this.valorBase = valorBase;
    }
}
