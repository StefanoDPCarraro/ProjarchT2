package projarch.assignment.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projarch.assignment.infra.entities.cliente.ClienteEntity;

public interface ClienteRepositoryJPA extends JpaRepository<ClienteEntity, Integer>{
    
}
