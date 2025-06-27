import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.
        // dp(n) = dp(n-1) + 2 * dp(n-2)

        int[] dp = new int [n+1];
        dp[1] = 1;
        dp[2] = 1 + dp[1] + 1;

        for (int i = 3; i <= n ; i ++){
            dp[i] = (2*dp[i-2])%10007 + (dp[i-1])%10007;
        }

        System.out.println(dp[n]);
    }
}