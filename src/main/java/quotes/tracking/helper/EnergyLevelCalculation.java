package quotes.tracking.helper;

import org.springframework.stereotype.Service;

import quotes.tracking.model.Quote;

/**
 * 
 * 
 * @author Alexey Savchenko
 */
public class EnergyLevelCalculation {
	
	public static Double elvlCalculation(Quote quote, Double currentElvl) {
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
