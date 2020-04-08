package quotes.tracking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import quotes.tracking.helper.URL;
import quotes.tracking.model.Quote;
import quotes.tracking.service.QuoteService;

/**
 * The class represents the processing of requests for the /quotes URL.
 * 
 * @author Alexey Savchenko
 */
@RestController
public class QuoteController {
	
	private QuoteService quoteService;
	
	@Autowired
	public QuoteController(QuoteService quoteService) {
		this.quoteService = quoteService;
	}
	
	public QuoteController() {
		
	}
	
	/**
	 * Accepts and processes quotes.
	 */
	@PostMapping(URL.QUOTES)
	public void addQuote(@RequestBody Quote quote) {
		quoteService.addQuote(quote);
	}
}
