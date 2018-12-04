package com.max.hackerrank;

import java.util.Arrays;

public class sort_array_by_parity_2 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortArrayByParityII(new int[]{4,2,5,7})));
    }

    public static int[] sortArrayByParityII(int[] a) {
        int i = 0, j = 1, tmp;

        while (i < j) {
            while (i < a.length && isValid(i, a[i])) i++;
            while (j >= 0 && isValid(j, a[j])) j--;

            if (i < a.length && j < a.length) {
                tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
            }

            i++;
            j--;
        }

        return a;
    }

    private static boolean isValid(int pos, int n) {
        return (pos % 2 ==0 && n % 2 == 0) ||
                (pos % 2 == 1 && n % 2 == 1);
    }
}
