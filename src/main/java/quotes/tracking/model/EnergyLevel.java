package quotes.tracking.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import quotes.tracking.helper.QuoteFields;

/**
 * The class is intended to describe the model quote for working with the database.
 * 
 * @author Alexey Savchenko
 */
@Entity
@Table
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class EnergyLevel {
	
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    
    @OneToOne(optional = false, mappedBy = QuoteFields.ENERGY_LEVEL, cascade = CascadeType.ALL)
    private Quote quote;
    
    @Column
    private Double elvl;
    
    public EnergyLevel() {
    	
    }
    
    public Long getId() {
    	return id;
    }
    
    public Double getElvl() {
    	return elvl;
    }
    
    public void setElvl(Double elvl) {
    	this.elvl = elvl;
    }
    
    @Override
    public int hashCode() {
    	final int prime = 31;
    	int result = 1;
    	result = prime * result + ((elvl == null) ? 0 : elvl.hashCode());
    	result = prime * result + ((quote == null) ? 0 : quote.hashCode());
    	return result;
    }
    
    @Override
    public boolean equals(Object obj) {
    	if (this == obj)
    		return true;
    	if (obj == null)
    		return false;
    	if (getClass() != obj.getClass())
    		return false;
    	EnergyLevel other = (EnergyLevel) obj;
    	if (elvl == null) {
    		if (other.elvl != null)
    			return false;
    	} else if (!elvl.equals(other.elvl))
    		return false;
    	if (quote == null) {
    		if (other.quote != null)
    			return false;
    	} else if (!quote.equals(other.quote))
    		return false;
    	return true;
    }
}
