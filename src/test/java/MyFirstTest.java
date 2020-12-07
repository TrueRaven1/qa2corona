import org.junit.jupiter.api.Test;

public class MyFirstTest {
    private String name = "Gospodin";

    @Test
    public void FirstTest() {
        System.out.println("Hello, corona!");

        int sum = sumTwoDigits(15, 45);
        System.out.println("And the sum is: " + sum);

        System.out.println(sumTwoDigits(9, 13));
        System.out.println(name);
    }

    private int sumTwoDigits(int a, int b) {
        System.out.println(name);
        int c = a + b;
        return c;
    }
}
//zajti na tv net, s glavnoj stranici perejti na statju, i perejti na komentarii.
//*perehodim na opredeljennuju statju po schetu (ispoljzuja spiski)
//**perehodim na statjju po konkretno zadannomu zagalovku
//***perehodja po stranicam, proverjaem chto zagolovki vezde odinakovie
//****vmeste s zagolovkami proverjatj i kolichestvo komentariev(pri proverke ispoljzovatj Inti a ne stringi)
//*****proverjaja kolichestvo komentariev (schetchik) proverjatj nalichie komentariev