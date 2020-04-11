package quotes.tracking.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
    
    @Autowired
    public EnergyLevelServiceImpl(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }
    
    public EnergyLevelServiceImpl() {
        
    }

    public QuoteDTO getEnergyLevelByIsin(String isin) {
        Optional<Quote> quoteOpt = quoteRepository.findByIsin(isin);
        if (quoteOpt.isPresent()) {
            return convertQuoteEntityToQuoteDTO(quoteOpt.get());
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
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(quote, QuoteDTO.class);
    }
}
