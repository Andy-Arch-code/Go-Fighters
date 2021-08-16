package eu.deltasource.internship.gofighters.fighters;

import eu.deltasource.internship.gofighters.RngCalculations;
import eu.deltasource.internship.gofighters.RngCalculationsTestingImpl;
import eu.deltasource.internship.gofighters.dependencyinjector.DependencyInjector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MonkTest {

    /**
     * Initialize dependencies.
     */
    @BeforeEach
    public void init() {
        DependencyInjector.init(new RngCalculationsTestingImpl());
    }

    @Test
    public void testIfMonkDefendsAgainstDamage() {

        //Given: Monk with normal stats.
        Fighter gosho = new Monk("gosho", 100, 10, 5);
        int damage = 10;

        RngCalculations rngCalculator = new RngCalculationsTestingImpl();
        int expectedAnswer = 100;

        //When: Monk defends against damage.
        gosho.takeDamage(damage);

        //Then: Monk defends all damage.
        assertEquals(expectedAnswer, gosho.getHealth(), "Expected Monk to defend the attack fully");
    }
}