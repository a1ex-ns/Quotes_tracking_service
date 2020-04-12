package quotes.tracking.helper;

import quotes.tracking.model.Quote;

/**
 * The class is responsible for validating quotes.
 * 
 * @author Alexey Savchenko
 */
public class QuoteValidator {
    private static final int QUOTE_ISIN_LENGHT = 12; 
    
    private QuoteValidator() {
    	throw new IllegalStateException("Сonstructor is not provided");
    }
    
    /**
     * Сhecks the quote for validity.
     * 
     * @param quote quotation which requires verification
     * @return <b>true</b> - the quote is valid <br>
     * 		   <b>false</b> - the quote is not valid
     */
    public static boolean isValid(Quote quote) {
    	return quote.getIsin() != null
    	        && quote.getBid() != null
    			&& quote.getAsk() != null
    			&& quote.getBid() < quote.getAsk() 
    			&& quote.getIsin().length() == QUOTE_ISIN_LENGHT;
    }
}
