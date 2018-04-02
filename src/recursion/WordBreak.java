package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sergei.kostin on 3/16/18.
 */
public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        return wordBreak(s, wordDict, "", 0);
    }

    private boolean wordBreak(String s, List<String> wordDict, String temp, int index){
        if(s.length() == temp.length()) return true;
        if(s.length() < temp.length()) return false;

        List<String> subList = getWords(wordDict, s, index);
        if(subList.size() == 0) return false;

        for(String word : subList){
            if(wordBreak(s, wordDict, temp + word, (temp+word).length())){
                return true;
            }
        }
        return false;
    }

    private List<String> getWords(List<String> wordDict, String s, int index){
        List<String> result = new ArrayList<>();
        for(String elem : wordDict){
            int t = index;
            for(int i = 0; i < elem.length(); i++){
                if(t >= s.length() || s.charAt(t) != elem.charAt(i) ) break;
                t++;
                if(i == elem.length() - 1) result.add(elem);
            }

        }
        return result;
    }

    public static void main(String[] args) {

        WordBreak wb = new WordBreak();

        List<String> dict = new ArrayList<>();
        dict.add("le");
        dict.add("lee");
        dict.add("t");
        dict.add("sp");
        dict.add("co");
        dict.add("d");

        System.out.println(wb.wordBreak("leetcod", dict));

        System.out.println((char)(4+'0'));


    }

}
