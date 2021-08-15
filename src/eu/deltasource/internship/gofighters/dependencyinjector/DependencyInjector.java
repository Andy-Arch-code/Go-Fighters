package eu.deltasource.internship.gofighters.dependencyinjector;

import eu.deltasource.internship.gofighters.RngCalculations;

/**
 * Contains dependencies needed for classes and returns them.
 */
public class DependencyInjector {

    private static Dependency[] dependenciesContainer;

    public static void init(Dependency... dependencies){

        dependenciesContainer = new Dependency[dependencies.length];
        for (int i = 0; i < dependencies.length; i++) {
            dependenciesContainer[i] = dependencies[i];
        }
    }

    public static <T extends Dependency> T load(Class<T> dependencyType){

        for (int i = 0; i < dependenciesContainer.length; i++) {
            if(dependenciesContainer[i].getClass() == dependencyType){
                return (T) dependenciesContainer[i];
            }
        }
        return null;
    }
}
