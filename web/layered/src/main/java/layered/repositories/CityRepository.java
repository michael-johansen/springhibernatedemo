package layered.repositories;

import layered.model.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {
    @EntityGraph(value = "City.withCountry", type = EntityGraph.EntityGraphType.LOAD)
    @Override
    Page<City> findAll(Pageable pageable);
}
