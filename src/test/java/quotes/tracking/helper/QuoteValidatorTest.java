package quotes.tracking.helper;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import quotes.tracking.model.Quote;

public class QuoteValidatorTest {
    
    @Test
    public void shouldReturnFalseIfBidOverAsk() {
        Quote quote = new Quote();
        
        quote.setIsin("isinName1234");
        quote.setAsk(10.0);
        quote.setBid(20.0);
        
        assertFalse(QuoteValidator.isValid(quote));
    }
    
    @Test
    public void shouldReturnFalseIfIsinOver12Symbols() {
        Quote quote = new Quote();
        
        quote.setIsin("isinName12345");
        quote.setAsk(20.0);
        quote.setBid(10.0);
        
        assertFalse(QuoteValidator.isValid(quote));
    }
    
    @Test
    public void shouldReturnFalseIfIsinLess12Symbols() {
        Quote quote = new Quote();
        
        quote.setIsin("isinName123");
        quote.setAsk(20.0);
        quote.setBid(10.0);
        
        assertFalse(QuoteValidator.isValid(quote));
    }
    
    @Test
    public void shouldReturnTrueIfQuoteValid() {
        Quote quote = new Quote();
        
        quote.setIsin("isinName1234");
        quote.setAsk(20.0);
        quote.setBid(10.0);
        
        assertTrue(QuoteValidator.isValid(quote));
    }
}
