package strings;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/minimum-window-substring/discuss/26810/Java-solution.-using-two-pointers-+-HashMap
 **/
public class MinWindowSubstring {

    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap();
        for(char c : t.toCharArray()){
            if(map.containsKey(c)){
                map.put(c, map.get(c)+1);
            }
            else{
                map.put(c, 1);
            }
        }
        int left = 0;
        int minLeft=0;
        int minLen =s.length()+1;
        int count = 0;

        for(int right = 0; right<s.length(); right++){
            char r = s.charAt(right);
            if(map.containsKey(r)){//the goal of this part is to get the first window that contains whole t
                map.put(r, map.get(r)-1);
                if(map.get(r)>=0) count++;//identify if the first window is found by counting frequency of the characters of t showing up in S
            }
            while(count == t.length()){//if the count is equal to the length of t, then we find such window
                if(right-left+1 < minLen){//jsut update the minleft and minlen value
                    minLeft = left;
                    minLen = right-left+1;
                }
                char l = s.charAt(left);
                if(map.containsKey(l)){//starting from the leftmost index of the window, we want to check if s[left] is in t. If so, we will remove it from the window, and increase 1 time on its counter in hashmap which means we will expect the same character later by shifting right index. At the same time, we need to reduce the size of the window due to the removal.
                    map.put(l, map.get(l)+1);
                    if(map.get(l)>0) count--;
                }
                left++;//if it doesn't exist in t, it is not supposed to be in the window, left++. If it does exist in t, the reason is stated as above. left++.
            }
        }
        return minLen==s.length()+1?"":s.substring(minLeft, minLeft+minLen);
    }

//    1- First check if length of string is less than the length of given pattern, if yes
//    then "no such window can exist ".
//    2- Store the occurrence of characters of given pattern in a hash_pat[].
//    3- Start matching the characters of pattern with the characters of string i.e. increment count
//    if a character matches
//    4- Check if (count == length of pattern ) this means a window is found
//    5- If such window found, try to minimize it by removing extra characters from beginning of current window.
//    6- Update min_length.
//    7- Print the minimum length window.

    static final int no_of_chars = 256;

    // Function to find smallest window containing
    // all characters of 'pat'
    static String findSubString(String str, String pat)
    {
        int len1 = str.length();
        int len2 = pat.length();

        // check if string's length is less than pattern's
        // length. If yes then no such window can exist
        if (len1 < len2)
        {
            System.out.println("No such window exists");
            return "";
        }

        int hash_pat[] = new int[no_of_chars];
        int hash_str[] = new int[no_of_chars];

        // store occurrence ofs characters of pattern
        for (int i = 0; i < len2; i++)
            hash_pat[pat.charAt(i)]++;

        int start = 0, start_index = -1, min_len = Integer.MAX_VALUE;

        // start traversing the string
        int count = 0;  // count of characters
        for (int j = 0; j < len1 ; j++)
        {
            // count occurrence of characters of string
            hash_str[str.charAt(j)]++;

            // If string's char matches with pattern's char
            // then increment count
            if (hash_pat[str.charAt(j)] != 0 &&
                    hash_str[str.charAt(j)] <= hash_pat[str.charAt(j)] )
                count++;

            // if all the characters are matched
            if (count == len2)
            {
                // Try to minimize the window i.e., check if
                // any character is occurring more no. of times
                // than its occurrence  in pattern, if yes
                // then remove it from starting and also remove
                // the useless characters.
                while ( hash_str[str.charAt(start)] > hash_pat[str.charAt(start)]
                        || hash_pat[str.charAt(start)] == 0)
                {

                    if (hash_str[str.charAt(start)] > hash_pat[str.charAt(start)])
                        hash_str[str.charAt(start)]--;
                    start++;
                }

                // update window size
                int len_window = j - start + 1;
                if (min_len > len_window)
                {
                    min_len = len_window;
                    start_index = start;
                }
            }
        }

        // If no window found
        if (start_index == -1)
        {
            System.out.println("No such window exists");
            return "";
        }

        // Return substring starting from start_index
        // and length min_len
        return str.substring(start_index, start_index + min_len);
    }



    public static void main(String[] args) {

        MinWindowSubstring mw = new MinWindowSubstring();
        System.out.println(findSubString("ADOBECODEBANC", "ABC"));

    }

}
