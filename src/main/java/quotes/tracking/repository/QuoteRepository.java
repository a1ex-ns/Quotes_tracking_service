package quotes.tracking.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import quotes.tracking.helper.QuoteFields;
import quotes.tracking.model.Quote;

/**
 * 
 * 
 * @author Alexey Savchenko
 */
@Repository
public interface QuoteRepository extends CrudRepository<Quote, Long> {
	
	Optional<Quote> findByIsin(String isin);
	
	@Modifying
	@Query("update Quote u set u." + QuoteFields.ASK + " = ?1, u." + QuoteFields.BID + " = ?2 where u." + QuoteFields.ISIN +" = ?3")
	void setQuoteInfoByIsin(double ask, double bid, String isin);
}
