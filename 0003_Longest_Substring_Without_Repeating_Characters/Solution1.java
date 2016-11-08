import java.util.HashMap;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int max=0;
        // left and right boundary of longest substring
        for (int right = 0, left = 0; right < s.length(); ++right){
            char c = s.charAt(left);
            if (map.containsKey(c)) {
                // The previous instance of this char - map.get(c)+1 - has to be
                // within the current longest substring i.e. greater than current left
                // boundary (map.get(c)+1 > left) to be used as new left boundary, otherwise
                // (map.get(c)+1 < left) we just use the current longest substring start i.e. left
                left = Math.max(left, map.get(c)+1);
            }
            map.put(c, right);
            // Update the global max
            max = Math.max(max, right-left+1);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("abcabcbb"));
    }
}
