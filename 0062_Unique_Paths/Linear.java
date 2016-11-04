public class Linear {
    public int uniquePaths(int m, int n) {

        if (m == 0 || n == 0) {
            return 0;
        }

        int[] sum = new int[n];

        // initialise - starting values
        for (int i = 0; i < n; ++i) {
            sum[i] = 1;
        }
        
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                // Just add up the accumulated top and left elements
                //          Top + Left
                sum[j] = sum[j] + sum[j - 1];
            }
        }

        return sum[n-1];
    }
}