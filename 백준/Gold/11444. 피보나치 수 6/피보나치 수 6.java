import java.io.*;
import java.util.*;

public class Main {
    static final long MOD = 1_000_000_007;

    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());
        long[][] base = new long[][]{{1, 1}, {1, 0}};
        long[][] ans = pow(base, n);
        System.out.println(ans[0][1]);
    }

    static long[][] prodMatrix(long[][] A, long[][] B) {
        long[][] C = new long[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    C[i][j] = (C[i][j] + A[i][k] * B[k][j]) % MOD;
                }
            }
        }
        return C;
    }

    static long[][] pow(long[][] base, long exp){
        if (exp == 1) return base;
        if (exp % 2 == 0) {
            long[][] half = pow(base, exp / 2);
            return prodMatrix(half, half);
        } else {
            long[][] half = pow(base, exp / 2);
            return prodMatrix(prodMatrix(half, half), base);
        }

    }
}
