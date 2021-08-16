package eu.deltasource.internship.gofighters.fighters;

import eu.deltasource.internship.gofighters.RngCalculations;
import eu.deltasource.internship.gofighters.RngCalculationsTestingImpl;
import eu.deltasource.internship.gofighters.dependencyinjector.DependencyInjector;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WarriorTest {

    /**
     * Given: Warrior with normal stats.
     * When: Warrior attacks with specific damage.
     * Then: Damage is calculated with minimum attack mod.
     */
    @Test
    public void testIfWarriorAttacksWithSpecificDamage() {
        DependencyInjector.init(new RngCalculationsTestingImpl());

        Fighter gosho = new Warrior("gosho", 100, 10, 5);

        RngCalculations rngCalculator = new RngCalculationsTestingImpl();
        int expectedAnswer = rngCalculator.roundToInt(gosho.getAttackPoints() * gosho.getMinAttackMod());

        assertEquals(expectedAnswer, gosho.attack(), "Expected attack amount to be this exact value");
    }

    /**
     * Given: Warrior with normal stats.
     * When: Warrior defends from specific damage.
     * Then: Health is lowered with a specific amount.
     */
    @Test
    public void testIfWarriorTakesSpecificDamage() {
        DependencyInjector.init(new RngCalculationsTestingImpl());

        Fighter gosho = new Warrior("gosho", 100, 10, 5);
        int damage = 10;

        RngCalculations rngCalculator = new RngCalculationsTestingImpl();
        int expectedAnswer = gosho.getHealth() - rngCalculator.roundToInt(
                damage - gosho.getArmorPoints() * gosho.getMinDefendMod());

        gosho.takeDamage(damage);

        assertEquals(expectedAnswer, gosho.getHealth(),
                "Expected Warrior to take this exact amount of damage");
    }

    /**
     * Given: Warrior with normal stats.
     * When: Warrior takes as much damage as the warrior has.
     * Then: Warrior dies.
     */
    @Test
    public void testIfWarriorIsDeadAfterAttackEqualToHealth() {
        DependencyInjector.init(new RngCalculationsTestingImpl());

        Fighter gosho = new Warrior("gosho", 100, 1000000000, 0);
        gosho.takeDamage(100 + (int)(gosho.getArmorPoints() * gosho.getMinDefendMod()));

        assertTrue(gosho.isDead(),
                "Expected Warrior to die, because he takes as much damage as he has health");
    }
}