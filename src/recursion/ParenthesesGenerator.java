package recursion;

/**
 * Created by sergei.kostin on 11/8/17.
 */
public class ParenthesesGenerator {

    public void generate(int open, int close, StringBuilder builder, int size){

        if(open < close) return;

        if(open == size && close == size){
            System.out.println(builder.toString());
            return;
        }
        if(open < 3){
            builder.append("(");
            generate(open + 1, close, builder, size);
            builder.setLength(builder.length()-1);
        }
        if(close < 3){
            builder.append(")");
            generate(open, close+1, builder, size);
            builder.setLength(builder.length()-1);
        }


    }

    public static void main(String[] args) {
        ParenthesesGenerator generator = new ParenthesesGenerator();
        generator.generate(0, 0, new StringBuilder(), 3);
    }


}
