// package baekjoon.gold;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int n, s , result, answer;
    static int[] nums;

    public static void main(String[] args) throws IOException {
//         System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        nums = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        result = 0;
        answer = 0;
        backtracking(0);
        System.out.println(answer);
    }

    static void backtracking(int step) {
        if (step != 0 && result == s) {
            answer++;
        }
        for (int i = step; i < n; i++) {
            result += nums[i];
            backtracking(i + 1);
            result -= nums[i];
        }
    }

}
