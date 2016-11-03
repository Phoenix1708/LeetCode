public class Solution {
    public int firstUniqChar(String s) {
        int char_count[] = new int[26];
        int char_index[] = new int[26];
        char chars[] = s.toCharArray();
        int length = chars.length;
        for (int i = 0; i < length; i++) {
            char c = chars[i];
            char_count[c - 'a']++;
            char_index[c - 'a'] = i;
        }
        
        int min_index = -1;
        for (int j = 0; j < char_count.length; j++) {
            if (char_count[j] == 1) {
                if (min_index != -1) {
                    if (min_index > char_index[j]) {
                        min_index = char_index[j];
                    }
                } else {
                    min_index = char_index[j];
                }
            }
        }
        return min_index;
    }
}