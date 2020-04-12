package quotes.tracking.dto;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import quotes.tracking.model.EnergyLevel;

public class EnergyLevelDTOTest {
    private ModelMapper modelMapper = new ModelMapper();
    
    @Test
    public void shouldConvertEnergyLevelEntityToEnergyLevelDTO() {
        EnergyLevel energyLevel = new EnergyLevel();
        energyLevel.setElvl(550.0);
 
        EnergyLevelDTO energyLevelDTO = modelMapper.map(energyLevel, EnergyLevelDTO.class);
        
        assertEquals(energyLevel.getElvl(), energyLevelDTO.getElvl());
    }
 
    @Test
    public void shouldConvertEnergyLevelDTOToEnergyLevelEntity() {
        EnergyLevelDTO energyLevelDTO = new EnergyLevelDTO();
        energyLevelDTO.setElvl(330.0);
 
        EnergyLevel energyLevel = modelMapper.map(energyLevelDTO, EnergyLevel.class);
        
        assertEquals(energyLevelDTO.getElvl(), energyLevel.getElvl());
    }
}
