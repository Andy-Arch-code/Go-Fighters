package eu.deltasource.internship.gofighters.fighters;

public class Assassin extends Fighter{

    protected final static double CHANCE_TO_DO_CRIT = 0.3;
    protected final static double CRIT_MULT = 3;

    /**
     * Implementation of Fighter. Special property is:
     * When attacking, has a 30% chance to do 300% damage.
     */
    public Assassin(String name, int health, int attackPoints, int armorPoints){
        super(name, health, attackPoints, armorPoints);
    }

    /**
     * Calculates the damage of the attack by multiplying the attackPoints with a random value between a range.
     * Additionally, takes into account the specific properties of an Assassin:
     * - When attacking, has a 30% chance to do 300% damage.
     *
     * @return The attack damage.
     */
    @Override
    public int attack() {
        int attackDamage = (int)(attackPoints * eu.deltasource.internship.gofighters.Math.
                getRandomNumberInRange(MIN_ATTACK_MOD, MAX_ATTACK_MOD));

        double randomNumber = eu.deltasource.internship.gofighters.Math.
                getRandomNumberInRange(0, 1);

        if (CHANCE_TO_DO_CRIT >= randomNumber) {
            attackDamage *= CRIT_MULT;
        }

        return attackDamage;
    }
}
