public class Solution2 {
        
    public String longestPalindrome(String s) {
        int maxPaliStart = 0;
        int maxLength = 0;

        int strLength = s.length();
        for (int i = 0; i < strLength; ++i) {
            if (isPalindrome(i - maxLength, i, s)) {
                maxPaliStart = i - maxLength;
                // Set max Length to the "new" max length
                // be careful this length now includes "i" so when we trying to find
                // the new palindrome start we have to use the old length i.e. start
                // from i and go back "old max length" position;
                maxLength = maxLength + 1;
            }
            else if (isPalindrome(i - maxLength - 1, i, s)) {
                maxPaliStart = i - maxLength - 1;
                maxLength = maxLength + 2;
            }
        }

        return s.substring(maxPaliStart, maxPaliStart + maxLength);
    }

    private boolean isPalindrome(int start, int end, String s) {
        if (start < 0) return false;

        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }
}
