package quotes.tracking.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import quotes.tracking.helper.QuoteFields;
import quotes.tracking.model.EnergyLevel;

/**
 * 
 * 
 * @author Alexey Savchenko
 */
@Repository
public interface EnergyLevelRepository extends CrudRepository<EnergyLevel, Long> {

	Optional<EnergyLevel> findByIsin(String isin);
	
//	@Modifying
//	@Query("update EnergyLevel u set u." + QuoteFields.ASK + " = ?1, u." + QuoteFields.BID + " = ?2 where u." + QuoteFields.ISIN +" = ?3")
//	void setEnergyLevelInfoByIsin(double ask, double bid, String isin);
	
}
