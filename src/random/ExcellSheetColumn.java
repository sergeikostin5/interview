package random;

/**
 * Created by sergei.kostin on 3/14/18.
 */
public class ExcellSheetColumn {

    public String convertToTitle(int n) {

        String result = "";

        while(n > 0){

            int remainder = n%26;
            if(remainder == 0){
                result = "Z" + result;
                n = n/26 - 1;
            }else {
                char temp = (char) ('A' - 1 + remainder);
                result = temp + result;
                n = n/26;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ExcellSheetColumn esc = new ExcellSheetColumn();

        System.out.println(esc.convertToTitle(1));
    }

}
