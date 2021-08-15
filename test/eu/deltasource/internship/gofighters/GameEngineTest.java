package eu.deltasource.internship.gofighters;

import eu.deltasource.internship.gofighters.dependencyinjector.DependencyInjector;
import eu.deltasource.internship.gofighters.fighters.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameEngineTest {

    DependencyInjector dependencyInjector = new DependencyInjector(new RngCalculationsTestingImpl());

    @Test
    void run() {

        GameEngine fighterState = new GameEngine();

        for (int x = 0; x < 10; x++) {
            Fighter gosho = new Warrior("gosho", 100, 10, 5, dependencyInjector);
            Fighter pesho = new SpellSword("pesho", 100, 10, 5, dependencyInjector);

            assertEquals(fighterState.run(gosho, pesho).getName(), "pesho");
        }
    }
}