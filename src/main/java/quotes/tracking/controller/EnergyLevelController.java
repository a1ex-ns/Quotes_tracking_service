package quotes.tracking.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import quotes.tracking.helper.QuoteFields;
import quotes.tracking.helper.URL;
import quotes.tracking.model.Quote;
import quotes.tracking.repository.QuoteRepository;

/**
 * The class represents the processing of requests for the /energyLevel URL.
 * 
 * @author Alexey Savchenko
 */
@RestController
public class EnergyLevelController {
	
	public EnergyLevelController() {
		
	}
	
	private QuoteRepository quoteRepository;
	
	@Autowired
	public EnergyLevelController(QuoteRepository quoteRepository) {
		this.quoteRepository = quoteRepository;
	}
	
	/**
	 * Returns energy level for the indicated quote.
	 * 
	 * @param isin quote isin name
	 */
	@GetMapping(URL.ENERGY_LEVEL)
	public String getEnergyLevelByIsin(@RequestParam(name = QuoteFields.ISIN, required = true) String isin) {
		Optional<Quote> quote = quoteRepository.findByIsin(isin);
		return quote.isPresent() ? quote.get().getElvl() : "Quote not found!";
	}
	
	/**
	 * Returns energy level for the all quotes.
	 */
	@GetMapping(URL.ALL_ENERGY_LEVEL)
	public Map<String, Double> getAllQuotes() {
		Map<String, Double> energyLevelMap = new HashMap<>();
		quoteRepository.findAll().forEach(quote -> energyLevelMap.put(quote.getIsin(), quote.getEnergyLevel().getElvl()));
		
		return energyLevelMap;
	}
}
