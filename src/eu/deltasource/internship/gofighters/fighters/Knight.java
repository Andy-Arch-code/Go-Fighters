package eu.deltasource.internship.gofighters.fighters;

import eu.deltasource.internship.gofighters.RngCalculations;
import eu.deltasource.internship.gofighters.dependencyinjector.DependencyInjector;

/**
 * Implementation of Fighter. Special properties are:
 * When defending, has a 20% chance to completely block the attack and receive no damage.
 * When attacking, has a 10% chance to do 200% damage.
 */
public class Knight extends Fighter{

    protected final static double CHANCE_TO_BLOCK = 0.2;
    protected final static double CHANCE_TO_DO_CRIT = 0.1;
    protected final static double CRIT_MULT = 2;


    public Knight(String name, int health, int attackPoints, int armorPoints){
        super(name, health, attackPoints, armorPoints);
    }

    public static double getCritMult() {
        return CRIT_MULT;
    }

    /**
     * Calculates the damage of the attack by multiplying the attackPoints with a random value between a range.
     * Additionally, takes into account the specific properties of a Knight:
     * - When attacking, has a 10% chance to do 200% damage.
     *
     * @return The attack damage.
     */
    public int attack() {
        int attackDamage = rngCalculations.roundToInt(getAttackPoints() * rngCalculations.
                        getRandomNumberInRange(getMinAttackMod(), getMaxAttackMod()));;

        if (rngCalculations.calculateChance(CHANCE_TO_DO_CRIT)) {
            attackDamage *= getCritMult();
        }

        return attackDamage;
    }

    /**
     * Calculates the damage that the fighter will take by multiplying the armorPoints with a random value
     * between a range and checks if the fighter is dead.
     * Additionally, takes into account the specific properties of a Knight:
     * - When defending, has a 20% chance to completely block the attack and receive no damage.
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
