package quotes.tracking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import quotes.tracking.model.Quote;
import quotes.tracking.repository.QuoteRepository;

/**
 * Service for processing energy level.
 * 
 * @author Alexey Savchenko
 */
@Service
public class EnergyLevelService {
    private QuoteRepository quoteRepository;
    
    @Autowired
    public EnergyLevelService(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }
    
    public EnergyLevelService() {
        
    }

    public Optional<Quote> getEnergyLevelByIsin(String isin) {
        return quoteRepository.findByIsin(isin);
    }
    
    public List<Quote> getAllEnergyLevels() {
        return quoteRepository.findAll();
    }
}
