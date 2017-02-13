public class Solution {
    public static String reverseWords(String s) {

        StringBuilder answer = new StringBuilder();

        // start from the back
        int idx = s.length() - 1;
        while (idx >= 0) {
            // skip whitespaces
            while (idx >= 0 && s.charAt(idx) == ' ') idx--;

            // if no more words we stop
            if (idx < 0) break;

            // locate word start
            int wordStart = idx;
            while (wordStart >= 1 && s.charAt(wordStart - 1) != ' ') wordStart--;

            // add space if we've added some words and 
            // there are more word in the string
            if (answer.length() > 0) answer.append(' ');

            // add current word to output
            for (int i = wordStart; i <= idx; ++i) {
                answer.append(s.charAt(i));
            }

            // start from the char before this word i.e. move on
            idx = wordStart - 1;
        }

        return answer.toString();
    }

    public static void main (String[] args) {
        System.out.println(reverseWords(""));
        System.out.println(reverseWords(" "));
        System.out.println(reverseWords("1 "));
        System.out.println(reverseWords("a"));
        System.out.println(reverseWords(" 1"));
        System.out.println(reverseWords("   a   b "));
    }
}