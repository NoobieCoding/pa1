/**
 * Enum that storing the weight unit including its name and value.
 * @author Nuttapong Rojanavanich
 */
public enum Weight implements Unit{
	GRAM("Gram", 1.0),
	KILOGRAM("Kilogram", 1000),
	MILLIGRAM("Milligram", 0.001),
	MICROGRAM("Microgram", 1.0E-6),
	POUND("Pound", 453.392),
	US_TON("US ton", 9.0718e5),
	OUNCE("Ounce", 28.3495),
	STONE("Stone", 6350.29),
	BAHT("Baht", 15.0);
	
	public final String name;
	public final double value;
	
	/**
	 * Constructor with name and value as arguments.
	 * @param name is the name of weight unit.
	 * @param value is the value of weight unit.
	 */
	private Weight(String name, double value) {
		this.name = name;
		this.value = value;
	}
	
	/**
	 * Return the value of weight unit.
	 */
	public double getValue()  {
		return value;
	}
	
	/**
	 * Return the name of weight unit.
	 */
	public String toString() {
		return name;
	}
}
