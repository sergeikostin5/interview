package recursion;

import java.util.ArrayList;

/**
 * Created by sergei.kostin on 11/8/17.
 */
public class PalindromePartitioning {

    public static void main(String[] args) {
        PalindromePartitioning pp = new PalindromePartitioning();
        ArrayList<ArrayList<String>> list = pp.partition("nitin");
        for(ArrayList<String> sublist : list){
            System.out.println(sublist);
        }
    }

    public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();

        if (s == null || s.length() == 0) {
            return result;
        }

        ArrayList<String> partition = new ArrayList<String>();//track each possible partition
        addPalindrome(s, 0, partition, result);

        return result;
    }

    private void addPalindrome(String s, int level, ArrayList<String> partition,
                               ArrayList<ArrayList<String>> result) {
        //stop condition
        if (level == s.length()) {
            ArrayList<String> temp = new ArrayList<String>(partition);
            result.add(temp);
            return;
        }

        for (int i = level + 1; i <= s.length(); i++) {
            String str = s.substring(level, i);
            if (isPalindrome(str)) {
                partition.add(str);
                addPalindrome(s, i, partition, result);
                partition.remove(partition.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

}
