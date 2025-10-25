// package baekjoon.silver;

import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int answer = Integer.MIN_VALUE;
    static int[] trees;
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("src/baekjoon/silver/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        trees = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }

        int[] choice = new int[4];
        Arrays.fill(choice, 1);
        backtracking(choice, 0, n - 4);

        System.out.println(answer);
    }

    static void backtracking(int[] choice, int cnt, int limit) {
        if (cnt == limit){
            answer = Math.max(answer, getAnswer(choice));
            return;
        }
        for (int i = 0; i < 4; i++) {
            choice[i]++;
            backtracking(choice, cnt + 1, limit);
            choice[i]--;
        }
    }

    static int getAnswer(int[] choice) {
        int result = 0;
        int idx = 0;
        int tmp, j;
        for (int i = 0; i < 4; i++) {
            tmp = 1;
            j = 0;
            while (j < choice[i]) {
                tmp *= trees[idx];
                j ++;
                idx ++;
            }
            result += tmp;
        }
        return result;
    }
}

/*

    더해서 최대가 된다.
    그리디하게, 더 할 놈들이 최대이다.
    n 이 작다.

    n을 4개의 파티션으로 나눠야한다.
    각 파티션은 1 이상이다.
    4^(n - 4) 경우 수
    백트랙킹
    1 1 1 1
*/