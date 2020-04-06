package quotes.tracking.helper;

public class QuoteFields {
	
	private QuoteFields() {
		throw new IllegalStateException("Сonstructor is not provided");
	}
	
	public static final String ISIN = "isin";
	public static final String BID = "bid";
	public static final String ASK = "ask";
}