package strings;

import lists.LongestValidParenthesis;

/**
 * Created by sergei.kostin on 1/19/18.
 */
public class LongestSubstringPalindrome {

    private boolean isPalindrome(String s){
        for(int i = 0; i < s.length()/2; i++){
            if(s.charAt(i) != s.charAt(s.length() - 1 - i)) return false;
        }
        return true;
    }


    public static void main(String[] args) {
        String str = "abbaa";
        LongestSubstringPalindrome lsp = new LongestSubstringPalindrome();
        System.out.println(lsp.isPalindrome(str));
        System.out.println(str.substring(1,3));

        int temp = 0;
        for(int j = 0; temp< 10; j++, temp++){
            System.out.println(temp + " j " + j);

        }

    }


}
