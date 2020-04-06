package quotes.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import quotes.tracking.model.Quote;

@Repository
public interface QuoteRepository extends JpaRepository<Quote, Long> {
	
	List<Quote> findByIsin(String isin);
}
