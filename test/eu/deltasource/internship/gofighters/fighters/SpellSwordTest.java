package eu.deltasource.internship.gofighters.fighters;

import eu.deltasource.internship.gofighters.RngCalculations;
import eu.deltasource.internship.gofighters.RngCalculationsTestingImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpellSwordTest {

    @Test
    void attack() {
        Fighter gosho = new SpellSword("gosho", 100, 10, 5,
                new RngCalculationsTestingImpl());

        RngCalculations rngCalculator = new RngCalculationsTestingImpl();
        int expectedAnswer = rngCalculator.roundToInt(
                gosho.getAttackPoints() * gosho.getMinAttackMod() * SpellSword.getCritMult());

        assertEquals(expectedAnswer, gosho.attack());
    }

    @Test
    void takeDamage() {
        Fighter gosho = new SpellSword("gosho", 100, 10, 5,
                new RngCalculationsTestingImpl());
        int damage = 10;

        RngCalculations rngCalculator = new RngCalculationsTestingImpl();
        int expectedAnswer = 100;

        gosho.takeDamage(damage);

        assertEquals(expectedAnswer, gosho.getHealth());
    }
}