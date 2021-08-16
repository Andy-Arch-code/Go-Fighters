package eu.deltasource.internship.gofighters.fighters;

import eu.deltasource.internship.gofighters.RngCalculations;
import eu.deltasource.internship.gofighters.RngCalculationsTestingImpl;
import eu.deltasource.internship.gofighters.dependencyinjector.DependencyInjector;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SpellSwordTest {

    /**
     * Given: SpellSword with normal stats.
     * When: SpellSword attacks.
     * Then: Calculated attack is with its bonus.
     */
    @Test
    public void testIfSpellSwordAttacksWithSpecialMultiplier() {
        DependencyInjector.init(new RngCalculationsTestingImpl());

        Fighter gosho = new SpellSword("gosho", 100, 10, 5);

        RngCalculations rngCalculator = new RngCalculationsTestingImpl();
        int expectedAnswer = rngCalculator.roundToInt(
                gosho.getAttackPoints() * gosho.getMinAttackMod() * SpellSword.getCritMult());

        assertEquals(expectedAnswer, gosho.attack(), "Expected SpellSword to attack with special multiplier");
    }

    /**
     * Given: SpellSword with normal stats.
     * When: SpellSword defends against damage.
     * Then: SpellSword defends all damage.
     */
    @Test
    public void testIfSpellSwordDefendsAgainstDamage() {
        DependencyInjector.init(new RngCalculationsTestingImpl());

        Fighter gosho = new SpellSword("gosho", 100, 10, 5);
        int damage = 10;

        RngCalculations rngCalculator = new RngCalculationsTestingImpl();
        int expectedAnswer = 100;

        gosho.takeDamage(damage);

        assertEquals(expectedAnswer, gosho.getHealth(), "Expected SpellSword to defend the attack fully");
    }
}