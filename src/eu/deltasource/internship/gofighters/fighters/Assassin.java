package eu.deltasource.internship.gofighters.fighters;

import eu.deltasource.internship.gofighters.FighterState;

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

    /**
     * Calculates the damage that the fighter will take by multiplying the armorPoints with a random value
     * between a range and checks if the fighter is dead.
     * @param damage The raw amount of damage that the fighter takes
     * @return The state of the fighter. Can be either ALIVE or DEAD.
     */
    public FighterState takeDamage(int damage) {
        int damageTaken = (int)(damage - armorPoints * eu.deltasource.internship.gofighters.Math.
                getRandomNumberInRange(MIN_DEFEND_MOD, MAX_DEFEND_MOD));

        if (damageTaken < 0){
            damageTaken = 0;
        }

        health -= damageTaken;

        if (health <= 0) {
            fighterState = FighterState.DEAD;
            return FighterState.DEAD;
        }
        return FighterState.ALIVE;
    }
}
