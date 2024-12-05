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

    @Test
    public void testIfKnightAttacksWithSpecialMultiplier() {

        //Given: Knight with normal stats.
        Fighter gosho = new Knight("gosho", 100, 10, 5);

        RngCalculations rngCalculator = new RngCalculationsTestingImpl();

        //When: Knight attacks.
        int expectedAnswer = rngCalculator.roundToInt(
                gosho.getAttackPoints() * Knight.getMinAttackMod() * Knight.getCritMult());

        //Then: Calculated attack is with its special multiplier.
        assertEquals(expectedAnswer, gosho.attack(), "Expected Knight to attack with special multiplier");
    }

    @Test
    public void testIfKnightDefendsAgainstDamage() {

        //Given: Knight with normal stats.
        Fighter gosho = new Knight("gosho", 100, 10, 5);
        int damage = 10;

        int expectedAnswer = 100;

        //When: Knight defends against damage.
        gosho.takeDamage(damage);

        //Then: Knight defends all damage.
        assertEquals(expectedAnswer, gosho.getHealth(), "Expected Knight to defend the attack fully");
    }
}