package quotes.tracking.repository;

import org.springframework.data.repository.CrudRepository;

import quotes.tracking.model.EnergyLevel;

public interface EnergyLevelRepository extends CrudRepository<EnergyLevel, Long> {

}
