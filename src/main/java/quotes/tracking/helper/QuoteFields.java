package quotes.tracking.helper;

/**
 * Helper class with {@link Quote} fields.
 * <br><b>This class must be changed when changing fields in the {@link Quote}.</b>
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