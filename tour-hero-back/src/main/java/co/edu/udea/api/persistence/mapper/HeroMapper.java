package co.edu.udea.api.persistence.mapper;

import co.edu.udea.api.model.Hero;
import co.edu.udea.api.persistence.entity.HeroEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;

@Mapper(componentModel = "spring")
public interface HeroMapper {
    Hero toHero(HeroEntity heroEntity);

    @InheritInverseConfiguration
    @Mapping(target = "id", ignore = true)
    HeroEntity toHeroEntity(Hero hero);

    List<Hero> toHeroes (List<HeroEntity> heroEntities);
}
