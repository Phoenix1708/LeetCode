public class Solution1 {
    private int startIdx;
    private int maxLength;
    
    public String longestPalindrome(String s) {
        int length = s.length();
        if (length < 2) return s;
        
        for (int i = 0; i < length; ++i) {
            findLongestPalindrome(i, i, s); // max palindrome is among odd length abcba
            findLongestPalindrome(i, i + 1, s); // max palindrome is among those even length ones abccba
        }
        return s.substring(startIdx, startIdx + maxLength);
    }
    
    private void findLongestPalindrome(int left, int right, String s) {
        int length = s.length();
        while (left >= 0 && right < length && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        
        int currentLength = right - left - 1; // left, right are index
        if (currentLength > this.maxLength) {
            this.maxLength = currentLength;
            this.startIdx = left + 1; // left will be -1 when breaking out of the loop
        }
    }
}
