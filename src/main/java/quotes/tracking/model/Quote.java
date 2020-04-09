package quotes.tracking.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Alexey Savchenko
 */
@Entity
@Table
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Quote {
	
    @Id
    @JsonIgnore
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    
    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "energyLevel_id")
    private EnergyLevel energyLevel;
    
    @Column
    private String isin;
    
    @Column
    @JsonIgnore
    private Double bid;
    
    @Column
    @JsonIgnore
    private Double ask;
    
    @Override
    public String toString() {
    	return "Quote isin = " + isin
    			+ " bid = " + bid
    			+ " ask = " + ask
    			+ " elvl = " + energyLevel.getElvl().toString();
    }
    
    public Quote() {
    	
    }
    
    public EnergyLevel getEnergyLevel() {
    	return energyLevel;
    }
    
    public void setEnergyLevel(EnergyLevel energyLevel) {
    	this.energyLevel = energyLevel;
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
    
    public Double getBid() {
    	return bid;
    }
    
    public void setBid(Double bid) {
    	this.bid = bid;
    }
    
    public Double getAsk() {
    	return ask;
    }
    
    public void setAsk(Double ask) {
    	this.ask = ask;
    }
    
    @Override
    public int hashCode() {
    	final int prime = 31;
    	int result = 1;
    	result = prime * result + ((ask == null) ? 0 : ask.hashCode());
    	result = prime * result + ((bid == null) ? 0 : bid.hashCode());
    	result = prime * result + ((energyLevel == null) ? 0 : energyLevel.hashCode());
    	result = prime * result + ((isin == null) ? 0 : isin.hashCode());
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
    	Quote other = (Quote) obj;
    	if (ask == null) {
    		if (other.ask != null)
    			return false;
    	} else if (!ask.equals(other.ask))
    		return false;
    	if (bid == null) {
    		if (other.bid != null)
    			return false;
    	} else if (!bid.equals(other.bid))
    		return false;
    	if (energyLevel == null) {
    		if (other.energyLevel != null)
    			return false;
    	} else if (!energyLevel.equals(other.energyLevel))
    		return false;
    	if (isin == null) {
    		if (other.isin != null)
    			return false;
    	} else if (!isin.equals(other.isin))
    		return false;
    	return true;
    }
}
