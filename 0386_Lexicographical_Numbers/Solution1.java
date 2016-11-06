import java.util.List;
import java.util.ArrayList;

public class Solution {
    public List<Integer> lexicalOrder(int n) {
        ArrayList<Integer> answer = new ArrayList<>();
        // roots
        for (int i = 1; i < 10 && i <=n; ++i) {
        	dfs(i, n, answer);
        }
        return answer;
    }

    void dfs(int root, int n, List<Integer> results) {
    	// visit current node
		results.add(root);
		// visit all child nodes
		// only 0 - 9 anyway
		int nextLevelRoot = 10 * root;
		for (int i = nextLevelRoot; i <= n && i < nextLevelRoot + 10; ++i) {
			dfs(i, n, results);
		}
    }
}
