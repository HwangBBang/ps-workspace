// package baekjoon.platinum;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("src/baekjoon/platinum/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        long[] A = new long[n];
        long[] tails = new long[n];
        int[] tailsIdx = new int[n];
        int[] prevIdx = new int[n];
        Arrays.fill(prevIdx, -1);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A[i] = Long.parseLong(st.nextToken());
        }

        int len = 0; // LIS 길이

        for (int i = 0; i < n; i++) {
            int pos;
            if (len == 0 || tails[len - 1] < A[i]) {
                // 가장 긴 수열 뒤에 붙일 수 있으면 그대로 확장
                pos = len;
                tails[len] = A[i];
                len++;

            } else {
                // 특정 길이 수열의 끝값을 x로 더 작게 갱신
                pos = lowerBound(tails, 0, len - 1, A[i]); // 첫 tails[pos] >= x
                tails[pos] = A[i];
            }

            tailsIdx[pos] = i;

            if (pos == 0) continue;
            prevIdx[i] = tailsIdx[pos - 1];
        }

        long[] answer = new long[len];
        int idx = tailsIdx[len - 1];
        for (int i = len - 1; i >= 0; i--) {
            answer[i] = A[idx];
            idx = prevIdx[idx];
        }

        StringBuilder sb = new StringBuilder();
        sb.append(len).append("\n");
        for (int i = 0; i < len; i++) {
            sb.append(answer[i]).append(" ");
        }
        System.out.println(sb);
    }

    static int lowerBound(long[] tails, int from, int to, long pivot) {
        int left = from;
        int right = to;

        while (left < right) {
            int mid = (left + right) >> 1 ;
            if (tails[mid] >= pivot) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}