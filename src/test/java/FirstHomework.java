import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class FirstHomework {

    @Test
    public void finalLoanAmout() {
        int sum = finalLoanAmout(100000,30,2);
        System.out.println(sum);
    }
    public Integer finalLoanAmout(int a, int b, int c) {
        int d = a * c * (b*12);
       return d;
    }

}
