package quotes.tracking.helper;

import quotes.tracking.model.Quote;

/**
 * 
 * 
 * @author Alexey Savchenko
 */
public class QuoteValidator {
	private static final int QUOTE_ISIN_LENGHT = 12; 
	
	private QuoteValidator() {
		throw new IllegalStateException("Сonstructor is not provided");
	}
	
	/**
	 * Метод отвечает за валидацию котировки
	 * 
	 * @param quote котривка
	 * @return <b>true</b> - все норм <br>
	 * 		   <b>false</b> - не не норм
	 */
	public static boolean isValid(Quote quote) {
		return quote.getBid() != null
				&& quote.getAsk() != null
				&& quote.getBid() < quote.getAsk() 
				&& quote.getIsin().length() == QUOTE_ISIN_LENGHT;
	}
}
