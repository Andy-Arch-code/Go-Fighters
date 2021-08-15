package eu.deltasource.internship.gofighters.fighters;

import eu.deltasource.internship.gofighters.RngCalculations;
import eu.deltasource.internship.gofighters.RngCalculationsTestingImpl;
import eu.deltasource.internship.gofighters.dependencyinjector.DependencyInjector;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KnightTest {

    DependencyInjector dependencyInjector = new DependencyInjector(new RngCalculationsTestingImpl());

    @Test
    void attack() {
        Fighter gosho = new Knight("gosho", 100, 10, 5, dependencyInjector);

        RngCalculations rngCalculator = new RngCalculationsTestingImpl();
        int expectedAnswer = rngCalculator.roundToInt(
                gosho.getAttackPoints() * gosho.getMinAttackMod() * Knight.getCritMult());

        assertEquals(expectedAnswer, gosho.attack());
    }

    @Test
    void takeDamage() {
        Fighter gosho = new Knight("gosho", 100, 10, 5, dependencyInjector);
        int damage = 10;

        RngCalculations rngCalculator = new RngCalculationsTestingImpl();
        int expectedAnswer = 100;

        gosho.takeDamage(damage);

        assertEquals(expectedAnswer, gosho.getHealth());
    }
}