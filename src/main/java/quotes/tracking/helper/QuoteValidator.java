package quotes.tracking.helper;

import quotes.tracking.model.Quote;

/**
 * 
 * 
 * @author Alexey Savchenko
 */
public class QuoteValidator {
	private static final int QUOTE_ISIN_LENGHT = 12; 
	
	private QuoteValidator() {
		throw new IllegalStateException("Сonstructor is not provided");
	}
	
	public static boolean isValid(Quote quote) {
		return quote.getBid() < quote.getAsk() && quote.getIsin().length() == QUOTE_ISIN_LENGHT;
	}
}
