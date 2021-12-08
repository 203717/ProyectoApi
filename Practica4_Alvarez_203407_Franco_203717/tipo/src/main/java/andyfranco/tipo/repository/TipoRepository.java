package andyfranco.tipo.repository;


import andyfranco.tipo.model.Tipo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TipoRepository extends CrudRepository<Tipo,Integer> {

    List<Tipo> findAll();
    Tipo save(Tipo tipo);
    Tipo findByTipoid(int tipoid);
    void delete(Tipo tipo);
}