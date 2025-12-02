// package baekjoon.gold;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static class Range implements Comparable<Range> {
        int start, end;

        public Range(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Range other) {
            if (start != other.start) {
                return Integer.compare(start, other.start);
            }
            return Integer.compare(end, other.end);
        }
    }

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        List<Range> ranges = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            ranges.add(new Range(x, y));
        }

        Collections.sort(ranges);

        Range startRange = ranges.get(0);
        int curS = startRange.start;
        int curE = startRange.end;
        int answer = 0;

        for (int i = 1; i < n ; i++) {
            Range r = ranges.get(i);

            if (curE >= r.start) {
                if (curE < r.end) curE = r.end;
            } else {
                answer += curE - curS;
                curS = r.start;
                curE = r.end;
            }
        }

        answer += curE - curS;

        System.out.println(answer);

    }

}

//  현재 끝 < 대상 시작 이라면 새로운집합
//  현재 끝 >= 대상 시작 이라면 합집합
