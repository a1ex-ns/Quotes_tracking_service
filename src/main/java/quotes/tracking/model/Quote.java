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

import quotes.tracking.helper.QuoteFields;

/**
 * 
 * 
 * @author Alexey Savchenko
 */
@Entity
@Table
public class Quote {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
//	@Column
    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "energyLevel_elvl")
	private EnergyLevel energyLevel;
    
    @Column
    private String isin;
	
	@Column
	private Double bid;
	
	@Column
	private Double ask;
	
	@Override
	public String toString() {
		return id + " " + isin + "  " + bid + " " + ask + " ";
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
}
