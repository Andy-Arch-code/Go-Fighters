package eu.deltasource.internship.gofighters;

/**
 * A class containing methods used in calculations
 */
public class RngCalculationsRealImpl implements RngCalculations {

    /**
     * @param min The minimum limit.
     * @param max The maximum limit.
     *
     * @return Random number in a range.
     */
    @Override
    public double getRandomNumberInRange(double min, double max) {
        return (Math.random() * (max - min)) + min;
    }

    /**
     * Calculates if a mathematical event will happen, depending on the chance.
     *
     * @param chance The chance in percentage in decimal => (100% = 1, 20% = 0.2).
     * @return true or false, depending on the chances.
     */
    @Override
    public boolean calculateChance(double chance){
        return chance >= getRandomNumberInRange(0, 1);
    }

    /**
     * Rounds a double to the closest int.
     *
     * @param value The value to be rounded.
     * @return The rounded value.
     */
    @Override
    public int roundToInt(double value){
        return (int) Math.round(value);
    }
}
