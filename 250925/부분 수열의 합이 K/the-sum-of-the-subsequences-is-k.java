import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();
        // int k = sc.nextInt();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st; 
        
        st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n+1];
        int[] prefixSum = new int[n+1];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
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