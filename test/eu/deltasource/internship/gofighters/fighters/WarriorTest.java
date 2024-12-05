package eu.deltasource.internship.gofighters.fighters;

import eu.deltasource.internship.gofighters.RngCalculations;
import eu.deltasource.internship.gofighters.RngCalculationsTestingImpl;
import eu.deltasource.internship.gofighters.dependencyinjector.DependencyInjector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WarriorTest {

    /**
     * Initialize dependencies.
     */
    @BeforeEach
    public void init() {
        DependencyInjector.init(new RngCalculationsTestingImpl());
    }

    @Test
    public void testIfWarriorAttacksWithSpecificDamage() {

        //Given: Warrior with normal stats.
        Fighter gosho = new Warrior("gosho", 100, 10, 5);

        RngCalculations rngCalculator = new RngCalculationsTestingImpl();

        // When: Warrior attacks with specific damage.
        int expectedAnswer = rngCalculator.roundToInt(gosho.getAttackPoints() * Warrior.getMinAttackMod());

        //Then: Damage is calculated with minimum attack mod.
        assertEquals(expectedAnswer, gosho.attack(), "Expected attack amount to be this exact value");
    }

    @Test
    public void testIfWarriorTakesSpecificDamage() {

        //Given: Warrior with normal stats.
        Fighter gosho = new Warrior("gosho", 100, 10, 5);
        int damage = 10;

        RngCalculations rngCalculator = new RngCalculationsTestingImpl();
        int expectedAnswer = gosho.getHealth() - rngCalculator.roundToInt(
                damage - gosho.getArmorPoints() * Warrior.getMinDefendMod());

        //When: Warrior defends from specific damage.
        gosho.takeDamage(damage);

        //Then: Health is lowered with a specific amount.
        assertEquals(expectedAnswer, gosho.getHealth(),
                "Expected Warrior to take this exact amount of damage");
    }

    @Test
    public void testIfWarriorIsDeadAfterAttackEqualToHealth() {

        //Given: Warrior with normal stats.
        Fighter gosho = new Warrior("gosho", 100, 1000000000, 0);

        //When: Warrior takes as much damage as the warrior has.
        gosho.takeDamage(100 + (int)(gosho.getArmorPoints() * Warrior.getMinDefendMod()));

        //Then: Warrior dies.
        assertTrue(gosho.isDead(),
                "Expected Warrior to die, because he takes as much damage as he has health");
    }
}