package will.starmanager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import will.starmanager.model.Star;
import will.starmanager.repository.StarRepository;
import will.starmanager.service.StarService;

public class StarServiceImpl implements StarService {

    @Autowired
    private StarRepository starRepository;

    @Override
    public Page<Star> findAll(Pageable pageable) {
        return starRepository.findAll(pageable);
    }

    @Override
    public Star findById(int id) {
        return starRepository.findById(id).orElse(null);
    }

    @Override
    public void Save(Star star) {
        starRepository.save(star);
    }

    @Override
    public void remove(int id) {
        starRepository.deleteById(id);
    }

    @Override
    public Page<Star> findAllByNameContaining(String name, Pageable pageable) {
        return starRepository.findAllByNameContaining(name, pageable);
    }
}
