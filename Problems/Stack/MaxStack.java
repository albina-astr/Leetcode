package stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Albina Gimaletdinova on 21/05/2022
 */
public class MaxStack {
    private Deque<Integer> numStack;
    private Deque<Integer> maxStack;

    public MaxStack() {
        numStack = new ArrayDeque<>();
        maxStack = new ArrayDeque<>();
    }

    public void push(int x) {
        if (x >= peekMax()) {
            maxStack.push(x);
        }
        numStack.push(x);
    }

    public int pop() {
        if (numStack.isEmpty()) {
            throw new RuntimeException("Stack is empty!");
        }
        int removed = numStack.pop();
        if (removed == peekMax()) {
            maxStack.pop();
        }
        return removed;
    }

    public int top() {
        if (numStack.isEmpty()) {
            throw new RuntimeException("Stack is empty!");
        }
        return numStack.peek();
    }

    public int peekMax() {
        if (maxStack.isEmpty()) {
            return Integer.MIN_VALUE;
        }
        return maxStack.peek();
    }

    //0,5,1,4,3 - stack
    //5
    public int popMax() {
        if (numStack.isEmpty()) {
            throw new RuntimeException("Stack is empty!");
        }
        Deque<Integer> helper = new ArrayDeque<>();
        while (numStack.peek() != peekMax()) {
            helper.push(numStack.pop());
        }

        //deleting max element
        int removed = numStack.pop();
        maxStack.pop();

        //restore stack and find new max value
        while (!helper.isEmpty()) {
            push(helper.pop());
        }

        return removed;
    }
}
