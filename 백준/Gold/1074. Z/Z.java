// package baekjoon.gold;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
    static int n;

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int size = 1 << n;
        System.out.println(zMove(size, r, c));
    }

    static int zMove(int size, int r, int c) {
        if (size == 1) {
            return 0;
        }
//        0~15 / 16 ~ 31 / 32 ~ 47 / 48 ~ 63

//      사이즈 자체는 반씩 줄어든다.
        int nextSize = size / 2;
        int pivot = nextSize * nextSize;
//        0, 0
        if (r < nextSize && c < nextSize) {
            return zMove(nextSize, r, c);
//        0, 1
        } else if (r < nextSize) {
            return pivot + zMove(nextSize, r, c - nextSize);
//        1, 0
        } else if (c < nextSize) {
            return 2 * pivot + zMove(nextSize, r - nextSize, c);
//        1, 1
        } else {
            return 3 * pivot + zMove(nextSize, r - nextSize, c - nextSize);
        }

    }

}

/*

*/
