
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("src/beakjun/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] nums = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int answer = Integer.MAX_VALUE;
        int sum = 0;
        int left = 1;
        for (int right = 1; right <= n; right++) {
            sum += nums[right];

            while (sum >= s) {
                answer = Math.min(answer, right - left + 1);
                sum -= nums[left++];
            }
        }

        answer = answer == Integer.MAX_VALUE ? 0 : answer;
        System.out.println(answer);
    }
}

/*

 10_000 * 100_000 =>1_000_000_000

 100,000 * 4byte => 400 kb
* */