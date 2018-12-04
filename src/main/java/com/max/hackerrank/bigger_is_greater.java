package com.max.hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class bigger_is_greater {

    private static String biggerIsGreater(String w) {
        char[] chars = w.toCharArray();

        // from right to left, find the first position where char[i + 1] > char[i]. Call this the 'anchor'.
        int anchor = -1;
        for (int i = chars.length - 2; i >= 0; i--) {
            if (chars[i + 1] > chars[i]) {
                anchor = i;
                break;
            }
        }

        // if an anchor exists, then from left to right (starting at the anchor), find the character with the
        // smallest lexicographic delta and swap the anchor with that character. Call this character 'swap'.
        if (anchor > -1) {
            int d = Integer.MAX_VALUE;
            int swap = -1;

            for (int j = anchor + 1; j < chars.length; j++) {
                if (chars[j] > chars[anchor] && chars[j] - chars[anchor] < d) {
                    d = chars[j] - chars[anchor];
                    swap = j;
                }
            }

            // if a swap exists, then execute the swap and sort the characters following the anchor.
            if (swap != -1) {
                char tmp = chars[anchor];
                chars[anchor] = chars[swap];
                chars[swap] = tmp;

                // after swapping, sort the characters following the anchor.
                Arrays.sort(chars, anchor + 1, chars.length);
                return new String(chars);
            }
        }

        return "no answer";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int TItr = 0; TItr < T; TItr++) {
            String w = scanner.nextLine();

            String result = biggerIsGreater(w);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
