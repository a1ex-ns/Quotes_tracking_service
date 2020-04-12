package quotes.tracking.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import quotes.tracking.model.Quote;

/**
 * @author Alexey Savchenko
 */
@Repository
public interface QuoteRepository extends CrudRepository<Quote, Long> {
	
    List<Quote> findAll();
    
    Quote findByIsin(String isin);
}
