package quotes.tracking.service;

import java.util.List;

import quotes.tracking.dto.QuoteDTO;

/**
 * Service for processing energy level.
 * 
 * @author Alexey Savchenko
 */
public interface EnergyLevelService {
    
    /**
     * Returns energy level for a given name isin.
     */
    public QuoteDTO getEnergyLevelByIsin(String isin);
    
    /**
     * Returns all energy levels.
     */
    public List<QuoteDTO> getAllEnergyLevels();

}
