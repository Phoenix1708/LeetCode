public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> dict = new HashSet<>(wordDict);
        int[] dp = new int[s.length() + 1];
        
        dp[0] = 1;
        for (int i = 1; i <= s.length(); ++i) {
            for (int j = 0; j < i; ++j) {
                if (dp[j] == 1 && dict.contains(s.substring(j, i))) {
                    dp[i] = 1;
                    break;
                }
            }
        }
        return dp[dp.length - 1] == 1;
    }
}
