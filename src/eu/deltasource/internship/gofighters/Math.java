package eu.deltasource.internship.gofighters;

/**
 * A class containing methods used in calculations
 */
public class Math {

    /**
     * @param min The minimum limit.
     * @param max The maximum limit.
     * @return Random number in a range.
     */
    public static double getRandomNumberInRange(double min, double max) {
        return (java.lang.Math.random() * (max - min)) + min;
    }
}
