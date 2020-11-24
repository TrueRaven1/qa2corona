import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

import java.util.StringTokenizer;

public class FirstHomeWork2 {

    @Test
        public static void main(String[] args) {


            // Initialized a String variable
            String str = "Privet Dima!";

            // Initialized a count variable which will store the length
            int count = str.length();

            // Printed the count variable or the length of String.
            System.out.println("The String has " +count +" characters");

            System.out.println("Number of words in string is :" + countWordsUsingStringTokinizer( "Privet Dima!"));
        }
        public static  int countWordsUsingStringTokinizer(String sentence) {
            if (sentence == null || sentence.isEmpty()) {
                return 0;
            }
            StringTokenizer tokens = new StringTokenizer(sentence);
            return tokens.countTokens();


        }

        }


