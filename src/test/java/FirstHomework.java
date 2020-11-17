import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class FirstHomework {

    private Integer a = 100000;

    @Test
    public void summOfPercent() {
        double sum = summOfPercent(100000,30,2.09);
        System.out.println("MainSumm is: " + sum );
        System.out.println(sum);

        System.out.println(finalLoanAmout(62700, 100000));
    }
    public double summOfPercent(Integer a, Integer b, double c) {
        double d = a * c/100 * b;
       return d;

    }
    public int finalLoanAmout (double d, Integer a) {
        double e = d + a;
        return (int) e;

    }

}
