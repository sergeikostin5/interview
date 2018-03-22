package recursion;

/**
 * Created by sergei.kostin on 3/14/18.
 */
public class WildcardMatchingMy {

    public boolean isMatch(String original, String pattern) {
        return helper(original,pattern,0,0);

    }


    boolean helper(String original, String pattern, int originPointer, int patternPointer) {
        return true;
    }

    public static void main(String[] args) {
        WildcardMatchingMy wm = new WildcardMatchingMy();
        System.out.println(wm.isMatch("abbac", "a*a?"));
    }


}
