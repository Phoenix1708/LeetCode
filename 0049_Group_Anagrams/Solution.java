public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> answer = new ArrayList<>();

        if (strs.length < 1) return answer;

        Map<String, List<String>> dict = new HashMap<>();
        for (String s : strs) {
            String key = sortChars(s);
            List<String> anagrams = dict.get(key);
            if (anagrams == null) anagrams = new ArrayList<>();
            anagrams.add(s);
            dict.put(key, anagrams);
        }
        for (Map.Entry<String, List<String>> stringListEntry : dict.entrySet()) {
            answer.add(stringListEntry.getValue());
        }
        return answer;
    }

    // O(n) counting sort
    private String sortChars(String s) {
        char[] chars = s.toCharArray();
        char[] counts = new char[26];
        for (char c : chars) {
            counts[c - 'a']++;
        }
        // put chars back in alphabetical order
        char[] sorted = new char[chars.length];
        int idx = 0;
        for (int i = 0; i < 26; ++i) {
            if (counts[i] == 0) continue;
            for (int j = 0; j < counts[i]; ++j) {
                sorted[idx++] = (char) (i + 'a');
            }
        }
        return String.valueOf(sorted);
    }
}
