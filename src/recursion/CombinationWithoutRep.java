package recursion;

/**
 * Created by sergei.kostin on 11/5/17.
 */
public class CombinationWithoutRep {

    public void combination(char[] input){
        combinationUtil(input, 0, new StringBuilder());
    }

    private void combinationUtil(char[] input, int temp, StringBuilder builder){
        if(temp == input.length){
            return;
        }

        for(int i = temp; i < input.length; i++){
            builder.append(input[i]);
            System.out.println(builder.toString());
            combinationUtil(input, i+1, builder );
            builder.setLength(builder.length() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationWithoutRep comb = new CombinationWithoutRep();
        String input = "abcd";
        comb.combination(input.toCharArray());
    }

}
