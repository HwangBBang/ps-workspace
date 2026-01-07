// package baekjoon.gold;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static TreeSet<Integer> tree;
    public static void main(String[] args) throws IOException {
//         System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        tree = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            tree.add(Integer.parseInt(br.readLine()));
        }

        int lowest = tree.first();
        int highest = tree.last();

        int maxDiff = highest - lowest;
        int minDiff = 1;
        int curDiff = 0;

        int answer = -1;

        while (minDiff <= maxDiff) {
            curDiff = (maxDiff + minDiff) / 2;
            if (canMake(lowest, curDiff, c)) {
                answer = Math.max(answer, curDiff);
                minDiff = curDiff + 1;
            } else {
                maxDiff = curDiff - 1;
            }

        }
        System.out.println(answer);
    }

    static boolean canMake(int cur, int diff, int cap) {
        int cnt = 1; // start

        while (true) {
            if (cap == cnt) return true;
            Integer find = tree.ceiling(cur + diff);
            if (find != null) {
                cnt++;
                cur = find;
                continue;
            }
            break;
        }

        return false;
    }
}

/*
    매번 가장 먼거 선택? -> X
    거리를 증가시키며 불가능할 때 까지? -> 10억 까지라 이건 X
    근데 이 선형 증가 탐색을 -> 이분 탐색으로 바꾼다면 ? 
*/