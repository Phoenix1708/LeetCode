import java.util.HashMap;
import java.util.Arrays;

public class Solution {
    public static int[] twoSum(int[] nums, int target) {
    	HashMap<Integer, Integer> numsMap = new HashMap<Integer, Integer>();
    	int[] answer = new int[2];
    	int answerIdx = 0;

    	for (int i = 0; i < nums.length; ++i){
    		int currentNum = nums[i];
    		int theOtherNum = target - currentNum;
    		Integer theOtherNumIndex = numsMap.get(theOtherNum);
    		if (theOtherNumIndex == null) {
    			numsMap.put(currentNum, i);
    		} else {
    			answer[answerIdx] = theOtherNumIndex.intValue();
    			answer[++answerIdx] = i;
    		}
    	}

    	return answer;
    }

    public static void main(String[] args) {
    	int [] nums = new int[] {2, 7, 11, 15};
    	int[] answer = twoSum(nums, 9);
    	System.out.println(Arrays.toString(answer));
    }
}