//package quotes.tracking.service;
//
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//import quotes.tracking.model.EnergyLevel;
//import quotes.tracking.repository.EnergyLevelRepository;
//
///**
// * 
// * 
// * @author Alexey Savchenko
// */
//public class EnergyLevelService {
//	private EnergyLevelRepository energyLevelRepository;
//	
//	public EnergyLevelService() {
//		
//	}
//	
//	@Autowired
//	public EnergyLevelService(EnergyLevelRepository energyLevelRepository) {
//		this.energyLevelRepository = energyLevelRepository;
//		
//	}
//	
//	public boolean checkEnergyLevel(String isin) {
//		return getEnergyLevel(isin).isPresent();
//	}
//
//	public Optional<EnergyLevel> getEnergyLevel(String isin) {
//		return energyLevelRepository.findByIsin(isin);
//	}
//
//}
