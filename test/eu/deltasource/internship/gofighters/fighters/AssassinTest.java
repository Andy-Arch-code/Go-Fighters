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

    @Test
    public void testIfAssassinAttacksWithSpecialMultiplier() {

        //Given: Assassin with normal stats.
        Fighter gosho = new Assassin("gosho", 100, 10, 5);

        RngCalculations rngCalculator = new RngCalculationsTestingImpl();

        //When: Assassin attacks.
        int expectedAnswer = rngCalculator.roundToInt(
                gosho.getAttackPoints() * Fighter.getMinAttackMod() * Assassin.getCritMult());

        //Then: Calculated attack is with its special multiplier.
        assertEquals(expectedAnswer, gosho.attack(), "Expected Assassin to attack with special multiplier");
    }
}