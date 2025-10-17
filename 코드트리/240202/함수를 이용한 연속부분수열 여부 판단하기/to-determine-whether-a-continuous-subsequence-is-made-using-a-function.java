import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] nums = new int[n];
        int[] subNums = new int[m];

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            nums[i] = Integer.parseInt(st1.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++)
            subNums[i] = Integer.parseInt(st2.nextToken());

        if (isSub(nums, subNums)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

    }

    static boolean isSub(int[]A, int[]B) {
        int outLen = A.length - B.length + 1;
        int innerLen = B.length;


        for (int i = 0; i < outLen; i++) {
            boolean match = true;

            for (int j = 0; j < innerLen; j++) {
                if (A[i + j] != B[j]) {
                    match = false;
                    break;
                }
            }
            if (match) return match;
        }
        return false;
    }
}