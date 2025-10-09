
import java.io.*;
import java.util.*;

public class Main {

    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/beakjun/gold/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] coins = new int[n];

        int[] dp = new int[k + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
            if (coins[i] > k )continue;
            dp[coins[i]] = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int t = coins[i]; t <= k; t++) {
                if (dp[t - coins[i]] == INF) continue;
                dp[t] = Math.min(dp[t], dp[t - coins[i]] + 1);
            }
        }

        int answer = dp[k] == INF ? -1 : dp[k];
        System.out.println(answer);
    }
}
/*

    1 ≤ n ≤ 100, 1 ≤ k ≤ 10,000

    n이 작으니 굳이 중복제거 할 필요없음

    가치의 합이 k원이 되도록



* */