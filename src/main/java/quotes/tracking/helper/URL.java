package quotes.tracking.helper;

/**
 * 
 * 
 * @author Alexey Savchenko
 */
public class URL {
	public static final String QUOTES = "/quotes";
	public static final String ENERGY_LEVEL = "/energyLevel";
	public static final String ALL_ENERGY_LEVEL = "/allEnergyLevel";

	private URL() {
		throw new IllegalStateException("Сonstructor is not provided");
	}
}
