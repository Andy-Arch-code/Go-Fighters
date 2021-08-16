package eu.deltasource.internship.gofighters.fighters;

import eu.deltasource.internship.gofighters.RngCalculations;
import eu.deltasource.internship.gofighters.RngCalculationsTestingImpl;
import eu.deltasource.internship.gofighters.dependencyinjector.DependencyInjector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class KnightTest {

    /**
     * Initialize dependencies.
     */
    @BeforeEach
    public void init() {
        DependencyInjector.init(new RngCalculationsTestingImpl());
    }

    /**
     * Given: Knight with normal stats.
     * When: Knight attacks.
     * Then: Calculated attack is with its special multiplier.
     */
    @Test
    public void testIfKnightAttacksWithSpecialMultiplier() {

        Fighter gosho = new Knight("gosho", 100, 10, 5);

        RngCalculations rngCalculator = new RngCalculationsTestingImpl();
        int expectedAnswer = rngCalculator.roundToInt(
                gosho.getAttackPoints() * gosho.getMinAttackMod() * Knight.getCritMult());

        assertEquals(expectedAnswer, gosho.attack(), "Expected Knight to attack with special multiplier");
    }

    /**
     * Given: Knight with normal stats.
     * When: Knight defends against damage.
     * Then: Knight defends all damage.
     */
    @Test
    public void testIfKnightDefendsAgainstDamage() {

        Fighter gosho = new Knight("gosho", 100, 10, 5);
        int damage = 10;

        RngCalculations rngCalculator = new RngCalculationsTestingImpl();
        int expectedAnswer = 100;

        gosho.takeDamage(damage);

        assertEquals(expectedAnswer, gosho.getHealth(), "Expected Knight to defend the attack fully");
    }
}