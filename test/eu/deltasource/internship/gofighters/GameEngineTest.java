package eu.deltasource.internship.gofighters;

import eu.deltasource.internship.gofighters.dependencyinjector.DependencyInjector;
import eu.deltasource.internship.gofighters.fighters.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameEngineTest {

    Fighter gosho;
    Fighter pesho;
    GameEngine fighterState;

    /**
     * Initialize dependencies, fighters and game engine.
     */
    @BeforeEach
    public void init() {
        DependencyInjector.init(new RngCalculationsTestingImpl());
        //Given: Game with a Warrior and a SpellSword.
        fighterState = new GameEngine();

        gosho = new Warrior("gosho", 100, 10, 5);
        pesho = new SpellSword("pesho", 100, 10, 5);
    }

    @Test
    public void testIfSpellSwordWinsAgainstWarrior() {

        //When: Game is run.
        //Then: SpellSword wins.
        assertEquals(fighterState.run(gosho, pesho).getName(), "pesho",
                "Expected pesho to win, because he is a SpellSword and can defend all attacks.");
    }

    @Test
    public void testRoundCountBetweenWarriorAndSpellSwordFight() {
        
        //When: Game is run.
        fighterState.run(gosho, pesho);

        //Then: Round count is accurate.
        assertEquals(17, fighterState.getRoundCount(),
                "Expected that there are 17 rounds in this battle.");
    }
}