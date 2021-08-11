package eu.deltasource.internship.gofighters.fighters;

/**
 * Implementation of Fighter. Special properties are:
 * When defending, has a 15% chance to completely block the attack and receive no damage.
 * When attacking, has a 20% chance to do 200% damage.
 */
public class SpellSword extends Fighter{

    protected final static double CHANCE_TO_BLOCK = 0.15;
    protected final static double CHANCE_TO_DO_CRIT = 0.2;
    protected final static double CRIT_MULT = 2;


    public SpellSword(String name,int health, int attackPoints, int armorPoints){
        super(name, health, attackPoints, armorPoints);
    }

    /**
     * Calculates the damage of the attack by multiplying the attackPoints with a random value between a range.
     * Additionally, takes into account the specific properties of a SpellSword:
     * - When attacking, has a 20% chance to do 200% damage.
     *
     * @return The attack damage.
     */
    @Override
    public int attack() {
        int attackDamage = eu.deltasource.internship.gofighters.UtilityFunctions.roundToInt(
                attackPoints * eu.deltasource.internship.gofighters.UtilityFunctions.
                        getRandomNumberInRange(MIN_ATTACK_MOD, MAX_ATTACK_MOD));

        if (eu.deltasource.internship.gofighters.UtilityFunctions.calculateChance(CHANCE_TO_DO_CRIT)) {
            attackDamage *= CRIT_MULT;
        }

        return attackDamage;
    }

    /**
     * Calculates the damage that the fighter will take by multiplying the armorPoints with a random value
     * between a range and checks if the fighter is dead.
     * Additionally, takes into account the specific properties of a SpellSword:
     * - When defending, has a 15% chance to completely block the attack and receive no damage.
     * @param damage The raw amount of damage that the fighter takes
     * @return The state of the fighter. Can be either ALIVE or DEAD.
     */
    @Override
    public void takeDamage(int damage) {
        int damageTaken = eu.deltasource.internship.gofighters.UtilityFunctions.roundToInt(
                damage - armorPoints * eu.deltasource.internship.gofighters.UtilityFunctions.
                        getRandomNumberInRange(MIN_DEFEND_MOD, MAX_DEFEND_MOD));

        if (damageTaken < 0 || eu.deltasource.internship.gofighters.UtilityFunctions.calculateChance(CHANCE_TO_BLOCK)){
            damageTaken = 0;
        }

        health -= damageTaken;
    }
}
