import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        
        boolean[][] group = new boolean[3+1][n + 1];
        

        for (int i = 1; i <= n; i++) {
            int groupNum = sc.nextInt();
            group[groupNum][i] = true;
        }
        int[] a = new int[q];
        int[] b = new int[q];


        for (int i = 0; i < q; i++) {
            a[i] = sc.nextInt(); b[i] = sc.nextInt();            
        }

        int [][] prefixCnt = new int [3+1][n+1];
        
        for (int i = 1; i <= 3; i++){
            for (int j = 1; j <= n; j++){
                int cnt = group[i][j] ? 1 : 0;
                prefixCnt[i][j] = prefixCnt[i][j-1] + cnt;
            }
        }
        
        StringBuilder sb;

        for (int k = 0; k < q; k++) {
            sb = new StringBuilder();
            int start = a[k], end = b[k];
            for (int i = 1; i <= 3; i++){
                int eachCnt = prefixCnt[i][end] - prefixCnt[i][start-1];
                sb = sb.append(eachCnt).append(" ");
            }
            System.out.println(sb);

        }
        
    
    }
}

// 1 ~ N 까지 돌이있음 
// 1, 2, 3 증 하나에 속함 
// 