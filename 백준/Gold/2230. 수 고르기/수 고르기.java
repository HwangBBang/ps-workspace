// package baekjoon.gold;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

    static final Long INF = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long[] A = new long[n];

        for (int i = 0; i < n; i++) {
            A[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(A);

        long answer = INF;
        /*
        int left = 0;
        int right = 0;

        while (left < n && right < n) {
            long diff = A[right] - A[left];
            if (diff < m) {
                right++;
            } else {
                answer = Math.min(answer, diff);
                left++;
            }
            if (left > right) {
                right = left;
            }
        }*/

        int right = 0;
        for (int left = 0; left < n; left++) {
            while (right < n && A[right] - A[left] < m) {
                right++;
            }
            if (right == n) {
                break;
            }
            answer = Math.min(answer, A[right] - A[left]);

        }

        System.out.println(answer);
    }

}


/*
    투포인터를 써야할것같음

   우선 정렬을 하고

   

 */