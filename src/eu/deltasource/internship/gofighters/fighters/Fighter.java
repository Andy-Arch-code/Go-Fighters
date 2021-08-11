package eu.deltasource.internship.gofighters.fighters;

import java.lang.Double;

/**
 * To be extended by other classes. This class contains only the bare minimum features.
 * To augment how the Fighter acts, the attack and takeDamage methods need to be overridden.
 */
public abstract class Fighter {

    protected final static double MIN_ATTACK_MOD = 0.8;
    protected final static double MAX_ATTACK_MOD = 1.2;

    protected final static double MIN_DEFEND_MOD = 0.8;
    protected final static double MAX_DEFEND_MOD = 1.2;

    protected String name;

    protected int health;
    protected int attackPoints;
    protected int armorPoints;

    /**
     * @param name The name of the fighter.
     * @param health The health of the fighter.
     * @param attackPoints The attack points of the fighter.
     * @param armorPoints The armor points of the fighter.
     */
    public Fighter(String name, int health, int attackPoints, int armorPoints) {
        this.name = name;
        this.health = health;
        this.attackPoints = attackPoints;
        this.armorPoints = armorPoints;
    }

    /**
     * Calculates the damage of the attack by multiplying the attackPoints with a random value between a range.
     * @return The attack damage.
     */
    public int attack() {
        int attackDamage = eu.deltasource.internship.gofighters.UtilityFunctions.roundToInt(
                attackPoints * eu.deltasource.internship.gofighters.UtilityFunctions.
                        getRandomNumberInRange(MIN_ATTACK_MOD, MAX_ATTACK_MOD));
        return attackDamage;
    }

    /**
     * Calculates the damage that the fighter will take by multiplying the armorPoints with a random value
     * between a range and checks if the fighter is dead.
     * @param damage The raw amount of damage that the fighter takes
     * @return The state of the fighter. Can be either ALIVE or DEAD.
     */
    public void takeDamage(int damage) {
        int damageTaken = eu.deltasource.internship.gofighters.UtilityFunctions.roundToInt(
                damage - armorPoints * eu.deltasource.internship.gofighters.UtilityFunctions.
                        getRandomNumberInRange(MIN_DEFEND_MOD, MAX_DEFEND_MOD));
        if (damageTaken < 0){
            damageTaken = 0;
        }

        health -= damageTaken;
    }

    public boolean isDead() {
        if (health <= 0){
            return true;
        }
        return false;
    }

    /**
     * @return The name of the fighter.
     */
    public String getName() {
        return name;
    }
}
