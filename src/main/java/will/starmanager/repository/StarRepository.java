package will.starmanager.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import will.starmanager.model.Star;

public interface StarRepository extends PagingAndSortingRepository<Star, Integer> {
    Page<Star> findAllByNameContaining(String name, Pageable pageable);
}
