/**
 * Enum that storing the currency unit including its name and value.
 * @author Nuttapong Rojanavanich
 */
public enum Currency implements Unit{
	BAHT("Thai Baht", 1.0),
	US_DOLLAR("US Dollar", 34.93),
	YEN("Japanese Yen", 0.33),
	YUAN("Chinese yuan", 5.40),
	EURO("Euro", 39.98),
	POUND("British Pound", 51.03),
	RINGGIT("Malaysia Ringgit", 8.92),
	RUBLE("Russian Ruble", 0.53),
	WON("South Korea Won", 0.03);
	
	public final String name;
	public final double value;
	
	/**
	 * Constructor with name and value as arguments.
	 * @param name is the name of currency unit.
	 * @param value is the value of currency unit.
	 */
	private Currency(String name, double value) {
		this.name = name;
		this.value = value;
	}
	
	/**
	 * Return the value of currency unit.
	 */
	public double getValue()  {
		return value;
	}
	
	/**
	 * Return the name of currency unit.
	 */
	public String toString() {
		return name;
	}
}
