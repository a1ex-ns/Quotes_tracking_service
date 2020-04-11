package quotes.tracking.service;

import quotes.tracking.model.Quote;

/**
 * Service for processing {@link Quote}.
 * 
 * @author Alexey Savchenko
 */
public interface QuoteService {
    
    /**
     * Adds a new quote or changes the value of the old one, if such a quote exists.
     */
    public void addQuote(Quote newQuote);
}
