package eu.deltasource.internship.gofighters;

/**
 * A class containing methods used in calculations
 */
public class UtilityFunctions {

    /**
     * @param min The minimum limit.
     * @param max The maximum limit.
     * @return Random number in a range.
     */
    public static double getRandomNumberInRange(double min, double max) {
        return (java.lang.Math.random() * (max - min)) + min;
    }

    public static boolean calculateChance(double chance){
        double randomNumber = eu.deltasource.internship.gofighters.UtilityFunctions.
                getRandomNumberInRange(0, 1);

        return chance >= randomNumber;
    }

    public static int roundToInt(double value){
        return (int) Math.round(value);
    }
}
