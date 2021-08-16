package eu.deltasource.internship.gofighters.fighters;

import eu.deltasource.internship.gofighters.RngCalculations;
import eu.deltasource.internship.gofighters.RngCalculationsTestingImpl;
import eu.deltasource.internship.gofighters.dependencyinjector.DependencyInjector;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AssassinTest {

    @Test
    void attack() {
        DependencyInjector.init(new RngCalculationsTestingImpl());

        Fighter gosho = new Assassin("gosho", 100, 10, 5,
                DependencyInjector.load(RngCalculationsTestingImpl.class));

        RngCalculations rngCalculator = new RngCalculationsTestingImpl();
        int expectedAnswer = rngCalculator.roundToInt(
                gosho.getAttackPoints() * gosho.getMinAttackMod() * Assassin.getCritMult());

        assertEquals(expectedAnswer, gosho.attack());
    }
}