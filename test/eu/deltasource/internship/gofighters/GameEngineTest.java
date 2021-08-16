package eu.deltasource.internship.gofighters;

import eu.deltasource.internship.gofighters.dependencyinjector.DependencyInjector;
import eu.deltasource.internship.gofighters.fighters.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameEngineTest {

    /**
     * Given: Game with a Warrior and a SpellSword.
     * When: Game is run.
     * Then: SpellSword wins.
     */
    @Test
    public void testIfTheGameEngineRunsTheGameProperly() {
        GameEngine fighterState = new GameEngine();

        DependencyInjector.init(new RngCalculationsTestingImpl());

        Fighter gosho = new Warrior("gosho", 100, 10, 5);
        Fighter pesho = new SpellSword("pesho", 100, 10, 5);

        assertEquals(fighterState.run(gosho, pesho).getName(), "pesho",
                "Expected pesho to win, because he is a SpellSword and can defend all attacks.");

    }
}