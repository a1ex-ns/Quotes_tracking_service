package quotes.tracking.service;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import quotes.tracking.helper.QuoteValidator;
import quotes.tracking.model.Quote;
import quotes.tracking.repository.QuoteRepository;

@Service
public class QuoteService {
	Logger logger = Logger.getLogger(QuoteService.class.getName());
	
	private QuoteRepository quoteRepository;
	 
	public QuoteService(QuoteRepository quoteRepository) {
		this.quoteRepository = quoteRepository;
	}
	
	public void addQuote(Quote quote) {
		if (QuoteValidator.isValid(quote)) {
			logger.log(Level.INFO, "quote.toString() = " + quote.toString());
			quoteRepository.save(quote);
//			logger.log(Level.WARNING, "quoteRepository.findAll() = " + quoteRepository.findAll());
		} else {
			logger.log(Level.WARNING, "The quote {0} is not valid.", quote);
		}
	}
}
