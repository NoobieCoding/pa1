/**
 * Convert the input unit into  a new unit.
 * Unit that now can be used with this class is length unit.
 * 
 * @author Nuttapong Rojanavanich
 */
public class UnitConverter {
	
	private static UnitFactory unitFactory = UnitFactory.getInstance();
	
	/**
	 * Convert the unit of the input amount.
	 * @param amount is initial amount that is going to be converted.
	 * @param fromUnit is the current unit.
	 * @param toUnit is the unit that we are going to convert to.
	 * @return the converted amount (new Unit).
	 */
	public double convert(double amount, Unit fromUnit, Unit toUnit) {
		double returnValue = amount * fromUnit.getValue();
		return returnValue / toUnit.getValue();
	}
	
	/**
	 * Return all of the unit types available.
	 * Retrieve the value from UnitFactory.
	 * @return the array of unit types.
	 */
	public UnitType[] getUnitTypes() {
		return unitFactory.getUnitTypes();
	}
	
	/**
	 * Return all of the units available.
	 * Retrieve the value from UnitFactory.
	 * @param unitType is the unit type of units are going to be returned.
	 * @return the array of units.
	 */
	public Unit[] getUnits(UnitType unitType) {
		return unitFactory.getUnits(unitType);
	}
}
