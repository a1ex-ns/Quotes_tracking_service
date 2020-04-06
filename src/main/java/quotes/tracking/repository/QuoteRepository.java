package quotes.tracking.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import quotes.tracking.model.Quote;

@Repository
public interface QuoteRepository extends CrudRepository<Quote, Long> {
	
	Optional<Quote> findByIsin(String isin);
}
