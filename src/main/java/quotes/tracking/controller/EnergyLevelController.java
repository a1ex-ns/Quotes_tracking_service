package quotes.tracking.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import quotes.tracking.helper.QuoteFields;
import quotes.tracking.helper.URL;
import quotes.tracking.model.Quote;
import quotes.tracking.repository.QuoteRepository;

/**
 * 
 * 
 * @author Alexey Savchenko
 */
@RestController
public class EnergyLevelController {
	Logger logger = Logger.getLogger(EnergyLevelController.class.getName());
	
	public EnergyLevelController() {
		
	}
	
	private QuoteRepository quoteRepository;
	
	@Autowired
	public EnergyLevelController(QuoteRepository quoteRepository) {
		this.quoteRepository = quoteRepository;
	}
	
	@GetMapping(URL.ENERGY_LEVEL)
	public String getAllQuotes(@RequestParam(name = QuoteFields.ISIN, required = true) String isin) {
		
		return getEnergyLevel(isin);
	}
	
	@GetMapping(URL.ALL_ENERGY_LEVEL)
	public Map<String, Double> getAllQuotes() {
		Map<String, Double> energyLevelMap = new HashMap();
		quoteRepository.findAll().forEach(quote -> energyLevelMap.put(quote.getIsin(), quote.getEnergyLevel().getElvl()));
		
		return energyLevelMap;
	}
	
	private String getEnergyLevel(String isin) {
		Optional<Quote> quote = quoteRepository.findByIsin(isin);
		return quote.isPresent() ? quote.get().getIsin() + " " + quote.get().getEnergyLevel().getElvl() : "Quote not foind!";
	}
	
	
	
}
