import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        
        boolean[][] group = new boolean[3+1][n + 1];
        boolean[] group2 = new boolean[n + 1];
        boolean[] group3 = new boolean[n + 1];
        

        for (int i = 1; i <= n; i++) {
            int groupNum = sc.nextInt();
            group[groupNum][i] = true;
        }
        int[] a = new int[q];
        int[] b = new int[q];
        for (int i = 0; i < q; i++) {
            
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }
        // Please write your code here.
    }
}

// 1 ~ N 까지 돌이있음 
// 1, 2, 3 증 하나에 속함 
// 