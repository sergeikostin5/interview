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

        String h = "hello";

        char[] arr = new char[h.length()];
        arr[0] = 'h';
        arr[1] = 'e';
        arr[2] = 'l';
        arr[3] = 'l';
        arr[4] = 'o';

        String s = new String(arr);
        AtomicInteger at = new AtomicInteger();
        System.out.println(at.get() == 0);

    }





}
