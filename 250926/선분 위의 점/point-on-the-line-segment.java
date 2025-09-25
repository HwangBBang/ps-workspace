import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); int m = sc.nextInt();

        boolean[] points = new boolean[100_000+1];

        for (int i = 0; i < n; i++) {
            points[sc.nextInt()] = true;
        }

        int[] prefixCnt = new int[100_000+1];
        for (int i = 1; i <= 100_000; i++){
            int cnt = points[i] ? 1 : 0;
            
            prefixCnt[i] = prefixCnt[i-1] + cnt;
        }

        int a, b;
        for (int i = 0; i < m; i++) {
            a = sc.nextInt(); b = sc.nextInt();
            
            System.out.println(prefixCnt[b] - prefixCnt[a-1]);
        }
        
    }
}

// 1~5, 5~21, 22~59, 210~293