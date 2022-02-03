public abstract class HelperMethods {
    public static double valueWithinBounds (double value, double lowerBound, double upperBound) {
        return value > upperBound ? upperBound : Math.max(value, lowerBound);
    }
}
