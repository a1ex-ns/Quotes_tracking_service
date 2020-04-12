package quotes.tracking.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import quotes.tracking.dto.QuoteDTO;
import quotes.tracking.model.Quote;
import quotes.tracking.repository.QuoteRepository;
import quotes.tracking.service.EnergyLevelService;

/**
 * @author Alexey Savchenko
 */
@Service
public class EnergyLevelServiceImpl implements EnergyLevelService {
    Logger logger = Logger.getLogger(EnergyLevelServiceImpl.class.getName());
    
    private QuoteRepository quoteRepository;
    private ModelMapper modelMapper = new ModelMapper();
    
    @Autowired
    public EnergyLevelServiceImpl(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }
    
    public EnergyLevelServiceImpl() {
        
    }

    public QuoteDTO getEnergyLevelByIsin(String isin) {
        Quote quote = quoteRepository.findByIsin(isin);
        if (quote != null) {
            return convertQuoteEntityToQuoteDTO(quote);
        } else {
            logger.log(Level.WARNING, "The quote " + isin + " is not found.");
            return null;
        }
    }
    
    public List<QuoteDTO> getAllEnergyLevels() {
        List<QuoteDTO> quoteDTOList = new ArrayList<>();
        quoteRepository.findAll().forEach(quote -> quoteDTOList.add(convertQuoteEntityToQuoteDTO(quote)));
        return quoteDTOList;
    }
    
    private QuoteDTO convertQuoteEntityToQuoteDTO(Quote quote) {
        return modelMapper.map(quote, QuoteDTO.class);
    }
}
