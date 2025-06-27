import java.util.Scanner;
public class Main {
    static int [] dp;
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[n + 1];
        arr[0] = 0;

        for (int i = 1; i <= n; i++) arr[i] = sc.nextInt();
        dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        // Please write your code here.
        // 0 1 2 3 4 5 6
        // 0 1 3 2 1 2 4
        
        /* 
        dp[0] = 0
        dp[1] = 1;
        
        dp[2] = dp[1] + 1;
            dp[2] > dp[1] 이기에 => O

        dp[3] = dp[1] + 1; 
            dp[3] > dp[2] X 이기에 => X
            dp[3] > dp[1] 이기에 => O

        dp[4] = dp[0] + 1;  
            dp[4] > dp[3] X 이기에 => X
            dp[4] > dp[2] X 이기에 => X
            dp[4] > dp[1] X 이기에 => X
            dp[4] > dp[0] 이기에 => O

        dp[5] = dp[4] + 1;
            dp[5] > dp[4] 이기에 => O

        dp[6] = dp[5] + 1;
            dp[6] > dp[5] 이기에 => O

        */
        
        // b-up

        for(int i = 2; i <= n; i ++){
            int k = selectIdx(i);
            dp[i] = dp[k] + 1;
        }
        
        int result = -1;
        for (int lens : dp){
            if (result < lens) result = lens;
        }
        System.out.println(result);
        
    }
    
    static int selectIdx(int cur){
        for (int i = cur-1; i >=0; i --){
            if (arr[cur] > arr[i]) return i;
        }
        return 0;
    }
}