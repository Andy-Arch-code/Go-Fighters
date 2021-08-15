package eu.deltasource.internship.gofighters.dependencyinjector;

import eu.deltasource.internship.gofighters.RngCalculations;

/**
 * Contains dependencies needed for classes and returns them.
 */
public class DependencyInjector {

    private RngCalculations rngCalculations;

    /**
     * The constructor accepts implementations of the dependencies.
     * @param rngCalculations The RngCalculations utility dependency.
     */
    public DependencyInjector(RngCalculations rngCalculations){
        this.rngCalculations = rngCalculations;
    }

    /**
     * @return The RngCalculations utility dependency.
     */
    public RngCalculations getRngCalculations() {
        return rngCalculations;
    }
}
