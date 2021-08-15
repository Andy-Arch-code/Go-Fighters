package eu.deltasource.internship.gofighters.fighters;

import eu.deltasource.internship.gofighters.RngCalculations;
import eu.deltasource.internship.gofighters.dependencyinjector.DependencyInjector;

/**
 * Implementation of Fighter. Warrior has everything set to the defaults of Fighter.
 */
public class Warrior extends Fighter{

    public Warrior(String name, int health, int attackPoints, int armorPoints, RngCalculations rngCalculations){
        super(name, health, attackPoints, armorPoints, rngCalculations);
    }
}
