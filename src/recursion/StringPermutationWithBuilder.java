package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sergei.kostin on 12/28/17.
 */
public class StringPermutationWithBuilder {

    public static void main(String[] args) {

        StringBuilder builder = new StringBuilder();
        builder.append('a');
        builder.append('b');
        builder.append('c');
        builder.replace(1,4, "");
        System.out.println(builder);
    }

}
