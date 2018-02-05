package lists;

import java.util.Stack;

/**
 * Created by sergei.kostin on 1/11/18.
 */
class MinStack {

    /** initialize your data structure here. */

    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
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
        if(elem.equals(minStack.peek())) minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }


    public static void main(String[] args) {
        MinStack st = new MinStack();
        st.push(512);
        st.push(-1024);
        st.push(-1024);
        st.push(512);
        st.pop();
        st.pop();
        st.pop();
        System.out.println(st.getMin());

        Integer d = 5;
        System.out.println(d <= 4);

    }

}
