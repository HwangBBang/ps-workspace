
import java.io.*;
import java.util.*;

public class Main {
    static final int INF = Integer.MAX_VALUE / 2;

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/beakjun/gold/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] cost = new int[n];
        int[] gain = new int[n];
        int maxGain = -1;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            cost[i] = Integer.parseInt(st.nextToken());
            gain[i] = Integer.parseInt(st.nextToken());
            maxGain = Math.max(maxGain, gain[i]);
        }

        int[] dp = new int[1000 + maxGain + 1]; // 넉넉잡아

        Arrays.fill(dp, INF);dp[0] = 0;

        for (int i = 0; i < n; i++) { // 특정 도시에 대해서 업데이트
            for (int j = gain[i]; j <= 1000 + maxGain; j++) {
                if (dp[j - gain[i]] == INF) continue; // 이전 놈이 아직 업데이트 안된놈이라면
                dp[j] = Math.min(dp[j], dp[j - gain[i]] + cost[i]);
            }
        }

        int answer = INF;
        for (int i = c; i <= c + maxGain; i++) {
            answer = Math.min(answer, dp[i]);
        }

        System.out.println(answer);
    }


}


// 적어도 C명 늘이기 위해 형택이가 투자해야 하는 돈의 최솟값
// 즉, 임계치 C 이상으로 만들기
/*
    dp[k] : k 명을 확보하는데 필요한 비용
    dp[k-gain] : dp[k] - cost
*/