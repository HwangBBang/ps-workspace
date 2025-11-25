// package baekjoon.gold;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        long[] A = new long[n];
        long[] tails = new long[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A[i] = Long.parseLong(st.nextToken());
        }

        int len = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0 || A[i] > tails[len - 1]) {
                tails[len] = A[i];
                len++;
            } else {
                int idx = lowerBound(tails, 0, len-1, A[i]);
                tails[idx] = A[i];
            }
//            System.out.println(Arrays.toString(tails));
        }

        System.out.println(len);
    }

    static int lowerBound(long[] tails, int from, int to, long pivot) {
        int left = from;
        int right = to;
        while (left < right) {
            int mid = (left + right) / 2;
            if (tails[mid] >= pivot) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }


}
