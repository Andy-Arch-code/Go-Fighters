package eu.deltasource.internship.gofighters.fighters;

import eu.deltasource.internship.gofighters.RngCalculations;
import eu.deltasource.internship.gofighters.dependencyinjector.DependencyInjector;

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

    protected RngCalculations rngCalculations;

    /**
     * @param name The name of the fighter.
     * @param health The health of the fighter.
     * @param attackPoints The attack points of the fighter.
     * @param armorPoints The armor points of the fighter.
     */
    public Fighter(String name, int health, int attackPoints, int armorPoints, DependencyInjector dependencyInjector) {
        this.name = name;
        this.health = health;
        this.attackPoints = attackPoints;
        this.armorPoints = armorPoints;
        this.rngCalculations = dependencyInjector.getRngCalculations();
    }

    /**
     * Calculates the damage of the attack by multiplying the attackPoints with a random value between a range.
     *
     * @return The attack damage.
     */
    public int attack() {
        int attackDamage = rngCalculations.roundToInt(getAttackPoints() * rngCalculations.
                        getRandomNumberInRange(getMinAttackMod(), getMaxAttackMod()));
        return attackDamage;
    }

    /**
     * Calculates the damage that the fighter will take by multiplying the armorPoints with a random value
     * between a range and checks if the fighter is dead.
     *
     * @param damage The raw amount of damage that the fighter takes
     */
    public void takeDamage(int damage) {
        int damageTaken = rngCalculations.roundToInt(damage - getArmorPoints() * rngCalculations.
                        getRandomNumberInRange(getMinDefendMod(), getMaxDefendMod()));
        if (damageTaken < 0){
            damageTaken = 0;
        }

        health = getHealth() - damageTaken;
    }

    public boolean isDead() {
        if (getHealth() <= 0){
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

    public int getHealth() {
        return health;
    }

    public int getAttackPoints() {
        return attackPoints;
    }

    public int getArmorPoints() {
        return armorPoints;
    }

    public static double getMinAttackMod() {
        return MIN_ATTACK_MOD;
    }

    public static double getMaxAttackMod() {
        return MAX_ATTACK_MOD;
    }

    public static double getMinDefendMod() {
        return MIN_DEFEND_MOD;
    }

    public static double getMaxDefendMod() {
        return MAX_DEFEND_MOD;
    }
}
