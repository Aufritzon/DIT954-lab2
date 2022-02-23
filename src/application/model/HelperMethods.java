package application.model;

/**
 * Contains the helpermethod valueWithinBounds
 */

public abstract class HelperMethods {

    /**
     * Checks whether a given value is within a given interval. Returns the upper bound if value exceeds the upper bound,
     * returs lower bound if value is less thn the lower bound, otherwise returns the vale.
     * @param value
     * @param lowerBound
     * @param upperBound
     * @return
     */
    public static double valueWithinBounds (double value, double lowerBound, double upperBound) {
        return value > upperBound ? upperBound : Math.max(value, lowerBound);
    }
}
