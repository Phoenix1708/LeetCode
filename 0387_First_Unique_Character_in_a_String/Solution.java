public class Solution {
    public static int firstUniqChar(String s) {
        if (s.isEmpty()) {
            return -1;
        }

        int[] charCount = new int[26];

        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            charCount[c - 'a']++;
        }

        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (charCount[c - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("aadadaad"));
    }
}