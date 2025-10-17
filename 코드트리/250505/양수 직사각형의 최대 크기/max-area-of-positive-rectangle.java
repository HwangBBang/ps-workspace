import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n,m = 0;
    static int answer = -1;
    static int[][] grid;
    

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        grid = new int[n][m];

        for (int i = 0; i < grid.length; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int ii = 0; ii < grid[0].length; ii++) {
                grid[i][ii] = Integer.parseInt(st.nextToken());
            }
        }
//      N x M
//      n = 5
//      0 1 2 3 4
        for (int dn = n; dn > 0; dn--) {
            for (int dm = m; dm > 0; dm--) {
//                크기를 줄여나가며,,
                if (sol(dn, dm)) {
                    answer = Math.max(answer, dn * dm);
                }
            }
        }
        System.out.println(answer);
        return;

    }

    static boolean sol(int dn, int dm) {
        for (int i = 0; i < grid.length; i++) {
            for (int ii = 0; ii < grid[0].length; ii++) {
//              시작 위치
                if (can(i, ii, dn, dm)) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean can(int i, int ii, int dn, int dm) {
        for (int j = 0; j < dn; j++) {
            for (int k = 0; k < dm; k++) {
                if (i + j >= n || ii + k >= m) {
                    return false;
                }
                if (grid[i + j][ii + k] <= 0) {
                    return false;
                }
            }
        }
        return true;
    }


}