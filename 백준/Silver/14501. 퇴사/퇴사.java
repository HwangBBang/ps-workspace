// package baekjoon.silver;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         System.setIn(new FileInputStream("src/baekjoon/silver/input.txt"));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] T = new int[n + 1];
        int[] P = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }
        /*정방향*/
        // dp[i] : i번째 날 "시점까지" 얻을 수 있는 최대 수익
        int[] dp = new int[n + 2];

        for (int i = 1; i <= n; i++) {
            // 1. 오늘 상담을 시작하지 않고, 내일로 넘어가는 경우
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);

            // 2. 오늘 상담을 시작하는 경우
            int next = i + T[i];
            if (next <= n + 1) {
                dp[next] = Math.max(dp[next], dp[i] + P[i]);
            }
        }
        /*역방향
        for (int i = n; i >= 1; i--) {
            int nxtI = i + T[i]; 
            if (nxtI <= n + 1) {
                dp[i] = Math.max(dp[i + 1], P[i] + dp[nxtI]);
            } else {
                dp[i] = dp[i + 1];
            }
        }
        */
        int answer = 0;
        for (int i = 1; i <= n + 1; i++) {
            answer = Math.max(answer, dp[i]);
        }
        System.out.println(answer);
    }
}

/*
   역방향 VS 정방향 DP

   역방향 DP 가 자연스러운 경우
   -> dp[i] 가 i 번째 시점 부터 끝까지의 최적값 ( 앞으로 남은 것을 보는 형태 )
   -> i 에서 하는 선택이 i 에서 뭔가를 한다. -> i + k 로 점프
   -> i 에서 아무것도 안한다 -> i + 1 로 점프
   -> 이런 식 항상 더 큰 인덱스로만 진행이 될때
   -> 베이스값이 뒤에 하나로 깔끔히 정리가 될 때

   정방향 DP(누적형) 이 자연스러운 경우
   -> dp[i] 가 i 번째 시점까지의 최적값 ( 지금까지 누적 결과 형태 )
   -> i 에서 다음 놈들 중 여러개로 전이 할때
   -> 어떤 시점까지 최댓값이 계속 필요할 때

    DP 테이블을 정의할 떄는
    1. "상태 하나를 문장으로 말할 수 있어야 한다"
    2. "정의한 상태에서의 선택은 현재 정보만으로 결정돼야 한다"
    3. "답을 어디서 뽑을지 먼저 정하고, 그걸 기준으로 상태를 거꾸로 설계한다"

*/