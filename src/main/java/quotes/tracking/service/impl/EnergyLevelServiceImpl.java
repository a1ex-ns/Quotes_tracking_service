package quotes.tracking.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import quotes.tracking.model.Quote;
import quotes.tracking.repository.QuoteRepository;
import quotes.tracking.service.EnergyLevelService;

/**
 * @author Alexey Savchenko
 */
@Service
public class EnergyLevelServiceImpl implements EnergyLevelService {
    private QuoteRepository quoteRepository;
    
    @Autowired
    public EnergyLevelServiceImpl(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }
    
    public EnergyLevelServiceImpl() {
        
    }

    public Optional<Quote> getEnergyLevelByIsin(String isin) {
        return quoteRepository.findByIsin(isin);
    }
    
    public List<Quote> getAllEnergyLevels() {
        return quoteRepository.findAll();
    }
}
