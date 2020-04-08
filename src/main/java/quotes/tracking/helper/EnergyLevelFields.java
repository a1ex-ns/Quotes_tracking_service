package quotes.tracking.helper;

/**
 * Helper class with {@link EnergyLevel} fields.
 * <br><b>This class must be changed when changing fields in the {@link EnergyLevel}.</b>
 * 
 * @author Alexey Savchenko
 */
public class EnergyLevelFields {
    public static final String ID = "id";
    public static final String ELVL = "elvl";
    public static final String QUOTE = "quote";
    
    private EnergyLevelFields() {
    	throw new IllegalStateException("Сonstructor is not provided");
    }
}