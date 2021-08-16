package eu.deltasource.internship.gofighters.dependencyinjector;

import eu.deltasource.internship.gofighters.RngCalculations;

/**
 * Contains dependencies needed for classes and returns them.
 */
public class DependencyInjector {

    private static Dependency[] dependenciesContainer;

    /**
     * Loads all dependencies into the Injector.
     * @param dependencies
     */
    public static void init(Dependency... dependencies){

        dependenciesContainer = new Dependency[dependencies.length];
        for (int i = 0; i < dependencies.length; i++) {
            dependenciesContainer[i] = dependencies[i];
        }
    }

    /**
     * @return The RngCalculations dependency if the dependency is stored in the Injector. If not then it returns null.
     */
    public static RngCalculations loadRngCalculations(){

        for (int i = 0; i < dependenciesContainer.length; i++) {
            if(dependenciesContainer[i] instanceof RngCalculations){
                return (RngCalculations) dependenciesContainer[i];
            }
        }
        return null;
    }
}
