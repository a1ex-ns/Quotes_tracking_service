package quotes.tracking.repository;

import org.springframework.data.repository.CrudRepository;

import quotes.tracking.model.Quote;

public interface QuoteRepository extends CrudRepository<Quote, Long> {

}
