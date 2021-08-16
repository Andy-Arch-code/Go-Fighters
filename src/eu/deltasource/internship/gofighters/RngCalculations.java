package eu.deltasource.internship.gofighters;

import eu.deltasource.internship.gofighters.dependencyinjector.Dependency;

/**
 * A class containing methods used in calculations
 */
public interface RngCalculations extends Dependency {
    /**
     * @param min The minimum limit.
     * @param max The maximum limit.
     *
     * @return Random number in a range.
     */
    public double getRandomNumberInRange(double min, double max);

    /**
     * Calculates if a mathematical event will happen, depending on the chance.
     *
     * @param chance The chance in percentage in decimal => (100% = 1, 20% = 0.2).
     * @return true or false, depending on the chances.
     */
    public boolean calculateChance(double chance);

    /**
     * Rounds a double to the closest int.
     *
     * @param value The value to be rounded.
     * @return The rounded value.
     */
    public int roundToInt(double value);
}
