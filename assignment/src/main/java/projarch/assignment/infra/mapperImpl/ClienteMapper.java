package projarch.assignment.infra.mapperImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.NoArgsConstructor;
import projarch.assignment.adapters.IMapper.IClienteMapper;
import projarch.assignment.application.dto.request.CreateClienteDTO;
import projarch.assignment.application.dto.response.ClienteResponseDTO;
import projarch.assignment.application.dto.response.EmpresarialResponseDTO;
import projarch.assignment.application.dto.response.IndividualResponseDTO;
import projarch.assignment.domain.models.Cliente;
import projarch.assignment.domain.models.Empresarial;
import projarch.assignment.domain.models.Individual;
import projarch.assignment.infra.database.entity.ClienteEntity;
import projarch.assignment.infra.database.entity.EmpresarialEntity;
import projarch.assignment.infra.database.entity.IndividualEntity;

@Component
@NoArgsConstructor
public class ClienteMapper implements IClienteMapper{
    public ClienteEntity toEntity(Cliente domain){
        if (domain == null) {
            return null;
        }


        if (domain instanceof Empresarial) {
            return toEntityEmpresarial((Empresarial) domain);
        }

        if (domain instanceof Individual) {
            return toEntityIndividual((Individual) domain);
        }

        throw new IllegalArgumentException();
    }

    public List<ClienteEntity> toEntity(List<Cliente> domain){
        if (domain == null) {
            return null;
        }

        List<ClienteEntity> entities = new ArrayList<>();
        for(Cliente cliente : domain){
            entities.add(toEntity(cliente));
        }
        return entities;  
    
    }

    private EmpresarialEntity toEntityEmpresarial(Empresarial empresarial){
        return new EmpresarialEntity(empresarial.getNumero(), 
        empresarial.getNome(), 
        empresarial.getEndereço(), 
        empresarial.getNomeFantasia(), 
        empresarial.getCnpj());
    }

    private IndividualEntity toEntityIndividual(Individual individual){
        return new IndividualEntity(individual.getNumero(), 
        individual.getNome(), 
        individual.getEndereço(), 
        individual.getCpf());
    }



    public Cliente toDomain(ClienteEntity entity){
        if (entity == null) {
            return null;
        }
        

        if (entity instanceof EmpresarialEntity) {
            return toDomainEmpresarial((EmpresarialEntity) entity);
        }

        if (entity instanceof IndividualEntity) {
            return toDomainIndividual((IndividualEntity) entity);
        }

        throw new IllegalArgumentException();
    }


    public List<Cliente> toDomain(List<ClienteEntity> entity){
        if (entity == null) {
            return null;
        }

        List<Cliente> domains = new ArrayList<>();
        for(ClienteEntity cliente : entity){
            domains.add(toDomain(cliente));
        }
        return domains;  
    
    }

    private Empresarial toDomainEmpresarial(EmpresarialEntity entity){
        return new Empresarial(entity.getNumero(), 
        entity.getNome(), 
        entity.getEndereco(), 
        entity.getNomeFantasia(), 
        entity.getCnpj());
    }

    private Individual toDomainIndividual(IndividualEntity entity){
        return new Individual(entity.getNumero(), 
        entity.getNome(), 
        entity.getEndereco(), 
        entity.getCpf());
    }

    @Override
    public Cliente toDomain(CreateClienteDTO dto){
        if(dto == null){
            return null;
        }

        if(dto.getTipo().equalsIgnoreCase("empresarial")){
            return toDomainEmpresarial(dto);
        }

        if(dto.getTipo().equalsIgnoreCase("individual")){
            return toDomainIndividual(dto);
        }

        throw new IllegalArgumentException();

    }

    private Empresarial toDomainEmpresarial(CreateClienteDTO dto){
        return new Empresarial(dto.getNumero(), 
        dto.getNome(), 
        dto.getEndereço(),
        dto.getNomeFantasia(),
        dto.getCnpj());
    }

    private Individual toDomainIndividual(CreateClienteDTO dto){
        return new Individual(dto.getNumero(), 
        dto.getNome(), 
        dto.getEndereço(),
        dto.getCpf());
    }

    public ClienteResponseDTO toResponseDTO(Cliente domain){
        if (domain == null) {
            return null;
        }


        if (domain instanceof Empresarial) {
            return toEmpresarialResponseDTO((Empresarial) domain);
        }

        if (domain instanceof Individual) {
            return toIndividualResponseDTO((Individual) domain);
        }

        throw new IllegalArgumentException();
    }

    @Override
    public List<ClienteResponseDTO> toResponseDTO(List<Cliente> domain){
        if (domain == null) {
            return null;
        }

        List<ClienteResponseDTO> dtos = new ArrayList<>();
        for(Cliente cliente : domain){
            dtos.add(toResponseDTO(cliente));
        }
        return dtos;
    }

    private EmpresarialResponseDTO toEmpresarialResponseDTO(Empresarial domain){
        return new EmpresarialResponseDTO(domain.getNumero(),
        domain.getNome(),
        domain.getEndereço(),
        domain.getNomeFantasia(),
        domain.getCnpj());
    }

    private IndividualResponseDTO toIndividualResponseDTO(Individual domain){
        return new IndividualResponseDTO(domain.getNumero(),
        domain.getNome(),
        domain.getEndereço(),
        domain.getCpf());
    }
}

