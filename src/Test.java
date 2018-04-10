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

        List<String> list = new ArrayList<>();
        list.add("zero");
        list.add("One");
        list.add("Two");
        list.add("Three");
        list.add("Four");
        list.add("Five");
        list.add("six");

        list.add(2, "inserted");
        System.out.println(list);
    }
}
