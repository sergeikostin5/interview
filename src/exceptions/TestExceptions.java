package exceptions;

import java.io.FileInputStream;

/**
 * Created by sergei.kostin on 2/27/18.
 */
public class TestExceptions {

    public static void main(String[] args) throws Exception {
        TestExceptions te = new TestExceptions();
        System.out.println(te.hello(-1, 3));
    }

    public int hello(Integer i, Integer j) throws Exception {
        if(i == null) throw new IndexOutOfBoundsException();
        if(i < 0) throw new IllegalArgumentException();
        else return i+j;
    }


}
