// package baekjoon.gold;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static final long MOD = 1_000_000_007L;
    public static void main(String[] args) throws IOException {
//         System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        long[] factorial = new long[n + 1];
        long[] inverseFactorial = new long[n + 1];

        // factorial
        factorial[0] = 1L;
        for (int i = 1; i <= n; i++) factorial[i] = factorial[i - 1] * i % MOD;

        inverseFactorial[n] = modPow(factorial[n], MOD - 2);
        for (int i = n; i >= 1; i--) {
            inverseFactorial[i - 1] = inverseFactorial[i] * i % MOD;
        }

        long answer = factorial[n];
        answer = answer * inverseFactorial[k] % MOD;
        answer = answer * inverseFactorial[n - k] % MOD;

        System.out.println(answer);
    }

    private static long modPow(long a, long e) {
        long result = 1L;
        long base = a % MOD;

        while (e > 0) {
            if ((e & 1L) == 1L) {
                result = (result * base) % MOD;
            }
            base = (base * base) % MOD;
            e >>= 1;
        }
        return result;
    }
}
/*
    nCk = factorial[n] * inverseFactorial[k] * inverseFactorial[n-k]

*/