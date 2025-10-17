import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n+1];
        int[] sumArr = new int[n+1];

        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
            sumArr[i] = arr[i] + sumArr[i-1];
        }

        int result = Integer.MIN_VALUE;

        for (int i = k; i <= n; i++) {
            int candi = sumArr[i] - sumArr[i-k];
            result = Math.max(result, candi);
        }
        System.out.println(result);

        
    }
}