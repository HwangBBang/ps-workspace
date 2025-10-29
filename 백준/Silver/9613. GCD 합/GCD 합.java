// package baekjoon.silver;

import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static long answer;
    static int[] line;
    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/baekjoon/silver/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            line = new int[n];
            for (int i = 0; i < n; i++) {
                line[i] = Integer.parseInt(st.nextToken());
            }
            answer = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    answer += gcd(line[i], line[j]);
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }

    public static int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }

}
