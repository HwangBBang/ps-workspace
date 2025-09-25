import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] arr = new int[n+1][n+1];
        int[][] prefixSum = new int[n+1][n+1];

        int result = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                arr[i][j] = sc.nextInt();
                prefixSum[i][j] = prefixSum[i][j-1] + prefixSum[i-1][j] - prefixSum[i-1][j-1] + arr[i][j];
            }
        }

        for (int i = k; i <= n; i++) {
            for (int j = k; j <= n; j++) {
                int candidate = prefixSum[i][j] - prefixSum[i-k][j] - prefixSum[i][j-k] + prefixSum[i-k][j-k]; 
                result = Math.max(result, candidate);
            }
        }

        System.out.println(result);
        
    }
}