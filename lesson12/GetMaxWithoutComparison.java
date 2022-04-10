package lesson12;

public class GetMaxWithoutComparison {

    /**
     * flip the sign the an integer (the sign bit of a 32-bit signed integer)
     * 
     * @param n must be 1 or 0
     * @return n=1->return 0, n=0->return 1
     */
    public static int flip(int n) {
        return n ^ 1;
    }

    /**
     * the sign of input n
     * 
     * @param n any integer
     * @return 1 if n is non-negative, 0 or n is negative
     */
    public static int nonNegativeOf(int n) {
        return flip((n >> 32) & 1);
    }

    /**
     * if a - b overflows, then this method will not work properly
     * @param a
     * @param b
     * @return
     */
    public static int getMax1(int a, int b) {
        int c = a - b;
        // if a-b>=0, then nonNegativeIndicatorOfC = 1; if a-b<0, then nonNegativeIndicatorOfC = 0;
        int nonNegativeIndicatorOfC = nonNegativeOf(c);
        // if nonNegativeIndicatorOfC = 1, then negativeIndicatorOfC = 0; if nonNegativeIndicatorOfC = 0, then negativeIndicatorOfC = 1;
        int negativeIndicatorOfC = flip(nonNegativeIndicatorOfC);
        // only one of (a, b) will be returned, as only one if the two indicators is 1, the other is 0
        // returning a and returning b are mutually exclusive to each other, hence using the indicator will only get one of (a,b)
        return a*nonNegativeIndicatorOfC + b*negativeIndicatorOfC;
    }

    public static int getMax2(int a, int b) {
        int c = a-b;
        int nonNegativeIndicatorOfA = nonNegativeOf(a);
        int nonNegativeIndicatorOfB = nonNegativeOf(b);
        int nonNegativeIndicatorOfC = nonNegativeOf(c);
        // a and b has diff signs -> 0, else -> 1
        int diffSignABIndicator = nonNegativeIndicatorOfA ^ nonNegativeIndicatorOfB; 
        // a and b has the same nonNegativeIndicator -> 1, else -> 0
        int sameSignABIndicator = flip(diffSignABIndicator); 
        //sameSignABIndicator and diffSignABIndicator are mutually exclusive to each other
        // return A if (a and b has the same nonNegativeIndicator, and c > 0 -> signOfC is 1) or (a and b has diff nonNegativeIndicator and a > 0 -> signOfA is 1)
        int returnAIndicator = diffSignABIndicator * nonNegativeIndicatorOfA + sameSignABIndicator * nonNegativeIndicatorOfC;
        // return B if otherwise: (a and b has the same nonNegativeIndicator, and c < 0 -> signOfC is 0) or (a and b has diff nonNegativeIndicator and a < 0 -> signOfA is 0)
        int returnBIndicator = flip(returnAIndicator);
        // returnAIndicator and returnBIndicator are mutually exclusive to each other 
        return returnAIndicator * a + returnBIndicator * b;
    }
}
