import java.util.EmptyStackException;
import java.util.Stack;

public class MinStack {
    private Stack<Integer> stack;
    private int min = Integer.MAX_VALUE;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
        if (x < min) {
            // also push the current min under new
            // min in order to update min after pop
            if (!stack.empty()){
                stack.push(min);
            }
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        if (min == stack.pop()) {
            min = stack.empty() ? Integer.MAX_VALUE : stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        if (stack.empty()) {
            throw new EmptyStackException();
        }
        return min;
    }
}
