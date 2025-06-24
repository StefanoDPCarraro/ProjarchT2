package projarch.assignment.infra.database.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "empresarial")
@NoArgsConstructor
@Getter
@Setter
public class EmpresarialEntity extends ClienteEntity{
    private String nomeFantasia;
    private String  cnpj;

    public EmpresarialEntity(Integer numero, String nome, String endereco, String nomeFantasia, String cnpj){
        super(numero, nomeFantasia, endereco);
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
    }
}

