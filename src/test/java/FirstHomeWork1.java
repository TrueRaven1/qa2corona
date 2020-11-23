import org.junit.jupiter.api.Test;

public class FirstHomeWork1 {
    public Integer a  = 100000;
    public Integer b = 30;
    public double c = 2.08;

    @Test
    public void finalSummOfLoan() {

        System.out.println("Main sum is : " + a );
        System.out.println("Sum of percent is: " + summOfPercent(a, b, c));
        double summ = summOfPercent(a, b, c);
        System.out.println("Final sum of loan is: " + finalLoanAmout(summ, a));

    }

    public double summOfPercent(Integer a, Integer b, double c) {
        double d = a * c/100 * b;
        return d;

    }

    public int finalLoanAmout (double d, Integer a) {
        double e = d + a;
        return (int) e;
}}

