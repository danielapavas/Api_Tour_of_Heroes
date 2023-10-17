package co.edu.udea.api.persistence.crud;

import co.edu.udea.api.persistence.entity.HeroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface HeroCrud extends JpaRepository<HeroEntity, String> {
    Optional<HeroEntity> findHeroEntitiesById(Integer id);

    void deleteHeroEntitiesById(Integer id);

    List<HeroEntity> findAllByNameIsContainingIgnoreCase(String term);
}
