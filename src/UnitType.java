/**
 * Enum that storing unit types of the unit converter.
 * 
 * @author Nuttapong ROjanavanich
 */
public enum UnitType {
	LENGTH("Length", Length.values()),
	AREA("Area", Area.values()),
	WEIGHT("Weight", Weight.values()),
	CURRENCY("Currency", Currency.values());


	private Unit[] units;
	private String name;
	
	/**
	 * Constructor with name and units as arguments.
	 * @param name is the name of an unit type.
	 * @param units is the units of an unit type.
	 */
	private UnitType(String name, Unit[] units) {
		this.units = units;
		this.name = name;
	}
	
	/**
	 * Return units of unit type. 
	 * @return the arrays of Unit of unit type.
	 */
	public Unit[] getUnits() {
		return units;
	}
	
	/**
	 * Return the name of an unit type.
	 */
	public String toString() {
		return "-" + name + "-";
	}
}
