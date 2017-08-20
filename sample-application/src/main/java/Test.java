import java.util.Arrays;

public class Test {

    public static void main(String[] args) {

        String test = "ala ma kotasss 3";
        String out = solution(test);

        System.out.println("OUT=" + out);
    }


    public static String solution(String S) {
        // write your code in Java SE 8
        int size = S.length();
        char[] input = S.toCharArray();
        char[] output = reverse(input);


        return new String(output);
    }


    private static char[] reverse(char[] input) {


        int size = input.length;
        int start=0;
        int stop=0;

        char[] tmp = new char[size];
        int tmpIdx = 0;

        char[] output = new char[size];

        while (start < size) {

            if (stop < size && input[stop] != ' ') {
                tmp[tmpIdx++] = input[stop++];
            } else {
                char[] reverseTmp = reverseWord(Arrays.copyOfRange(tmp, 0, tmpIdx));
                addWordToOutputAtPosition(output, reverseTmp, start);
                output[stop] = ' ';
                start = stop + 1;
                stop++;
                tmpIdx = 0;
            }

        }

        return output;

    }


    private static void addWordToOutputAtPosition(char[] output, char[] word, int start) {

        for (int i=0; i<word.length; i++) {
            output[start + i] = word[i];
        }

    }



    private static char[] reverseWord(char[] input) {
        char[] output = new char[input.length];

        for (int i=0; i<input.length; i++) {
            output[i] = input[input.length - i -1];
        }

        return output;
    }
}
