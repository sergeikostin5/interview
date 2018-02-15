import lists.LinkedListImpl;

import java.io.InputStream;
import java.io.Reader;
import java.util.*;

/**
 * Created by sergei.kostin on 11/5/17.
 */
public class Test {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        for(int i = 0; i < list.size(); i++){
            if(i == 2) list.remove(i+1);
        }

        int[] nums = {1,2,3};

        List temp = Arrays.asList(nums);





    }





}
