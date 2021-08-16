package eu.deltasource.internship.gofighters.fighters;

import eu.deltasource.internship.gofighters.RngCalculations;
import eu.deltasource.internship.gofighters.RngCalculationsTestingImpl;
import eu.deltasource.internship.gofighters.dependencyinjector.DependencyInjector;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MonkTest {

    /**
     * Given: Monk with normal stats.
     * When: Monk defends against damage.
     * Then: Monk defends all damage.
     */
    @Test
    public void testIfMonkDefendsAgainstDamage() {
        DependencyInjector.init(new RngCalculationsTestingImpl());

        Fighter gosho = new Monk("gosho", 100, 10, 5);
        int damage = 10;

        RngCalculations rngCalculator = new RngCalculationsTestingImpl();
        int expectedAnswer = 100;

        gosho.takeDamage(damage);

        assertEquals(expectedAnswer, gosho.getHealth(), "Expected Monk to defend the attack fully");
    }
}