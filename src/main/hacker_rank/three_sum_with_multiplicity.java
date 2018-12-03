import java.util.Arrays;

public class three_sum_with_multiplicity {

    public static void main(String[] args) {
//        System.out.println(new three_sum_with_multiplicity().threeSumMulti(new int[] {1,1,2,2,2,2}, 5));
//        System.out.println(new three_sum_with_multiplicity().threeSumMulti(new int[] {1,1,2,2,3,3,4,4,5,5}, 8));
        System.out.println(new three_sum_with_multiplicity().threeSumMulti(new int[] {0,0,0,0,0,0,0}, 0));
        System.out.println(new three_sum_with_multiplicity().threeSumMulti(new int[] {0,2,0,0}, 2));
    }


    public int threeSumMulti(int[] a, int target) {
        int count = 0;
        int mod = 1_000_000_007;

        int[] counts = new int[101];

        for (int num : a) {
            counts[num]++;
        }

        for (int i = 0; i < counts.length; i++) {
            for (int j = counts[i] > 1 ? i : i + 1; j < counts.length; j++) {
                int k = target - i - j;
                if (k < 0 || k > 100) continue;
                if (i + j + k == target && counts[i] > 0 && counts[j] > 0 && counts[k] > 0) {

                    if (i == j && j == k) {
                        count = (count + (counts[i] * (counts[i] - 1) * (counts[i] - 2) / 6)) % mod;
                    } else if (i == j) {
                        count = (count + ((counts[i] * (counts[i] - 1)) * counts[k])) % mod;
                    } else if (j == k) {
                        count = (count + (counts[i] * (counts[j] * (counts[j] - 1)))) % mod;
                    } else {
                        count = (count + (counts[i] * counts[j] * counts[k])) % mod;
                    }
                }
            }
        }

        return count;
    }
}
