package stack;

import java.util.Stack;

/**
 * Created by sergei.kostin on 3/16/18.
 */
public class BasicCalculator {

    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        char sign = '+';
        int num = 0;

        for(int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);
            if(Character.isDigit(cur)){
                num = 10*num + cur - '0';
            }
            if(cur == ' ') continue;
            if(cur == '+' || cur == '-' || cur == '*' || cur == '/' || i == s.length() - 1){
                switch (sign){
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop()/num);
                        break;
                }
                num = 0;
                sign = cur;
            }
        }
        int result = 0;
        for(int i : stack){
            result += i;
        }

        return result;
    }

    public static void main(String[] args) {

        String str = "-12+14*2/7-2*2";

        BasicCalculator bc = new BasicCalculator();
        System.out.println(bc.calculate(str));
    }

}
