/**
 * Class that used for retrieving the values of units and unit types using factory design pattern.
 * Singleton class.
 * 
 * @author Nuttapong Rojanavanich
 */
public class UnitFactory {

	private static UnitFactory instance = new UnitFactory(); 
	
	/**
	 * Constructor that can't be accessed from other class.
	 */
	private UnitFactory(){}
	
	/**
	 * return the only instance of this class
	 * @return instance is a static instance of this class.
	 */
	public static UnitFactory getInstance() {
		return instance;
	}
	
	/**
	 * Return all of the unit types available.
	 * @return the array of unit types.
	 */
	public UnitType[] getUnitTypes() {
		return UnitType.values();
	}

	/**
	 * Return all of the units available.
	 * @param unitType is the unit type of units are going to be returned.
	 * @return the array of units.
	 */
	public Unit[] getUnits(UnitType unitType) {
		return unitType.getUnits();
	}
}
