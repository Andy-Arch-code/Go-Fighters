package eu.deltasource.internship.gofighters.fighters;

import eu.deltasource.internship.gofighters.RngCalculations;
import eu.deltasource.internship.gofighters.RngCalculationsTestingImpl;
import eu.deltasource.internship.gofighters.dependencyinjector.DependencyInjector;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpellSwordTest {

    @Test
    void attack() {
        DependencyInjector.init(new RngCalculationsTestingImpl());

        Fighter gosho = new SpellSword("gosho", 100, 10, 5,
                DependencyInjector.load(RngCalculationsTestingImpl.class));

        RngCalculations rngCalculator = new RngCalculationsTestingImpl();
        int expectedAnswer = rngCalculator.roundToInt(
                gosho.getAttackPoints() * gosho.getMinAttackMod() * SpellSword.getCritMult());

        assertEquals(expectedAnswer, gosho.attack());
    }

    @Test
    void takeDamage() {
        DependencyInjector.init(new RngCalculationsTestingImpl());

        Fighter gosho = new SpellSword("gosho", 100, 10, 5,
                DependencyInjector.load(RngCalculationsTestingImpl.class));
        int damage = 10;

        RngCalculations rngCalculator = new RngCalculationsTestingImpl();
        int expectedAnswer = 100;

        gosho.takeDamage(damage);

        assertEquals(expectedAnswer, gosho.getHealth());
    }
}