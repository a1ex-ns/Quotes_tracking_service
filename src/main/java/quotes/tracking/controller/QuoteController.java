package quotes.tracking.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import quotes.tracking.helper.QuoteFields;
import quotes.tracking.helper.URL;
import quotes.tracking.model.Quote;
import quotes.tracking.repository.QuoteRepository;
import quotes.tracking.service.impl.QuoteServiceImpl;

@RestController
public class QuoteController {
	Logger logger = Logger.getLogger(QuoteController.class.getName());
	
	private final QuoteServiceImpl quoteService;
	
	public QuoteController(QuoteServiceImpl quoteService) {
		this.quoteService = quoteService;
	}
	
	@GetMapping(URL.QUOTES)
	public Quote getAllQuotes(@RequestParam(name = QuoteFields.ISIN, required = true) String isin) {
//		List<Quote> quotes = (List<Quote>) quoteRepository.findAll();
//		return quotes != null ? quotes : new ArrayList();
		System.err.println("@GetMapping(URL.QUOTES)");
		
		return quoteService.getQuote(isin);
	}
	
	@PostMapping(URL.QUOTES)
	public void addNewQuote(@RequestBody Quote quote) {
		quoteService.addQuote(quote);
	}
	
	
	
	
//	private int counter = 4;
//	
//    private List<Map<String, String>> messages = new ArrayList<Map<String, String>>() {{
//        add(new HashMap<String, String>() {{ put("id", "1"); put("text", "First message"); }});
//        add(new HashMap<String, String>() {{ put("id", "2"); put("text", "Second message"); }});
//        add(new HashMap<String, String>() {{ put("id", "3"); put("text", "Third message"); }});
//    }};
//	
//	@GetMapping
//	public List list() {
//		return messages;
//	}
	
//    @GetMapping("{id}")
//    public Map<String, String> getOne(@PathVariable String id) {
//        return getMessage(id);
//    }
    
//    private Map<String, String> getMessage(@PathVariable String id) {
//        return messages.stream()
//                .filter(message -> message.get("id").equals(id))
//                .findFirst()
//                .orElseThrow(NotFoundException::new);
//    }
    
//    @PostMapping
//    public Map<String, String> create(@RequestBody Map<String, String> message) {
//        message.put("id", String.valueOf(counter++));
//
//        messages.add(message);
//
//        return message;
//    }

//    @PutMapping("{id}")
//    public Map<String, String> update(@PathVariable String id, @RequestBody Map<String, String> message) {
//        Map<String, String> messageFromDb = getMessage(id);
//
//        messageFromDb.putAll(message);
//        messageFromDb.put("id", id);
//
//        return messageFromDb;
//    }

//    @DeleteMapping("{id}")
//    public void delete(@PathVariable String id) {
//        Map<String, String> message = getMessage(id);
//
//        messages.remove(message);
//    }
}
