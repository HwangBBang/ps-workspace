// package baekjoon.gold;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Computer {
        int grade;
        int num;
        int cost;

        public Computer(int grade,int num, int cost) {
            this.grade = grade;
            this.num = num;
            this.cost = cost;
        }
    }
    static int n;

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        int [] indegree = new int[n + 1];
        List<Computer>[] next = new ArrayList[n + 1];
        List<Computer> start = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            next[i] = new ArrayList<>();
        }

        List<Computer>[] byGrade = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) byGrade[i] = new ArrayList<>();

        int maxGrade = 0;

        for (int num = 1; num <= n; num++) {
            st = new StringTokenizer(br.readLine());
            int grade = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            Computer cur = new Computer(grade, num, cost);
            byGrade[grade].add(cur);

            if (grade != 1) {
                // grade-1 -> grade 로 가는 "다음 등급 리스트"에 등록
                next[grade - 1].add(cur);
            } else {
                start.add(cur);
            }
            maxGrade = Math.max(maxGrade, grade);
        }
        for (int g = 2; g <= maxGrade; g++) {
            int prevCnt = byGrade[g - 1].size(); // 바로 아래 등급 컴퓨터 수
            for (Computer c : byGrade[g]) {
                indegree[c.num] = prevCnt;
            }
        }

        int[] result = topologicalSort(indegree, next, start);
        int answer = 0;
        for (int each : result) {
            answer = Math.max(answer, each);
        }
        System.out.println(answer);
    }

    static int[] topologicalSort(int[] indegree, List<Computer>[] nexts, List<Computer> start) {

        Queue<Computer> que = new ArrayDeque<>();
        int[] dpTime = new int[n + 1];
        for (Computer each : start) {
            dpTime[each.num] = each.cost;
            que.add(each);
        }

        int answer = 0;

        while (!que.isEmpty()) {
            Computer cur = que.poll();
            answer = Math.max(answer, dpTime[cur.num]);
            for (Computer next : nexts[cur.grade]) {
                int diff = cur.num - next.num;
                int transTime = diff * diff;

                dpTime[next.num] = Math.max(dpTime[next.num], dpTime[cur.num] + transTime + next.cost);
                indegree[next.num]--;
                if (indegree[next.num] == 0) {
                    que.add(next);
                }
            }
        }


        return dpTime;
    }
}
