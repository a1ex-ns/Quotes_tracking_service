package quotes.tracking.dto;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import quotes.tracking.model.EnergyLevel;
import quotes.tracking.model.Quote;

public class QuoteDTOTest {
    private ModelMapper modelMapper = new ModelMapper();
    
    @Test
    public void shouldConvertQuoteEntityToQuoteDTO() {
        EnergyLevel energyLevel = new EnergyLevel();
        energyLevel.setElvl(150.0);
        
        Quote quote = new Quote();
        quote.setAsk(100.0);
        quote.setBid(50.0);
        quote.setIsin("isinName");
        quote.setEnergyLevel(energyLevel);
 
        QuoteDTO quoteDTO = modelMapper.map(quote, QuoteDTO.class);
        
        assertEquals(quote.getIsin(), quoteDTO.getIsin());
        assertEquals(quote.getAsk(), quoteDTO.getAsk());
        assertEquals(quote.getBid(), quoteDTO.getBid());
        assertEquals(quote.getEnergyLevel().getElvl(), quoteDTO.getEnergyLevel().getElvl());
    }
 
    @Test
    public void shouldConvertQuoteDTOToQuoteEntity() {
        EnergyLevelDTO energyLevelDTO = new EnergyLevelDTO();
        energyLevelDTO.setElvl(220.0);
        
        QuoteDTO quoteDTO = new QuoteDTO();
        quoteDTO.setAsk(120.0);
        quoteDTO.setBid(75.0);
        quoteDTO.setIsin("isinNameDTO");
        quoteDTO.setEnergyLevel(energyLevelDTO);
 
        Quote quote = modelMapper.map(quoteDTO, Quote.class);
        
        assertEquals(quoteDTO.getIsin(), quote.getIsin());
        assertEquals(quoteDTO.getAsk(), quote.getAsk());
        assertEquals(quoteDTO.getBid(), quote.getBid());
        assertEquals(quoteDTO.getEnergyLevel().getElvl(), quote.getEnergyLevel().getElvl());
    }
}
