import java.util.Scanner;
public class Main {
    static int[][] dp;
    static int[] dr = {0,1};
    static int[] dc = {1,0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        // Please write your code here.

        // 초기 세팅
        dp = new int[n][n];
        dp[0][0] = matrix[0][0];
        for(int i = 1; i < n; i ++){
            dp[0][i] = Math.max(dp[0][i-1],matrix[0][i]);
            dp[i][0] = Math.max(dp[i-1][0],matrix[i][0]);
        }
        // bt-up
        for(int i = 1; i < n; i ++){
            for(int j = 1; j < n; j ++){
                dp[i][j]= Math.max(Math.min(dp[i-1][j],dp[i][j-1]), matrix[i][j]);
            }
        }

        System.out.println(dp[n-1][n-1]);
        // n = 4
        // dp[0][0] = matrix[0][0]
        // dp[3][3] = Math.min(dp[2][3], dp[3][2])

    }
}