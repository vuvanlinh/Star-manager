package will.starmanager.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import will.starmanager.model.Star;

public interface StarService {
    Page<Star> findAll(Pageable pageable);

    Star findById(int id);

    void save(Star star);

    void remove(int id);

    Page<Star> findAllByNameContaining(String name, Pageable pageable);
}
