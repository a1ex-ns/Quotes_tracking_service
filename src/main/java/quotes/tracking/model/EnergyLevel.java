package quotes.tracking.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import quotes.tracking.helper.QuoteFields;

/**
 * 
 * 
 * @author Alexey Savchenko
 */
@Entity
@Table
public class EnergyLevel {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@OneToOne(optional = false, mappedBy = QuoteFields.ENERGY_LEVEL, cascade = CascadeType.ALL)
	private Quote quote;
	
	@Column
	private String isin;
	
	@Column
	private Double elvl;
	
	public EnergyLevel() {
		
	}
	
	public Quote getQuote() {
		return quote;
	}

	public void setQuote(Quote quote) {
		this.quote = quote;
	}

	public Long getId() {
		return id;
	}
	
	public String getIsin() {
		return isin;
	}
	
	public void setIsin(String isin) {
		this.isin = isin;
	}
	
	public Double getElvl() {
		return elvl;
	}
	
	public void setElvl(Double elvl) {
		this.elvl = elvl;
	}
}
