public class Solution {
    public int reverse(int x) {

        String myStr = String.valueOf(x);
        String newStr = "";

        int stop = (x < 0) ? 1 : 0;
        for (int i = myStr.length() - 1; i >= stop; --i) {
            newStr += myStr.charAt(i);
        }
        // add sign back in
        newStr = (x < 0) ? myStr.charAt(0) + newStr : newStr;
        int value  = 0;
        try {
            value = Integer.valueOf(newStr);
        } catch (NumberFormatException e) {
            return value;
        }
        return value;
    }
}