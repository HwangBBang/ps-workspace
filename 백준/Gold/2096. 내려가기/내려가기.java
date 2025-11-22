// package baekjoon.gold;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main{
    static int n, m;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] grid = new int[n+1][3];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            grid[i][0] = Integer.parseInt(st.nextToken());
            grid[i][1] = Integer.parseInt(st.nextToken());
            grid[i][2] = Integer.parseInt(st.nextToken());
        }
        int[] maxDp = new int[3];
        int[] minDp = new int[3];

        for (int i = 0; i < 3; i++) {
            maxDp[i] = grid[1][i];
            minDp[i] = grid[1][i];
        }

        for (int i = 2; i <= n; i++) {
            int nextMax0 = grid[i][0] + Math.max(maxDp[0], maxDp[1]);
            int nextMax1 = grid[i][1] + Math.max(Math.max(maxDp[0], maxDp[1]), maxDp[2]);
            int nextMax2 = grid[i][2] + Math.max(maxDp[1], maxDp[2]);

            maxDp[0] = nextMax0;
            maxDp[1] = nextMax1;
            maxDp[2] = nextMax2;

            int nextMin0 = grid[i][0] + Math.min(minDp[0], minDp[1]);
            int nextMin1 = grid[i][1] + Math.min(Math.min(minDp[0], minDp[1]), minDp[2]);
            int nextMin2 = grid[i][2] + Math.min(minDp[1], minDp[2]);

            minDp[0] = nextMin0;
            minDp[1] = nextMin1;
            minDp[2] = nextMin2;
        }
//
        int maxAnswer = Math.max(Math.max(maxDp[0], maxDp[1]), maxDp[2]);
        int minAnswer = Math.min(Math.min(minDp[0], minDp[1]), minDp[2]);

        System.out.println(maxAnswer + " " + minAnswer);
    }



}

/*
 수의 합 -> minDP , maxDP
 n 번째 줄 까지 최대 , 최소 누적합을 저장하는 DP

 0 -> 0 , 1
 1 -> 0 , 1, 2
 2 -> 1 , 2

 최대 점수, 최소 점수

* */
