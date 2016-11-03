public class Solution {
    public static int firstUniqChar(String s) {
        if (s.isEmpty()) {
            return -1;
        }

        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (s.indexOf(c) == s.lastIndexOf(c)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("aadadaad"));
    }
}