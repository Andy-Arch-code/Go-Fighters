package eu.deltasource.internship.gofighters.fighters;

import eu.deltasource.internship.gofighters.RngCalculations;
import eu.deltasource.internship.gofighters.RngCalculationsTestingImpl;
import eu.deltasource.internship.gofighters.dependencyinjector.DependencyInjector;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WarriorTest {

    DependencyInjector dependencyInjector = new DependencyInjector(new RngCalculationsTestingImpl());

    @Test
    void attack() {
        Fighter gosho = new Warrior("gosho", 100, 10, 5, dependencyInjector);

        RngCalculations rngCalculator = new RngCalculationsTestingImpl();
        int expectedAnswer = rngCalculator.roundToInt(gosho.getAttackPoints() * gosho.getMinAttackMod());

        assertEquals(expectedAnswer, gosho.attack());
    }

    @Test
    void takeDamage() {
        Fighter gosho = new Warrior("gosho", 100, 10, 5, dependencyInjector);
        int damage = 10;

        RngCalculations rngCalculator = new RngCalculationsTestingImpl();
        int expectedAnswer = gosho.getHealth() - rngCalculator.roundToInt(
                damage - gosho.getArmorPoints() * gosho.getMinDefendMod());

        gosho.takeDamage(damage);

        assertEquals(expectedAnswer, gosho.getHealth());
    }

    @Test
    void isDead() {
        Fighter gosho = new Warrior("gosho", 1, 1000000000, 0, dependencyInjector);
        gosho.takeDamage(999999999);

        if (gosho.isDead()) {
            assertTrue(true);
        } else {
            assertFalse(true);
        }
    }
}