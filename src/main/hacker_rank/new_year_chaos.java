import java.util.Arrays;

public class new_year_chaos {
    public static void main(String[] args) {
//        minimumBribes(Arrays.stream(args).mapToInt(Integer::parseInt).toArray());
        minimumBribes(new int[] { 1,2,5,3,7,8,6,4 });
    }

    // Complete the minimumBribes function below.
    private static void minimumBribes(int[] q) {

        int bribes = 0;
        int min = q.length + 1;

        for (int i = q.length - 1; i >= 0; i--) {
            if (q[i] - i > 3) {
                System.out.println("Too chaotic");
                return;
            }

            if (q[i] > (i + 1)) {
                bribes += q[i] - (i + 1);
            } else {
                if (q[i] < min){
                    min = q[i];
                } else {
                    bribes++;
                }
            }
        }

        System.out.println(bribes);
    }

    // Complete the minimumBribes function below. DOESN'T WORK
    private static void minimumBribes2(int[] q) {

        int bribes = 0;

        for(int i = q.length - 3; i >= 0; i--) {
            if (q[i] - i > 3) {
                System.out.println("Too chaotic");
                return;
            }


            if (q[i + 1] > q[i + 2]) {
                bribes++;
            }
            if (q[i] > q[i + 2]) {
                bribes += 2;
            }

        }

        System.out.println(bribes);
    }
}
