import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

import java.util.StringTokenizer;

public class FirstHomeWork2 {

    @Test
    public static void main(String[] args) {
        String string = "The best of both worlds";
        int count = 0;

        //Counts each character except space
        for(int i = 0; i < string.length(); i++) {
            if(string.charAt(i) != ' ')
                count++;
        }

        //Displays the total number of characters present in the given string
        System.out.println("Total number of characters in a string: " + count);

        System.out.println("Number of words in string is :" + countWordsUsingStringTokinizer( "The best of both worlds"));
        }
        public static  int countWordsUsingStringTokinizer(String sentence) {
            if (sentence == null || sentence.isEmpty()) {
                return 0;
            }
            StringTokenizer tokens = new StringTokenizer(sentence);
            return tokens.countTokens();


        }

        }


