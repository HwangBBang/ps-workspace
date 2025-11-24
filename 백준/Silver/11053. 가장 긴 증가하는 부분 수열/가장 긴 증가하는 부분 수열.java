// package baekjoon.silver;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/baekjoon/silver/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] A = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            A[i] = Integer.parseInt(st.nextToken());

        int[] tails = new int[n];
        int len = 0;

        for (int i = 0; i < n; i++) {
            if (len == 0 || tails[len - 1] < A[i]) {
                tails[len] = A[i];
                len++;
            } else {
                // 길이 연장은 안돼, 최적화 (어떤 길이의 끝 값을 더 작게 만들어)
                int idx = lowerBound(tails, 0, len, A[i]);
                tails[idx] = A[i];
            }
        }

        int answer = len;
        System.out.println(answer);
    }

    /*
    A[from..to-1] 구간에서
    처음으로 A[idx] >= pivot 이 되는 idx 를 찾는다.
    그런 idx가 없으면 to 를 반환한다.
    */
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
    최장 부분 증가 수열은 n^2 로도 풀 수 있고, n log n 으로도 풀 수 있다.

    길이 별, 끝 값만을 모아둔 배열,,


    1 100 2 50 60 3 5 6 7 8
    0   1 2  3  4 5 6 7 8 9


*/