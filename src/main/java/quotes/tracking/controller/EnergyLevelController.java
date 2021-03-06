package quotes.tracking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import quotes.tracking.dto.QuoteDTO;
import quotes.tracking.helper.URL;
import quotes.tracking.model.Quote;
import quotes.tracking.service.EnergyLevelService;

/**
 * The class represents the processing of requests for the /energyLevel URL.
 * 
 * @author Alexey Savchenko
 */
@RestController
public class EnergyLevelController {
	
    public EnergyLevelController() {
    	
    }
    
    private EnergyLevelService energyLevelService;
    
    @Autowired
    public EnergyLevelController(EnergyLevelService energyLevelService) {
    	this.energyLevelService = energyLevelService;
    }
    
    /**
     * Returns energy level for the indicated quote.
     * 
     * @param isin quote isin name
     */
    @GetMapping(URL.ENERGY_LEVEL)
    public QuoteDTO getEnergyLevelByIsin(@RequestParam(name = Quote.ISIN, required = true) String isin) {
        return energyLevelService.getEnergyLevelByIsin(isin);
    }
    
    /**
     * Returns energy level for the all quotes.
     */
    @GetMapping(URL.ALL_ENERGY_LEVEL)
    public List<QuoteDTO> getAllEnergyLevels() {
    	return energyLevelService.getAllEnergyLevels();
    }
}
