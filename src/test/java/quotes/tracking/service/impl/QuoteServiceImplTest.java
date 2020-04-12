package quotes.tracking.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import quotes.tracking.model.Quote;
import quotes.tracking.repository.QuoteRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QuoteServiceImplTest {
    private Quote quote;
    
    @Autowired
    private QuoteServiceImpl quoteService;
    
    @MockBean
    private QuoteRepository quoteRepository;
    
    @BeforeEach
    public void init() {
        quote = new Quote();
    }
    
    @Test
    public void shouldCallSaveMethodIfQuoteIsValid() {
        quote.setIsin("isinName1234");
        quote.setBid(10.0);
        quote.setAsk(20.0);
        
        quoteService.addQuote(quote);
        
        Mockito.verify(quoteRepository, Mockito.times(1)).save(quote);
    }
    
    @Test
    public void shouldNotCallSaveMethodIfQuoteIsInvalid() {
        quote.setIsin("isinName12345");
        quote.setBid(10.0);
        quote.setAsk(20.0);
        
        quoteService.addQuote(quote);
        
        Mockito.verify(quoteRepository, Mockito.times(0)).save(quote);
    }
}
