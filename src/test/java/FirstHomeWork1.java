import org.junit.jupiter.api.Test;

public class FirstHomeWork1 {

    @Test
    public void finalSummOfLoan() {

        System.out.println("Main sum is: " + 100000);

        System.out.println("Sum of percent is: " + summOfPercent(100000,30, 2.09));

        System.out.println("Final sum of loan is: " + finalLoanAmout(62700, 100000));
    }
    public double summOfPercent(Integer a, Integer b, double c) {
        double d = a * c/100 * b;
        return d;

    }
    public int finalLoanAmout (double d, Integer a) {
        double e = d + a;
        return (int) e;
}}

