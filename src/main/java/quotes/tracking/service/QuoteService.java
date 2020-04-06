package quotes.tracking.service;

import java.util.Optional;

import quotes.tracking.model.Quote;

public interface QuoteService {
	
	public void save (Quote quote);
	
	public Quote findByIsin(String isin);
}
