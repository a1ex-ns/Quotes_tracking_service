package quotes.tracking.dto;

import quotes.tracking.model.EnergyLevel;

/**
 * The class is needed as the DTO object for working with the class {@link EnergyLevel}.
 * 
 * @author Alexey Savchenko
 */
public class EnergyLevelDTO {
    private Double elvl;
    
    public Double getElvl() {
        return elvl;
    }

    public void setElvl(Double elvl) {
        this.elvl = elvl;
    }
}
