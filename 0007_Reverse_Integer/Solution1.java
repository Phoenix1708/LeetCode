public class Solution {
    public int reverse(int x) {
        long result = 0;
        while (x > 0) {
        	// get last digit by using reminder
        	// divide by 10 and get reminder again to get the next one
        	// ans scale the digit to its right position -- x 10
            // result * 10 here result is actually the digit from 
            // last iteration
            result = result * 10 + x % 10;
            x /= 10;
        }
        
        return (result > Integer.MAX_VALUE || 
                result < Integer.MIN_VALUE) ? 0 : (int) result;
    }
}