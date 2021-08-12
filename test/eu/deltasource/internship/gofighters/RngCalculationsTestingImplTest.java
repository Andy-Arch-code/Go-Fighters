package eu.deltasource.internship.gofighters;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RngCalculationsTestingImplTest {

    @Test
    void getRandomNumberInRange() {
        RngCalculations rngCalculations = new RngCalculationsTestingImpl();
        assertEquals(0.2, rngCalculations.getRandomNumberInRange(0.2, 0.5));
    }

    @Test
    void calculateChance() {
        RngCalculations rngCalculations = new RngCalculationsTestingImpl();
        assertEquals(true, rngCalculations.calculateChance(0));
    }

    @Test
    void roundToInt() {
        RngCalculations rngCalculations = new RngCalculationsTestingImpl();
        assertEquals(3, rngCalculations.roundToInt(2.7));
    }
}