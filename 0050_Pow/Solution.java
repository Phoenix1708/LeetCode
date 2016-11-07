public class Solution {
    public double myPow(double x, int n) {
    	if (n == 0) return 1;
    	if (n == 1) return x;
    	if (n == -1) return 1/x;
    	if (n == 2) return x*x;

    	// divide and conquer
    	double half = myPow(x, n/2);
    	// if n is postive even
    	if (n % 2 == 0) {
    		return half * half;
    		// or myPow(half, 2)
    	} else {
    		// if n is positve odd
    		if (n > 0) {
    			return x * half * half;
    			// or x * myPow(half, 2)
    		} else {
    			return 1 / x * half * half;
    		}
    	}
    }
}
