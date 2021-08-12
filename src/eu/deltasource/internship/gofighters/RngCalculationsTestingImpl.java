package eu.deltasource.internship.gofighters;

/**
 * A mockup class, same as the real implementation, but instead of Random, the calculations use 0.01
 */
public class RngCalculationsTestingImpl implements RngCalculations{

    /**
     * @param min The minimum limit.
     * @param max The maximum limit.
     *
     * @return In this mockup implementation the method always returns the minimum value.
     */
    public double getRandomNumberInRange(double min, double max) {
        return (0 * (max - min)) + min;
    }

    /**
     * Calculates if a mathematical event will happen, depending on the chance.
     * In this mockup class if the chance is equal, or over 0%, it returns true;
     *
     * @param chance The chance in percentage in decimal => (100% = 1, 20% = 0.2).
     * @return true or false, depending on the chances.
     */
    public boolean calculateChance(double chance){
        return chance >= getRandomNumberInRange(0, 1);
    }

    /**
     * Rounds a double to the closest int.
     *
     * @param value The value to be rounded.
     * @return The rounded value.
     */
    public int roundToInt(double value){
        return (int) Math.round(value);
    }
}
