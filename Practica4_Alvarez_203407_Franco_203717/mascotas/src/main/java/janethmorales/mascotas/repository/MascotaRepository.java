package janethmorales.mascotas.repository;

import janethmorales.mascotas.model.Mascota;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MascotaRepository extends CrudRepository<Mascota, Integer> {
    List<Mascota> findAll();
    Mascota findByMascotaId(int mascotaId);
    Mascota save (Mascota mascota);

    Mascota findByTipoId(int tipoId);
}
