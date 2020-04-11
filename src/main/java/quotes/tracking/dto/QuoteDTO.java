package quotes.tracking.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import quotes.tracking.model.Quote;

/**
 * The class is needed as the DTO object for working with the class {@link Quote}.
 * 
 * @author Alexey Savchenko
 */
public class QuoteDTO {
    private String isin;
    
    @JsonIgnore
    private Double bid;
    
    @JsonIgnore
    private Double ask;
    
    private EnergyLevelDTO energyLevelDTO;
    
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
    public EnergyLevelDTO getEnergyLevel() {
        return energyLevelDTO;
    }
    public void setEnergyLevel(EnergyLevelDTO energyLevel) {
        this.energyLevelDTO = energyLevel;
    }
}
