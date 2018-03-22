package recursion;

/**
 * Created by sergei.kostin on 3/14/18.
 */
public class WildcardMatching {

    public boolean isMatch(String original, String pattern) {
        return helper(original,pattern,0,0);

    }


    boolean helper(String original, String pattern, int originPointer, int patternPointer) {
        if(patternPointer == pattern.length()) return originPointer == original.length();

        if(pattern.charAt(patternPointer) == '*') {
            while(patternPointer < pattern.length() && pattern.charAt(patternPointer) == '*') patternPointer++;   // Move the index at p to a non-start char.
//            while(originPointer < original.length()) {
//                if(helper(original, pattern, originPointer, patternPointer)) return true; // Find one match, return true.
//                originPointer++; // Try the next one.
//            }
           return helper(original, pattern, originPointer, patternPointer);
        }else if(originPointer < original.length() && (pattern.charAt(patternPointer) == '?' || original.charAt(originPointer) == pattern.charAt(patternPointer))){
            return helper(original, pattern, originPointer + 1, patternPointer + 1);
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        WildcardMatching wm = new WildcardMatching();
        System.out.println(wm.isMatch("abbac", "a*a?"));
    }


}
