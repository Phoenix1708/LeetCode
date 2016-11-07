import java.lang.Math;

public class Solution {
    public double myPow(double x, int n) {
        long absN = Math.abs((long)n);    	
        double ans = 1;
        while (absN > 0) {
            // if the last position of n's binary form is 1
            // we mutiply x (to the answer. 
            // the answer is always mutiplication of x anyway)
            if ((absN & 1) == 1) {
                ans *= x;
            }
            // move the binary form to find out more 1s
            // (or divide by 2)
            absN >>= 1;
            // instead of keeping track of how many binary digits
            // we have moved so that when we see a "1" again we can
            // mutiply the right number of x, we just simply start mutiplying
            // x while we shifting to find the next "1".
            // And of course only count(mutiply it with ans) these 
            // mutiplications when we see a "1"
            x *= x
        }
        // Don't for get that we "abs"ed n at the beginning
        return n < 0 ? 1/ans : ans;
    }
}
