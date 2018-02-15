package random;

/**
 * Created by sergei.kostin on 2/5/18.
 */
public class DivideWODivide {

    int integer_divide(int dividend, int divisor) {

        // We will return -1 if the divisor is '0'.
        if (divisor == 0) {
            return -1;
        }

        if (dividend < divisor) {
            return 0;
        }
        else if (dividend == divisor) {
            return 1;
        }
        else if (divisor == 1) {
            return dividend;
        }

        int q = 1;
        int val = divisor;

        while (val < dividend) {
            val <<= 1;
            // we can also use 'val = val + val;'

            q <<= 1;
            // we can also use 'q = q + q;'
        }

        if (val > dividend) {
            val >>= 1;
            q >>= 1;

            return q + integer_divide(dividend - val, divisor);
        }

        return q;
    }

    public static void main(String[] args) {
        DivideWODivide dv = new DivideWODivide();
        System.out.println(dv.integer_divide(40,4));
    }

}
