import java.util.Stack;

class MyQueue {
    // Stack only for accepting/pushing new elements to the back
    private Stack<Integer> in = new Stack<>();
    // Reverse order of "in" elements
    // Stack for popping out or peeking front elements
    private Stack<Integer> out = new Stack<>();

    private void RefillOut() {
        while(!in.empty()) {
            out.push(in.pop());
        }
    }

    // Push element x to the back of queue.
    public void push(int x) {
        in.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if (out.empty()) {
            RefillOut();
        }
        out.pop();
    }

    // Get the front element.
    public int peek() {
        if (out.empty()) {
            RefillOut();
        }
        return out.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return in.empty() && out.empty();
    }
}