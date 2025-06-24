package projarch.assignment.infra.database.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "individual")
@NoArgsConstructor
@Getter
@Setter
public class IndividualEntity extends ClienteEntity{
    private String cpf;

    public IndividualEntity(Integer numero, String nome, String endereco, String cpf) {
        super(numero, nome, endereco);
        this.cpf = cpf;
    }
    
}
