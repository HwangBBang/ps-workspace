// package baekjoon.gold;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];
        int[] tails = new int[n];
        int[] tailsIdx = new int[n];
        int[] prev = new int[n];
        Arrays.fill(prev, -1);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int len = 0;
        for (int i = 0; i < n; i++) {
            int pos;
            if (len == 0 || A[i] > tails[len - 1]) {
                pos = len;
                tails[len] = A[i];
                len++;
            } else {
                pos = lowerBound(tails, 0, len-1, A[i]);
                tails[pos] = A[i];
            }
            tailsIdx[pos] = i;

            if (pos == 0) continue;
            prev[i] = tailsIdx[pos - 1];
        }

        int[] answer = new int[n];
        int idx = tailsIdx[len - 1];
        for (int i = len - 1; i >= 0; i--) {
            answer[i] = A[idx];
            idx = prev[idx];
        }
        StringBuilder sb = new StringBuilder();
        sb.append(len).append("\n");
        for (int i = 0; i < len; i++) {
            sb.append(answer[i]).append(" ");
        }
        System.out.println(sb);
    }

    static int lowerBound(int[] tails, int from, int to, int pivot) {
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
/*
길이 뿐만 아니라 복원까지 하기위해서는
2가지 정보가 더 필요하다.
1. 길이 len 인 수열에 마지막원소가 어떤 인덱스인지 알아야한다.
2. 선택된 수열의 원소라면 이전것이 무엇인지 알아야한다.

*/