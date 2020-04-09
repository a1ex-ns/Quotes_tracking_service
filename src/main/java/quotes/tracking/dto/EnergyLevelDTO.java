package quotes.tracking.dto;

import quotes.tracking.model.Quote;

public class EnergyLevelDTO {
    private Long id;
    private Quote quote;
    private Double elvl;
    
    public EnergyLevelDTO() {
        
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
    
    public Double getElvl() {
        return elvl;
    }
    
    public void setElvl(Double elvl) {
        this.elvl = elvl;
    }
}
