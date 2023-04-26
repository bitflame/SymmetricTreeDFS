import edu.princeton.cs.algs4.StdOut;

import java.util.Stack;

public class MinStack {
    Stack<Integer> s1;
    Stack<Integer> s2;

    MinStack() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int val) {
        if (s1.isEmpty() || s1.peek() > val) {
            s1.push(val);
            s2.push(val);
        } else {
            s1.push(s1.peek());
            s2.push(val);
        }
    }

    public void pop() {
        s2.pop();
        s1.pop();
    }

    int top() {
        return s2.peek();
    }

    int getMin() {
        return s1.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        StdOut.println(minStack.getMin());
        minStack.pop();
        StdOut.println(minStack.top());
        StdOut.println(minStack.getMin());
    }
}
