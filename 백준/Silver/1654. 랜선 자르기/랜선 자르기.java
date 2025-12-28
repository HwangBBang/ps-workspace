// package baekjoon.silver;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.function.IntUnaryOperator;

public class Main {
    public static void main(String[] args) throws IOException {
//         System.setIn(new FileInputStream("src/baekjoon/silver/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        long[] lines = new long[k];

        long maxValue = -1;

        for (int i = 0; i < k; i++) {
            lines[i] = Integer.parseInt(br.readLine());
            maxValue = Math.max(maxValue, lines[i]);
        }

        long left = 1;
        long right = maxValue;
        long answer = 1;

        while (left <= right) {
            long mid = (left + right) >> 1;
            long result = getCount(mid, lines);
            if (result >= n) {
                answer = Math.max(answer, mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(answer);

    }

    static long getCount(long pivot, long[] lines) {
        long answer = 0;
        for (long line : lines) {
            answer += (line / pivot);
        }
        return answer;
    }
}

/*

    필요한 랜선 갯수 n
    1 부터 늘려감 그중 가장 작은것? 까지?

    랜선의 길이는 2^31-1 이하..
    long , 선형탐색 X


*/