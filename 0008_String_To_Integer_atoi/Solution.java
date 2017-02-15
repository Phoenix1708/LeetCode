public class Solution {
    public int myAtoi(String str) {
        
        int sign = 1, ans = 0, idx = 0;
        
        // remove space
        str = str.trim();
        if (str.length() < 1) return 0;
        
        char[] chars = str.toCharArray();
        // set sign
        if (chars[0] == '-' || chars[0] == '+') {
            if (chars[0] == '-') sign = -1;
            idx++;
        }
        
        int bound = Integer.MAX_VALUE / 10;
        while (idx < chars.length && chars[idx] >= '0' && chars[idx] <= '9') {
            int digit = chars[idx] - '0';
            // check overflow
            if (ans > bound || (ans == bound && digit > 7))
                return (sign == -1) ? Integer.MIN_VALUE : Integer.MAX_VALUE;

            ans = ans * 10 + digit;
            idx++;
        }

        return sign * ans;
    }
}
