package eu.deltasource.internship.gofighters;

import eu.deltasource.internship.gofighters.fighters.*;

public class Main {

    public static void main(String[] args) {

        GameEngine fighterState = new GameEngine();
        //Testing game with 10 games
        for (int x = 0; x < 10; x++) {
            Fighter gosho = new Knight("gosho", 100, 10, 5, new RngCalculationsRealImpl());
            Fighter pesho = new SpellSword("pesho", 100, 10, 5, new RngCalculationsRealImpl());

            System.out.println(fighterState.run(gosho, pesho).getName() + " is the winner!");
        }
    }
}
