package eu.deltasource.internship.gofighters.fighters;

import eu.deltasource.internship.gofighters.RngCalculations;
import eu.deltasource.internship.gofighters.RngCalculationsTestingImpl;
import eu.deltasource.internship.gofighters.dependencyinjector.DependencyInjector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SpellSwordTest {

    /**
     * Initialize dependencies.
     */
    @BeforeEach
    public void init() {
        DependencyInjector.init(new RngCalculationsTestingImpl());
    }

    @Test
    public void testIfSpellSwordAttacksWithSpecialMultiplier() {

        //Given: SpellSword with normal stats.
        Fighter gosho = new SpellSword("gosho", 100, 10, 5);

        RngCalculations rngCalculator = new RngCalculationsTestingImpl();
        //When: SpellSword attacks.
        int expectedAnswer = rngCalculator.roundToInt(
                gosho.getAttackPoints() * SpellSword.getMinAttackMod() * SpellSword.getCritMult());

        //Then: Calculated attack is with its bonus.
        assertEquals(expectedAnswer, gosho.attack(), "Expected SpellSword to attack with special multiplier");
    }


    @Test
    public void testIfSpellSwordDefendsAgainstDamage() {

        //Given: SpellSword with normal stats.
        Fighter gosho = new SpellSword("gosho", 100, 10, 5);
        int damage = 10;

        RngCalculations rngCalculator = new RngCalculationsTestingImpl();
        int expectedAnswer = 100;

        //When: SpellSword defends against damage.
        gosho.takeDamage(damage);

        //Then: SpellSword defends all damage.
        assertEquals(expectedAnswer, gosho.getHealth(), "Expected SpellSword to defend the attack fully");
    }
}