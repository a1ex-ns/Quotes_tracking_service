package quotes.tracking.helper;

/**
 * 
 * 
 * @author Alexey Savchenko
 */
public class QuoteFields {
	public static final String ID = "id";
	public static final String ISIN = "isin";
	public static final String BID = "bid";
	public static final String ASK = "ask";
	public static final String ENERGY_LEVEL = "energyLevel";
	
	private QuoteFields() {
		throw new IllegalStateException("Сonstructor is not provided");
	}
}