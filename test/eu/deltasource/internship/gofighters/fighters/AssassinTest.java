package eu.deltasource.internship.gofighters.fighters;

import eu.deltasource.internship.gofighters.RngCalculations;
import eu.deltasource.internship.gofighters.RngCalculationsTestingImpl;
import eu.deltasource.internship.gofighters.dependencyinjector.DependencyInjector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AssassinTest {

    /**
     * Initialize dependencies.
     */
    @BeforeEach
    public void init() {
        DependencyInjector.init(new RngCalculationsTestingImpl());
    }

    /**
     * Given: Assassin with normal stats.
     * When: Assassin attacks.
     * Then: Calculated attack is with its special multiplier.
     */
    @Test
    public void testIfAssassinAttacksWithSpecialMultiplier() {

        Fighter gosho = new Assassin("gosho", 100, 10, 5);

        RngCalculations rngCalculator = new RngCalculationsTestingImpl();
        int expectedAnswer = rngCalculator.roundToInt(
                gosho.getAttackPoints() * gosho.getMinAttackMod() * Assassin.getCritMult());

        assertEquals(expectedAnswer, gosho.attack(), "Expected Assassin to attack with special multiplier");
    }
}