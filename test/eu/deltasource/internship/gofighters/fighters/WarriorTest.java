package eu.deltasource.internship.gofighters.fighters;

import eu.deltasource.internship.gofighters.RngCalculations;
import eu.deltasource.internship.gofighters.RngCalculationsTestingImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WarriorTest {

    @Test
    void attack() {
        Fighter gosho = new Warrior("gosho", 100, 10, 5,
                new RngCalculationsTestingImpl());

        RngCalculations rngCalculator = new RngCalculationsTestingImpl();
        int expectedAnswer = rngCalculator.roundToInt(gosho.getAttackPoints() * gosho.getMinAttackMod());

        assertEquals(expectedAnswer, gosho.attack());
    }

    @Test
    void takeDamage() {
        Fighter gosho = new Warrior("gosho", 100, 10, 5,
                new RngCalculationsTestingImpl());
        int damage = 10;

        RngCalculations rngCalculator = new RngCalculationsTestingImpl();
        int expectedAnswer = gosho.getHealth() - rngCalculator.roundToInt(
                damage - gosho.getArmorPoints() * gosho.getMinDefendMod());

        gosho.takeDamage(damage);

        assertEquals(expectedAnswer, gosho.getHealth());
    }

    @Test
    void isDead() {
        Fighter gosho = new Warrior("gosho", 1, 1000000000, 0,
                new RngCalculationsTestingImpl());
        gosho.takeDamage(999999999);

        if (gosho.isDead()) {
            assertTrue(true);
        } else {
            assertFalse(true);
        }
    }
}