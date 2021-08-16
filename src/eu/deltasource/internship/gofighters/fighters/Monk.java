package eu.deltasource.internship.gofighters.fighters;

import eu.deltasource.internship.gofighters.RngCalculations;
import eu.deltasource.internship.gofighters.RngCalculationsRealImpl;
import eu.deltasource.internship.gofighters.dependencyinjector.DependencyInjector;

/**
 * Implementation of Fighter. Special property is:
 * When attacking, has a 30% chance to do 300% damage.
 */
public class Monk extends Fighter{

    protected final static double CHANCE_TO_BLOCK = 0.3;


    public Monk(String name, int health, int attackPoints, int armorPoints, RngCalculations rngCalculations){
        super(name, health, attackPoints, armorPoints, rngCalculations);
    }

    /**
     * Calculates the damage that the fighter will take by multiplying the armorPoints with a random value
     * between a range and checks if the fighter is dead.
     * Additionally, takes into account the specific properties of a Monk:
     * - When defending, has a 30% chance to completely block the attack and receive no damage.
     *
     * @param damage The raw amount of damage that the fighter takes
     *
     * @return The state of the fighter. Can be either ALIVE or DEAD.
     */
    @Override
    public void takeDamage(int damage) {
        int damageTaken = rngCalculations.roundToInt(damage - getArmorPoints() * rngCalculations.
                                                        getRandomNumberInRange(getMinDefendMod(), getMaxDefendMod()));

        if (damageTaken < 0 || rngCalculations.calculateChance(CHANCE_TO_BLOCK)){
            damageTaken = 0;
        }

        health = getHealth() - damageTaken;
    }
}
