package eu.deltasource.internship.gofighters;

import eu.deltasource.internship.gofighters.dependencyinjector.DependencyInjector;
import eu.deltasource.internship.gofighters.fighters.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameEngineTest {

    @Test
    void run() {
        GameEngine fighterState = new GameEngine();

        DependencyInjector.init(new RngCalculationsTestingImpl());

        Fighter gosho = new Warrior("gosho", 100, 10, 5,
                DependencyInjector.load(RngCalculationsTestingImpl.class));
        Fighter pesho = new SpellSword("pesho", 100, 10, 5,
                DependencyInjector.load(RngCalculationsTestingImpl.class));

        assertEquals(fighterState.run(gosho, pesho).getName(), "pesho");

    }
}