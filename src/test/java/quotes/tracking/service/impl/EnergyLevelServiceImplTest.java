package quotes.tracking.service.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import quotes.tracking.dto.QuoteDTO;
import quotes.tracking.model.EnergyLevel;
import quotes.tracking.model.Quote;
import quotes.tracking.repository.QuoteRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EnergyLevelServiceImplTest {
    
    @Autowired
    private EnergyLevelServiceImpl energyLevelService;
    
    @MockBean
    private QuoteRepository quoteRepository;
    
    @BeforeEach
    public void init() {
        EnergyLevel energyLevel_1 = new EnergyLevel();
        energyLevel_1.setElvl(100.0);
        
        Quote quote_1 = new Quote();
        quote_1.setIsin("isinName_1");
        quote_1.setBid(50.0);
        quote_1.setAsk(60.0);
        quote_1.setEnergyLevel(energyLevel_1);
        
        EnergyLevel energyLevel_2 = new EnergyLevel();
        energyLevel_2.setElvl(200.0);
        
        Quote quote_2 = new Quote();
        quote_2.setIsin("isinName_2");
        quote_2.setBid(100.0);
        quote_2.setAsk(120.0);
        quote_2.setEnergyLevel(energyLevel_2);
        
        List<Quote> quoteList = new ArrayList<>();
        quoteList.add(quote_1);
        quoteList.add(quote_2);
        
        Mockito.doReturn(quoteList).when(quoteRepository).findAll();
        Mockito.doReturn(quote_2).when(quoteRepository).findByIsin("isinName_2");
    }
    
    @Test
    public void souldReturnAllQuoteDTOInQuoteRepository() {
        List<QuoteDTO> quoteDTOList = energyLevelService.getAllEnergyLevels();
        
        assertFalse(quoteDTOList.isEmpty());
        assertEquals(2, quoteDTOList.size());
        
        assertEquals("isinName_1", quoteDTOList.get(0).getIsin());
        assertEquals(60.0, quoteDTOList.get(0).getAsk());
        assertEquals(50.0, quoteDTOList.get(0).getBid());
        assertEquals(100.0, quoteDTOList.get(0).getEnergyLevel().getElvl());
        
        assertEquals("isinName_2", quoteDTOList.get(1).getIsin());
        assertEquals(120.0, quoteDTOList.get(1).getAsk());
        assertEquals(100.0, quoteDTOList.get(1).getBid());
        assertEquals(200.0, quoteDTOList.get(1).getEnergyLevel().getElvl());
    }
    
    @Test
    public void souldReturnQuoteDTOInQuoteRepositoryByIsin() {
        QuoteDTO quoteDTO = energyLevelService.getEnergyLevelByIsin("isinName_2");
        
        assertNotNull(quoteDTO);
        
        assertEquals("isinName_2", quoteDTO.getIsin());
        assertEquals(120.0, quoteDTO.getAsk());
        assertEquals(100.0, quoteDTO.getBid());
        assertEquals(200.0, quoteDTO.getEnergyLevel().getElvl());
    }
}
