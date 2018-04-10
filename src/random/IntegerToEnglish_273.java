package random;

/**
 * Created by sergei.kostin on 3/28/18.
 */
public class IntegerToEnglish_273 {

    String[] small = {"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten",
            "Eleven","Twelve","Thirteen","Fourteen","Fifteen", "Sixteen","Seventeen","Eighteen","Nineteen"};
    String[] tens = {"", "","Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] bigs = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        if(num == 0) return "Zero";

        int counter = 0;
        String result = "";

        while(num > 0){
            int cur = num%1000;
            String temp = helper(cur);
            if(cur !=0){
                result = temp + (bigs[counter].length() > 0 ? " " : "") + bigs[counter] + (result.length() > 0 ? " " : "") + result;
            }
            counter++;
            num = num/1000;
        }

        return result;
    }

    private String helper(int num){
        if(num < 20) return small[num];
        if(num < 100) {
            int cur = num/10;
            int rem = num%10;
            String temp = helper(rem);
            return tens[cur] + (temp.length() > 0 ? " " : "") + temp;
        }
        else{
            int cur = num/100;
            int rem = num%100;
            String temp = helper(rem);
            return small[cur] + " Hundred" + (temp.length() > 0 ? " " : "") + temp;
        }
    }
}
