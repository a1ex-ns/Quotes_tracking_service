package quotes.tracking.helper;

import quotes.tracking.model.Quote;

public class QuoteValidator {
	
	private QuoteValidator() {
		throw new IllegalStateException("Сonstructor is not provided");
	}
	
	private static final int QUOTE_ISIN_LENGHT = 12; 
	
	public static boolean isValid(Quote quote) {
		return quote.getBid() < quote.getAsk() && quote.getIsin().length() == QUOTE_ISIN_LENGHT;
	}
}
