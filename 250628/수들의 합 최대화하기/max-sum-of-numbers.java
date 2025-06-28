import java.util.*;

public class Main {
    static int n;
    static int[][] grid;
    static List<Pair> stack = new ArrayList<>();
    static List<Integer> rows = new ArrayList<>();
    static List<Integer> cols = new ArrayList<>();
    static List<Integer> results = new ArrayList<>();

    public static class Pair{
        int r;
        int c;
        
        public Pair(int r, int c){
            this.r = r;
            this.c = c;
        }
        public int getValue(){
            return grid[this.r][this.c];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        // Please write your code here.

        choice(0);
        int answer = 0;
        for (int elem : results){
            answer = Math.max(answer,elem);
        }

        System.out.println(answer);
        
    }
    static int returnSum(){
        int temp = 0;
        for (Pair elem : stack){
            temp += elem.getValue();
        }
        return temp;
    }

    static void choice(int cnt){
        if (cnt >= n){
            results.add(returnSum());
            return;
        }

        for (int i = 0; i < n; i ++){
            for (int j = 0; j < n; j ++){
                if(rows.contains(i) || cols.contains(j)) continue;

                stack.add(new Pair(i,j));
                rows.add(i); cols.add(j);
                choice(cnt + 1);
                rows.remove(stack.size()-1);
                cols.remove(stack.size()-1);
                stack.remove(stack.size()-1);
            }
        }
    }
}