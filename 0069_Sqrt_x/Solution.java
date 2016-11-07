public class Solution {
	public int mySqrt(int x) {
		if (x <= 1) {
			return x;
		}

		int start = 0;
		int end = x;
		int mid;
		while (start != end - 1) {
			mid = (start + end) / 2;
			if (mid == x / mid) {
				return mid;
			}
			// if mid is too big
			else if (x / mid < mid) {
				end = mid;
			} else {
				start = mid;
			}
		}
		// sqrt(2) 1.414 hence 1
		return start;
	}
}
