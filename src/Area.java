/**
 * Enum that storing the area unit including its name and value.
 * @author Nuttapong Rojanavanich
 */
public enum Area implements Unit{
	SQUARE_METER("Square meter", 1.0),
	SQUARE_CENTIMETER("Square centimeter", 1.0e-4),
	SQUARE_KILOMETER("Square kilometer", 1.0e6),
	SQUARE_MILE("Square mile", 2.59e+6),
	SQUARE_INCH("Square inch", 6.4516e-4),
	SQUARE_FOOT("Square foot", 9.2903e-2),
	SQUARE_YARD("Square yard", 8.3613e-1),
	SQUARE_MICRON("Squate micron", 1.0e-12),
	RAI("Rai", 1600.0);
	
	public final String name;
	public final double value;
	
	/**
	 * Constructor with name and value as arguments.
	 * @param name is the name of area unit.
	 * @param value is the value of area unit.
	 */
	private Area(String name, double value) {
		this.name = name;
		this.value = value;
	}
	
	/**
	 * Return the value of area unit.
	 */
	public double getValue()  {
		return value;
	}
	
	/**
	 * Return the name of area unit.
	 */
	public String toString() {
		return name;
	}
}
