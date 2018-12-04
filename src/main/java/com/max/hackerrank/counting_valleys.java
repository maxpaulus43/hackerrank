package com.max.hackerrank;

import java.io.IOException;
import java.util.Scanner;

public class counting_valleys {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        String s = scanner.nextLine();
        int result = countingValleys(n, s);
        System.out.println(result);
        scanner.close();
    }

    /**
     * A valley has been encountered under two conditions:
     *  The current altitude is -1 AND
     *  The current direction is up ('U')
     */
    private static int countingValleys(int n, String s) {

        // check for bad input here
        if (n == 0 || s == null || s.length() == 0) { return 0; }

        int valleysEncountered = 0;
        int currentAltitude = 0;

        char[] steps = s.toCharArray();

        for (char step : steps) {
            switch (step) {
                case 'U':
                    if (currentAltitude++ == -1) valleysEncountered++;
                    break;
                case 'D':
                    currentAltitude--;
            }
        }

        return valleysEncountered;
    }
}
