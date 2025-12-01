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
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        List<List<Integer>> grid = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            grid.add(new ArrayList<>());
            for (int j = 0; j < 3; j++) {
                grid.get(i).add(Integer.parseInt(st.nextToken()));
            }
        }

        int answer = 0;
        boolean flag = false;
        while (answer <= 100) {
            if (r - 1 < grid.size()
                    && c - 1 < grid.get(r - 1).size()
                    && grid.get(r - 1).get(c - 1) == k) {
                flag = true;
                break;
            }
            int rCnt = grid.size();
            int cCnt = getcCnt(grid);

            if (rCnt >= cCnt) {
                grid = rSimulation(grid, rCnt, cCnt);
            } else {
                grid = cSimulation(grid, rCnt, cCnt);

            }
            answer++;
        }

        answer = flag ? answer : -1;
        System.out.println(answer);
    }

    static List<List<Integer>> rSimulation(List<List<Integer>> grid, int rCnt, int cCnt) {
        List<List<Integer>> sortedRows = new ArrayList<>();
        int maxLen = 0;

        for (int i = 0; i < rCnt; i++) {
            List<Integer> sorted = sortLine(grid.get(i));
            sortedRows.add(sorted);
            maxLen = Math.max(maxLen, sorted.size());
        }

        // 길이 상한 100
        maxLen = Math.min(maxLen, 100);

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < rCnt; i++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> sorted = sortedRows.get(i);
            for (int j = 0; j < maxLen; j++) {
                if (j < sorted.size()) row.add(sorted.get(j));
                else row.add(0);
            }
            result.add(row);
        }
        return result;
    }

    static List<List<Integer>> cSimulation(List<List<Integer>> grid, int rCnt, int cCnt) {
        List<List<Integer>> sortedCols = new ArrayList<>();
        int maxLen = 0;

        // 각 열에 대한 정렬 수행
        for (int j = 0; j < cCnt; j++) {
            List<Integer> col = new ArrayList<>();
            for (int i = 0; i < rCnt; i++) {
                if (j < grid.get(i).size()) col.add(grid.get(i).get(j));
                else col.add(0);
            }
            List<Integer> sorted = sortLine(col);
            sortedCols.add(sorted);
            maxLen = Math.max(maxLen, sorted.size());
        }

        // 길이 상한 100
        maxLen = Math.min(maxLen, 100);

        // 열 기준 정렬 결과를 다시 행 기준 2차원 리스트로 변환
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < maxLen; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < cCnt; j++) {
                List<Integer> sorted = sortedCols.get(j);
                if (i < sorted.size()) row.add(sorted.get(i));
                else row.add(0);
            }
            result.add(row);
        }
        return result;
    }

    static int getcCnt(List<List<Integer>>grid) {
        int cCnt = 0;
        for (List<Integer> line : grid) {
            cCnt = Math.max(cCnt, line.size());
        }
        return cCnt;
    }
    static List<Integer> sortLine(List<Integer> line) {
        List<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int each : line) {
            if (each == 0) continue;
            map.put(each, map.getOrDefault(each, 0) + 1);
        }
        
        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(map.entrySet());
        Collections.sort(entries, (a, b) -> {
            if (a.getValue() != b.getValue())
                return Integer.compare(a.getValue(), b.getValue());
            else
                return Integer.compare(a.getKey(), b.getKey());
            }
        );

        for (Map.Entry<Integer, Integer> each : entries) {
            result.add(each.getKey()); // 수
            result.add(each.getValue()); // 갯수
            if (result.size() >= 100) break;
        }

        return result;
    }

}


/*
    R 연산: 배열 A의 모든 행에 대해서 정렬을 수행한다. 행의 개수 ≥ 열의 개수인 경우에 적용된다.
    C 연산: 배열 A의 모든 열에 대해서 정렬을 수행한다. 행의 개수 < 열의 개수인 경우에 적용된다.

    정렬,
    1. 수의 등장 횟수가 커지는 순,
    2. 수가 커지는 순으로 정렬.

    그 다음에는 배열 A에 정렬된 결과를 다시 넣어야 한다.

    정렬된 결과를 배열에 넣을 때는, 수와 등장 횟수를 모두 넣으며, 순서는 수가 먼저이다.

    [3, 1, 1]에는 3이 1번, 1가 2번 등장한다.
    [3, 1, 1, 2]가 된다.

    다시 이 배열에는 3이 1번, 1이 2번, 2가 1번 등장한다.
    다시 정렬하면 [2, 1, 3, 1, 1, 2]가 된다.
*/
