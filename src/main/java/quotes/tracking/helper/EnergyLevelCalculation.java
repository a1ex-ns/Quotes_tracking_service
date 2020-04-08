package quotes.tracking.helper;

import quotes.tracking.model.Quote;

/**
 * Helper class for energy level calculation.
 * 
 * @author Alexey Savchenko
 */
public class EnergyLevelCalculation {
	
	private EnergyLevelCalculation() {
		    throw new IllegalStateException("Сonstructor is not provided");
		  }
	
	/**
	 * Calculates a new energy level value.
	 * 
	 * @param quote for which it is necessary to calculate the value.
	 */
	public static Double elvlCalculation(Quote quote) {
		Double currentElvl = quote.getEnergyLevel().getElvl();
		if (currentElvl == null && quote.getBid() != null) {
			currentElvl = quote.getBid();
		}  else if (quote.getBid() == null && quote.getAsk() != null) {
			currentElvl = quote.getAsk();
		}  else if (quote.getBid() != null && quote.getBid() > currentElvl) {
			currentElvl = quote.getBid();
		} else if (quote.getAsk() != null && quote.getAsk() < currentElvl) {
			currentElvl = quote.getAsk();
		}
		
		return currentElvl;
	}
}
