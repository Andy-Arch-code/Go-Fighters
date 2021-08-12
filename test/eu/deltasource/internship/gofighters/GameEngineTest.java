package eu.deltasource.internship.gofighters;

import eu.deltasource.internship.gofighters.fighters.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameEngineTest {

    @Test
    void run() {

        GameEngine fighterState = new GameEngine();

        for (int x = 0; x < 10; x++) {
            Fighter gosho = new Warrior("gosho", 100, 10, 5, new RngCalculationsTestingImpl());
            Fighter pesho = new SpellSword("pesho", 100, 10, 5, new RngCalculationsTestingImpl());

            assertEquals(fighterState.run(gosho, pesho).getName(), "pesho");
        }
    }
}