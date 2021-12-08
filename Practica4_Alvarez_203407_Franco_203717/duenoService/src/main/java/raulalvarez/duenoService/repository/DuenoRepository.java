package raulalvarez.duenoService.repository;

import org.springframework.data.repository.CrudRepository;
import raulalvarez.duenoService.model.Dueno;

import java.util.List;

public interface DuenoRepository extends CrudRepository<Dueno,Integer> {

    List<Dueno> findAll();
    Dueno findByDuenoId(int duenoId);
    Dueno save(Dueno dueno);
    void delete(Dueno dueno);
}
