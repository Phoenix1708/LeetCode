import java.util.HashMap;

public class Solution {
    public int lengthOfLongestSubstring(String s) {

    	int longestLength = 0;

    	int currentLength = 0; // the length of the substring currently scaned
    	HashMap<Character, Integer> charDict = new HashMap<>(); // map to detect repeating character
    	for (int i = 0; i < s.length(); ++i) {
    		Integer previousIdx = charDict.get(s.charAt(i));

    		// if we've never seen this character OR
    		// the previous instance of this char is too far away from current instance
    		// i.e. previous instance does not belongs to current NRCS
    		// i.e. in between two instance there are repeating characters
    		if (previousIdx == null || i - currentLength > previousIdx) {
    			++currentLength;
    		} 
    		// When we can conclude the substring using current character
    		// which must be repeating character and in between it's previous instance 
    		// anc current instance there's no repeating character
    		else {
    			// update the longest substring calculated so far first
    			if (currentLength > longestLength) {
    				longestLength = currentLength;
    			}

    			// calcualte the new length in order to update the current 
    			// longest substring when we encounter the next repeating character 
    			currentLength = i - previousIdx;
    		}

    		// update the latest index of this char
    		charDict.put(s.charAt(i), i);
    	}

    	// in case the last one is the longest
    	if (currentLength > longestLength) {
			longestLength = currentLength;
		}

		return longestLength;
    }
}