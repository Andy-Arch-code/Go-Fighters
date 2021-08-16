package eu.deltasource.internship.gofighters;

import eu.deltasource.internship.gofighters.dependencyinjector.DependencyInjector;
import eu.deltasource.internship.gofighters.fighters.*;

public class Main {

    public static void main(String[] args) {

        GameEngine fighterState = new GameEngine();
        DependencyInjector.init(new RngCalculationsRealImpl());

        //Testing game with 10 games

            Fighter gosho = new Knight("Gosho", 100, 10, 5);
            Fighter pesho = new Monk("Pesho", 100, 10, 5);

            System.out.println(fighterState.run(gosho, pesho).getName() + " is the winner!");

    }
}
