package eu.deltasource.internship.gofighters.fighters;

import eu.deltasource.internship.gofighters.RngCalculations;
import eu.deltasource.internship.gofighters.RngCalculationsTestingImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AssassinTest {

    @Test
    void attack() {
        Fighter gosho = new Assassin("gosho", 100, 10, 5,
                new RngCalculationsTestingImpl());

        RngCalculations rngCalculator = new RngCalculationsTestingImpl();
        int expectedAnswer = rngCalculator.roundToInt(
                gosho.getAttackPoints() * gosho.getMinAttackMod() * Assassin.getCritMult());

        assertEquals(expectedAnswer, gosho.attack());
    }
}