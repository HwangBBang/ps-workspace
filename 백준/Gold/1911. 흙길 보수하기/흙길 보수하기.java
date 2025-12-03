// package baekjoon.gold.solved;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

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

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        List<Range> ranges = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            ranges.add(new Range(x, y));
        }

        Collections.sort(ranges);


        int curEnd = 0;
        int answer = 0;

        for (int i = 0; i < n ; i++) {
            Range range = ranges.get(i);
            if (range.end <= curEnd) continue;

            int curStart = Math.max(range.start, curEnd);
            int leftLen = range.end - curStart;
            int cnt = (int)Math.ceil((double) leftLen / l);
            answer += cnt;
            curEnd = curStart + cnt * l;

        }

        System.out.println(answer);

    }

}


