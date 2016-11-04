public class Solution {
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        if (m > n) return uniquePaths(n, m);
        
        m--;
        n--;
        
        // Multiplicative_formula
        double mnCm = 1;
        int sum = m + n;
        int k = m;
        for (int i = 1; i <= k; ++i) {
            mnCm = mnCm * (sum + 1 - i) / i;
        }
        return (int) mnCm;
    }
}