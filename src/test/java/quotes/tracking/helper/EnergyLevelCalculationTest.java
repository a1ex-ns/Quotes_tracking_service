package quotes.tracking.helper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import quotes.tracking.helper.EnergyLevelCalculation;
import quotes.tracking.model.EnergyLevel;
import quotes.tracking.model.Quote;

public class EnergyLevelCalculationTest {
    private Quote quote; 
    
    @BeforeEach
    public void init() {
        quote = new Quote();
        quote.setEnergyLevel(new EnergyLevel());
    }
    
    @Test
    public void elvlShouldEqualToBid() {
        quote.setBid(100.0);
        quote.getEnergyLevel().setElvl(50.0);
        
        assertEquals(100.0, EnergyLevelCalculation.elvlCalculation(quote));
    }
    
    @Test
    public void elvlShouldEqualToAsk() {
        quote.setAsk(50.0);
        quote.getEnergyLevel().setElvl(200.0);
        
        assertEquals(50.0, EnergyLevelCalculation.elvlCalculation(quote));
    }
    
    @Test
    public void elvlShouldEqualToBidIfelvlNull() {
        quote.setBid(25.0);
        
        assertEquals(25.0, EnergyLevelCalculation.elvlCalculation(quote));
    }
    
    @Test
    public void elvlShouldEqualToAskIfBidNull() {
        quote.setAsk(12.5);
        
        assertEquals(12.5, EnergyLevelCalculation.elvlCalculation(quote));
    }
}
