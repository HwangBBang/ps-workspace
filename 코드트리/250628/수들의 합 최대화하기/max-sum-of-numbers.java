import java.util.*;

public class Main {
    static int n;
    static int[][] grid;
    static boolean[] v;
    static List<Integer> results = new ArrayList<>();


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        v = new boolean[n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        // Please write your code here.

        choice(0,0);

        int answer = 0;
        for (int elem : results){
            answer = Math.max(answer,elem);
        }

        System.out.println(answer);

    }
    
    static void choice(int row, int answer){
        if (row >= n){
            results.add(answer);
            return;
        }

        for (int col = 0; col < n; col ++){
            if(v[col]) continue; // 방문 했다면
            
            v[col] = true;
            choice(row + 1, answer + grid[row][col]); // 다음 행으로 
            v[col] = false;
        }
        
    }
}