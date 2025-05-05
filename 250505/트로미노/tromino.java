import java.util.*;
import java.io.*;

public class Main {
    public static int[][] grid;
    public static int n;
    public static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        grid = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int ii = 0; ii < m; ii++) {
                grid[i][ii] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;

        for (int i = 0; i < n; i++) {
            for (int ii = 0; ii < m; ii++) {
                result = Math.max(result, getCase1(i, ii));
                result = Math.max(result, getCase2(i, ii));
                result = Math.max(result, getCase3(i, ii));

            }
        }
        System.out.println("" + result);
    }

    public static int getCase1(int i, int ii){
        if (i < 0 || i > n || ii + 1 < 0 || ii + 3 > m) {
            return 0;
        }
        int result = 0;
        for (int k = 0; k < 3; k++) {
            result += grid[i][ii + k];
        }
        return result;
    }

    public static int getCase2(int i, int ii){
        if (i < 0 || i + 3 > n || ii < 0 || ii > m) {
            return 0;
        }
        int result = 0;
        for (int k = 0; k < 3; k++) {
            result += grid[i + k][ii];
        }
        return result;
    }


    public static int getCase3(int i, int ii){
        if ( i + 1 < 0 || i + 1 >= n || ii + 1 < 0 || ii + 1 >= m) {
            return 0;
        }
        int sum = grid[i][ii] + grid[i+1][ii] + grid[i][ii+1] + grid[i+1][ii+1];

        int i1 = sum - grid[i][ii];
        int i2 = sum - grid[i+1][ii];
        int i3 = sum - grid[i][ii+1];
        int i4 = sum - grid[i+1][ii+1];

        return Math.max(Math.max(i1,i2),Math.max(i3,i4));
    }

}