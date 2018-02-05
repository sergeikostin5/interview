package random;

/**
 * Created by sergei.kostin on 2/4/18.
 */
public class CountAndSay {
        public String countAndSay(int n) {
            String s = "1";
            for(int i = 1; i < n; i++){
                s = countIdx(s);
            }
            return s;
        }

        public String countIdx(String s){
            StringBuilder sb = new StringBuilder();
            char c = s.charAt(0);
            int count = 1;
            for(int i = 1; i < s.length(); i++){
                if(s.charAt(i) == c){
                    count++;
                }
                else
                {
                    sb.append(count);
                    sb.append(c);
                    c = s.charAt(i);
                    count = 1;
                }
            }
            sb.append(count);
            sb.append(c);
            return sb.toString();
        }

    public static void main(String[] args) {
        CountAndSay cs = new CountAndSay();
        System.out.println(cs.countAndSay(5));
    }
}
