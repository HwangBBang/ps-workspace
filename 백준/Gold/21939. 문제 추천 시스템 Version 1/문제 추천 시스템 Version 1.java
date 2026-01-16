// package baekjoon.gold;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static class Problem implements Comparable<Problem> {
        int num;
        int level;

        public Problem(int num, int level) {
            this.num = num;
            this.level = level;
        }

        @Override
        public int compareTo(Problem other) {
            if (other.level != this.level) {
                return Integer.compare(this.level, other.level);
            } else {
                return Integer.compare(this.num, other.num);
            }
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) return true;
            if (!(other instanceof Problem)) return false;
            Problem problem = (Problem) other;
            // 여기서 problem 필드 비교
            return num == problem.num && level == problem.level;
        }

        @Override
        public int hashCode() {
            return Objects.hash(num, level);
        }
    }


    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        //      LEVEL, Problems

        TreeSet<Problem> problems = new TreeSet<>();
        // NUM , LEVEL
        TreeMap<Integer,Integer> map = new TreeMap<>();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int level = Integer.parseInt(st.nextToken());
            problems.add(new Problem(num, level));
            map.putIfAbsent(num, level);
        }

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            String cmd = st.nextToken();
            if (cmd.equals("add")) {
                int num = Integer.parseInt(st.nextToken());
                int level = Integer.parseInt(st.nextToken());

                problems.add(new Problem(num, level));
                map.putIfAbsent(num, level);

            } else if (cmd.equals("solved")) {
                int num = Integer.parseInt(st.nextToken());
                int level = map.get(num);
                problems.remove(new Problem(num, level));
                map.remove(num);

            } else if (cmd.equals("recommend")) {
                int order = Integer.parseInt(st.nextToken());
                if (order == 1) {
                    Problem last = problems.last();
                    sb.append(last.num);

                } else {
                    Problem first = problems.first();
                    sb.append(first.num);
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }



}
