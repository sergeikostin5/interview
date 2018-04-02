package random;

/**
 * Created by sergei.kostin on 3/28/18.
 */
public class IntegerToEnglish {

    static String[] singles = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    static String[] tens = {"ten", "eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
    static String[] ties = {"twenty", "thirty", "forty", "fifty", "sixty", "fifty", "sixty", "seventy", "eighty", "ninety"};
    static String[] bigs = {"hundred", "thousand","million"};

    public String intToWord(int number){

        int order = 1;

        String result = "";

        while(number > 0){
           int toAdd = number %10;
           if(order % 2 == 0){
               result = result +  " hundred " + toAdd;
           }
           else if(order % 3 == 0){
               result = result +  " hundred " + toAdd;
           }else if(order % 4 == 0){
               result = result + " thousand " + toAdd;
           }
        }

        return null;
    }
}
