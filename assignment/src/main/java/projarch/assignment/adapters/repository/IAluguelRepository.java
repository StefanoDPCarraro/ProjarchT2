package projarch.assignment.adapters.repository;

import java.util.List;

import projarch.assignment.domain.models.AluguelModel;

public interface IAluguelRepository {
    List<AluguelModel> getAllAlugueis();
}
