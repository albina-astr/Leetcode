package stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.EmptyStackException;

/**
 * @author Albina Gimaletdinova on 21/05/2022
 */
public class MinStack {
    private Deque<Integer> minStack;
    private Deque<Integer> stack;
    private int min = Integer.MAX_VALUE;

    public MinStack() {
        minStack = new ArrayDeque<>();
        stack = new ArrayDeque<>();
    }

    public void push(int val) {
        if (stack.isEmpty() || val < min) {
            min = val;
            minStack.offer(min);
        }
        stack.offer(val);
    }

    public void pop() {
        if (!stack.isEmpty()) {
            int val = stack.removeLast();
            if (val == min) {
                minStack.removeLast();
                if (minStack.isEmpty()) {
                    min = minStack.getLast();
                } else {
                    min = Integer.MAX_VALUE;
                }
            }
        }
    }

    public int top() {
        if (stack.isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.getLast();
    }

    public int getMin() {
        if (stack.isEmpty()) {
            throw new EmptyStackException();
        }
        return min;
    }
}
