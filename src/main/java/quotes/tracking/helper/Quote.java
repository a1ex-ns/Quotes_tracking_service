package quotes.tracking.helper;

public class Quote {
	
	private Quote() {
		throw new IllegalStateException("Сonstructor is not provided");
	}
	
	public static final String ISIN = "isin";
	public static final String BID = "bid";
	public static final String ASK = "ask";
}