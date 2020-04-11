package quotes.tracking.service;

import java.util.List;
import java.util.Optional;

import quotes.tracking.model.Quote;

/**
 * Service for processing energy level.
 * 
 * @author Alexey Savchenko
 */
public interface EnergyLevelService {
    
    /**
     * Returns energy level for a given name isin.
     */
    public Optional<Quote> getEnergyLevelByIsin(String isin);
    
    /**
     * Returns all energy levels.
     */
    public List<Quote> getAllEnergyLevels();

}
