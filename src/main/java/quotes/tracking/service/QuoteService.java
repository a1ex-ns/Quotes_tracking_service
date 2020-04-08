package quotes.tracking.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import quotes.tracking.helper.EnergyLevelCalculation;
import quotes.tracking.helper.QuoteValidator;
import quotes.tracking.model.EnergyLevel;
import quotes.tracking.model.Quote;
import quotes.tracking.repository.QuoteRepository;

/**
 * 
 * 
 * @author Alexey Savchenko
 */
@Service
public class QuoteService {
	Logger logger = Logger.getLogger(QuoteService.class.getName());
	
	private QuoteRepository quoteRepository;
	private EnergyLevelCalculation energyLevelCalculationService;
	
	@Autowired
	public QuoteService(QuoteRepository quoteRepository, EnergyLevelCalculation energyLevelCalculationService) {
		this.quoteRepository = quoteRepository;
		this.energyLevelCalculationService = energyLevelCalculationService;
	}
	
	public QuoteService() {
		
	}
	
	@Transactional
	public void addQuote(Quote quote) {
		if (QuoteValidator.isValid(quote)) {
			String isin = quote.getIsin();
			if (checkQuote(isin)) {
				quoteRepository.setQuoteInfoByIsin(quote.getAsk(), quote.getBid(), isin);
			} else {
				EnergyLevel energyLevel = new EnergyLevel();
				energyLevel.setElvl(500.0);
				quote.setEnergyLevel(energyLevel);
				quoteRepository.save(quote);
			}
		} else {
			logger.log(Level.WARNING, "The quote {} is not valid.", quote);
		}
	}
	
//	@Transactional
//	public void update() {
//		quoteRepository.setQuoteInfoByIsin((double) 500, (double) 500, "zzzz11112222");
//	}
	
	public boolean checkQuote(String isin) {
		return getQuote(isin).isPresent();
	}

	public Optional<Quote> getQuote(String isin) {
		return quoteRepository.findByIsin(isin);
	}
}
