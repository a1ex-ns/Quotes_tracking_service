package quotes.tracking.service.impl;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import quotes.tracking.helper.EnergyLevelCalculation;
import quotes.tracking.helper.QuoteValidator;
import quotes.tracking.model.EnergyLevel;
import quotes.tracking.model.Quote;
import quotes.tracking.repository.QuoteRepository;
import quotes.tracking.service.QuoteService;

/**
 * @author Alexey Savchenko
 */
@Service
public class QuoteServiceImpl implements QuoteService {
    Logger logger = Logger.getLogger(QuoteServiceImpl.class.getName());
    
    private QuoteRepository quoteRepository;
    
    @Autowired
    public QuoteServiceImpl(QuoteRepository quoteRepository) {
    	this.quoteRepository = quoteRepository;
    }
    
    public QuoteServiceImpl() {
    	
    }
    
    public void addQuote(Quote newQuote) {
    	if (QuoteValidator.isValid(newQuote)) {
    		Optional<Quote> optQuote = getQuote(newQuote.getIsin());
    		if (optQuote.isPresent() && !optQuote.get().equals(newQuote)) {
    			Quote quote = optQuote.get();
    			quote.setAsk(newQuote.getAsk());
    			quote.setBid(newQuote.getBid());
    			quote.getEnergyLevel().setElvl(EnergyLevelCalculation.elvlCalculation(quote));
    			saveQuote(quote);
    			logger.log(Level.INFO, "Quote changed {}", newQuote);
    		} else {
    			EnergyLevel energyLevel = new EnergyLevel();
    			energyLevel.setElvl(EnergyLevelCalculation.elvlCalculation(newQuote));
    			newQuote.setEnergyLevel(energyLevel);
    			saveQuote(newQuote);
    			logger.log(Level.INFO, "Save new quote {}", newQuote);
    		}
    	} else {
    		logger.log(Level.WARNING, "The quote {} is not valid.", newQuote);
    	}
    }
    
    private void saveQuote(Quote quote) {
    	quoteRepository.save(quote);
    }
    
    private Optional<Quote> getQuote(String isin) {
    	return quoteRepository.findByIsin(isin);
    }
}
