package projarch.assignment.adapters.repository;

import java.util.List;
import java.util.Optional;

import projarch.assignment.domain.models.AluguelModel;

public interface IAluguelRepository {
    List<AluguelModel> getAllAlugueis();
    boolean validaAluguel(Integer id);
    List<AluguelModel> findByClienteId(Integer idCliente);
    List<AluguelModel> findByJogoId(Integer idJogo);
    Optional<AluguelModel> findById(Integer id);
    boolean existsById(Integer id);
    AluguelModel save(AluguelModel aluguel);
}
