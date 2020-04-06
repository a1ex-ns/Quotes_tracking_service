package quotes.tracking.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import quotes.tracking.helper.QuoteValidator;
import quotes.tracking.model.Quote;
import quotes.tracking.repository.QuoteRepository;
import quotes.tracking.service.QuoteService;

@Service
//public class QuoteServiceImpl implements QuoteService {
public class QuoteServiceImpl {
	Logger logger = Logger.getLogger(QuoteServiceImpl.class.getName());
	
	private QuoteRepository quoteRepository;
	
	@Autowired
	public QuoteServiceImpl(QuoteRepository quoteRepository) {
		this.quoteRepository = quoteRepository;
	}
	
	public QuoteServiceImpl() {
		
	}
	
	public void addQuote(Quote quote) {
		if (QuoteValidator.isValid(quote)) {
			logger.log(Level.INFO, "quote.toString() = " + quote.toString()); //REFACTORING
			quoteRepository.save(quote);
		} else {
			logger.log(Level.WARNING, "The quote {} is not valid.", quote);
		}
	}

//	@Override
	public void save(Quote quote) {
		quoteRepository.save(quote);
	}

//	@Override
	public List<Quote> getQuote(String isin) {
		System.err.println("find isin " + isin);
//		System.err.println("FindALL " + quoteRepository.findAll());
		List<Quote> quote = quoteRepository.findByIsin(isin);
		System.err.println("findByIsin(isin) " + quote);
		return quote;
	}
}
