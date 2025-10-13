
import java.io.*;
import java.util.*;

public class Main {
    static final int LIMIT = 20 + 1;
    static int[][][] dp;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("src/baekjoon/silver/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        dp = new int[LIMIT][LIMIT][LIMIT];

        while (true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == -1 && b == -1 && c == -1) break;
            setAnswer(a, b, c);
        }
        System.out.println(sb);
    }

    private static int solution(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) return 1;
        if (a > 20 || b > 20 || c > 20) {
            if (dp[20][20][20] == 0) return solution(20, 20, 20);
            return dp[20][20][20];
        }

        if (dp[a][b][c] != 0) return dp[a][b][c];

        if (a < b && b < c) {
            if (dp[a][b][c - 1] == 0) dp[a][b][c - 1] = solution(a, b, c - 1);
            if (dp[a][b - 1][c - 1] == 0) dp[a][b - 1][c - 1] = solution(a, b - 1, c - 1);
            if (dp[a][b - 1][c] == 0) dp[a][b - 1][c] = solution(a, b - 1, c);

            dp[a][b][c] = dp[a][b][c - 1] + dp[a][b - 1][c - 1] - dp[a][b - 1][c];

        } else {
            if(dp[a-1][b][c] == 0) dp[a-1][b][c] = solution(a-1, b, c);
            if(dp[a-1][b-1][c] == 0) dp[a-1][b-1][c] = solution(a-1, b-1, c);
            if(dp[a-1][b][c-1] == 0) dp[a-1][b][c-1] = solution(a-1, b, c-1);
            if(dp[a-1][b-1][c-1] == 0) dp[a-1][b-1][c-1] = solution(a-1, b-1, c-1);

            dp[a][b][c] = dp[a-1][b][c] + dp[a-1][b-1][c] + dp[a-1][b][c-1] - dp[a-1][b-1][c-1];
        }
        return dp[a][b][c];
    }

    private static void setAnswer(int a, int b, int c) {
        int result = solution(a, b, c);
        sb.append("w(")
                .append(a).append(", ")
                .append(b).append(", ")
                .append(c).append(")")
                .append(" = ").append(result)
                .append("\n");
    }

/*
    private static int solution(int a, int b, int c) {

        if (a <= 0 || b <= 0 || c <= 0){
            return 1;
        }

        if (a > 20 || b > 20 || c > 20){
            if (dp[20][20][20] == 0) return solution(20, 20, 20);
            return dp[20][20][20];
        }

        if (dp[a][b][c] != 0) return dp[a][b][c];

        if (a < b && b < c) {
            if (dp[a][b][c - 1] == 0) dp[a][b][c - 1] = solution(a, b, c - 1);
            if (dp[a][b - 1][c - 1] == 0) dp[a][b - 1][c - 1] = solution(a, b - 1, c - 1);
            if (dp[a][b - 1][c] == 0) dp[a][b - 1][c] = solution(a, b - 1, c);

            dp[a][b][c] = dp[a][b][c - 1] + dp[a][b - 1][c - 1] - dp[a][b - 1][c];
            return dp[a][b][c];
        }

        if(dp[a-1][b][c] == 0) dp[a-1][b][c] = solution(a-1, b, c);
        if(dp[a-1][b-1][c] == 0) dp[a-1][b-1][c] = solution(a-1, b-1, c);
        if(dp[a-1][b][c-1] == 0) dp[a-1][b][c-1] = solution(a-1, b, c-1);
        if(dp[a-1][b-1][c-1] == 0) dp[a-1][b-1][c-1] = solution(a-1, b-1, c-1);

        dp[a][b][c] = dp[a-1][b][c] + dp[a-1][b-1][c] + dp[a-1][b][c-1] - dp[a-1][b-1][c-1];
        return dp[a][b][c];
    }

    private static void makeAnswer(int a, int b, int c) {
        int result = solution(a, b, c);
        sb.append("w(")
        .append(a).append(", ")
        .append(b).append(", ")
        .append(c).append(")")
        .append(" = ").append(result)
        .append("\n");

    }*/
}
