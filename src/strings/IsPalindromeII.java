package strings;

public class IsPalindromeII {

    public boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length()-1;
        boolean spare = false;
        while(i < j){
            if(s.charAt(i) == s.charAt(j)){
                i++; j--;
            }else{
                if(spare) return false;
                if(s.charAt(i+1) == s.charAt(j)){
                    i++; spare = true;
                }else if(s.charAt(i) == s.charAt(j-1)){
                    j--; spare = true;
                }else{
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsPalindromeII isPal = new IsPalindromeII();
        String str = "aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga";
        System.out.println(isPal.validPalindrome(str));
    }

}
