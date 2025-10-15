import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("src/baekjoon/silver/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int x = Integer.parseInt(br.readLine());

        long answer = 0;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            if (binSearch(x - nums[i], nums)) answer ++;
        }
        System.out.println(answer / 2);
    }
    static boolean binSearch(int k, int[] nums){
        int s = 0;
        int e = nums.length-1;
        int m;

        while (s <= e){
            m = (e + s) / 2;

            if (k == nums[m]) return true;
            else if (k < nums[m]) e = m - 1;
            else s = m + 1;
        }

        return false;
    }
}

// 1 ≤ n ≤ 100_000, 1 ≤ x ≤ 2_000_000)