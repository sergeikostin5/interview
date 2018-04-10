package arrays;

/**
 * Created by sergei.kostin on 4/8/18.
 */
public class ShortestWordDistance_243 {

    public int shortestDistance(String[] words, String word1, String word2) {

        int pos1 = -1;
        int pos2 = -1;
        int result = Integer.MAX_VALUE;
        for(int i = 0; i < words.length; i++){
            if(word1.equals(words[i])){
                pos1 = i;
                if(pos1 != -1 && pos2 != -1) result = Math.min(Math.abs(pos1 - pos2), result);
            } else if(word2.equals(words[i])){
                pos2 = i;
                if(pos1 != -1 && pos2 != -1) result = Math.min(Math.abs(pos1 - pos2), result);
            }
        }
        return result;
    }

}
