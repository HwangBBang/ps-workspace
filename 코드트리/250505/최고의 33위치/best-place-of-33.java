import java.util.Scanner;
import java.io.*;

public class Main {
    
    private static final int OFFSET = 3;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

        int n = Integer.parseInt(br.readLine());

        int[][] m = new int[n][n];
        for (int i = 0; i < n ; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                m[i][j] = Integer.parseInt(line[j]);
            }
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            if (i + OFFSET > n ) break;

            for (int ii = 0; ii < n; ii++) {
                if (ii + OFFSET > n ) break;
                result = Math.max(result, countOne(m, i, ii));
            }
        }

        System.out.println(result);
    }

    private static int countOne(int[][] m, int i, int ii) {
        int sum = 0;
        for (int j = 0; j < OFFSET; j++) {
            for (int jj = 0; jj < OFFSET; jj++) {
                sum += m[i + j][ii + jj];
            }
        }
        return sum;
    }
}