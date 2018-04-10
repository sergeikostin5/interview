import lists.LinkedListImpl;

import java.io.InputStream;
import java.io.Reader;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by sergei.kostin on 11/5/17.
 */
public class Test {

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.add("four");
        stack.add("three");
        stack.add("two");
        LinkedList<String> list = new LinkedList<>();
        while(!stack.isEmpty()){
            list.add(stack.pop());
        }

        System.out.println(list);
    }
}
