package stack;

import java.util.Stack;

/**
 * Created by sergei.kostin on 4/4/18.
 */
public class MinStack_155 {

    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack_155() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if(minStack.isEmpty() || x <= minStack.peek()){
            minStack.push(x);
        }
    }

    public void pop() {
        Integer elem = stack.pop();
        if(elem <= minStack.peek()) minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

}
