package quotes.tracking.dto;

public class QuoteDTO {
    
    private Long id;
    private EnergyLevelDTO energyLevelDTO;
    private String isin;
    private Double bid;
    private Double ask;
    
    public QuoteDTO() {
        
    }
    
    public EnergyLevelDTO EnergyLevelDTO() {
        return energyLevelDTO;
    }
    
    public void setEnergyLevelDTO(EnergyLevelDTO energyLevelDTO) {
        this.energyLevelDTO = energyLevelDTO;
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
