package projarch.assignment.infra.database.IJpaRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import projarch.assignment.infra.database.entity.ClienteEntity;

public interface IClienteJpaRepository extends JpaRepository<ClienteEntity, Integer>{

}
