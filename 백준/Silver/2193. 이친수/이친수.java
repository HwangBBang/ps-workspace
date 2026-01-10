// package baekjoon.silver;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("src/baekjoon/silver/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] dpCntZero = new long[n + 1]; // k 자리의 0으로 끝나는 것의 갯수
        long[] dpCntOne = new long[n + 1]; // k 자리의 1으로 끝나는 것의 갯수

        dpCntOne[1] = 1;
        dpCntZero[1] = 0;
        if (n == 1){
            System.out.println(dpCntOne[n] + dpCntZero[n]);
            return;
        }
        // 0 끝에는 1 붙일 수 있다.
        for (int i = 2; i <= n; i++) {
            dpCntOne[i] = dpCntZero[i - 1];
            dpCntZero[i] = dpCntZero[i - 1] + dpCntOne[i - 1];

        }
        System.out.println(dpCntOne[n] + dpCntZero[n]);

    }
}
