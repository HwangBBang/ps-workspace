import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n+1];
        int[] prefixSum = new int[n+1];

        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
            prefixSum[i] = prefixSum[i-1] + arr[i];
        }
        int result = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < n; j++) {
                int candidate = prefixSum[i] - prefixSum[j];
                if (candidate == k) result ++;
            }
        }
        System.out.println(result);
    }
}