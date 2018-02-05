package sorting;

/**
 * Created by sergei.kostin on 12/27/17.
 */
public class SortCharsInString {

    private static final int CHAR_COUNT = 256;

    public static void main(String[] args) {
        String str = "Hello workld!!!";
        SortCharsInString sci = new SortCharsInString();
        String result = sci.sortCharacters(str);
        System.out.println(result);
    }

    public String sortCharacters(String inString){

        char[] arr = inString.toCharArray();

        int[] temp = new int[CHAR_COUNT];

        for(char elem : arr){
            temp[(int) elem]++;
        }

        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < CHAR_COUNT; i++){
            while(temp[i] > 0){
                builder.append((char)i);
                temp[i]--;
            }
        }

        return builder.toString();

    }

}
