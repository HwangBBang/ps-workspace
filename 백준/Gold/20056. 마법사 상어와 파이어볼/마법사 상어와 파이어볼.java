// package baekjoon.gold;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.Key;
import java.util.*;


public class Main {
    static int n, m, k;            // 0   1  2  3  4   5   6   7
    static final int[] dx = new int[]{-1, -1, 0, 1, 1, 1, 0, -1};
    static final int[] dy = new int[]{0, 1, 1, 1, 0, -1, -1, -1};
    static Queue<FireBall> balls;
    static HashMap<Integer, ArrayDeque<FireBall>> map;

    static class FireBall {
        int r, c;
        int m, d, s;

        public FireBall(int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        balls = new ArrayDeque<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            balls.add(new FireBall(r, c, m, s, d));
        }

        for (int i = 0; i < k; i++) {
            simulation();
            setBalls();
        }
        int answer = getAnswer();
        System.out.println(answer);
    }

    static void setBalls() {
        for (int key : map.keySet()){
            ArrayDeque<FireBall> each = map.get(key);
            if (each.isEmpty()) continue;
            for (FireBall at : each) {
                balls.add(at);
            }
        }

    }
    static int getAnswer() {
        int result = 0;
        for (int key : map.keySet()) {
            ArrayDeque<FireBall> each = map.get(key);
            if (each.isEmpty()) continue;
            for (FireBall at : each) {
                result += at.m;
            }
        }
        return result;
    }

    static void simulation() {
        map = new HashMap<>();
        while (!balls.isEmpty()) {

            FireBall cur = balls.poll();
            int nextR = cur.r + dx[cur.d] * cur.s;
            int nextC = cur.c + dy[cur.d] * cur.s;
            nextR = cal(nextR);
            nextC = cal(nextC);
            int key = makeKey(nextR, nextC);
            FireBall next = new FireBall(nextR, nextC, cur.m, cur.s, cur.d);
            if (!map.containsKey(key)) map.put(key, new ArrayDeque<>());
            map.get(key).add(next);

        }

        for (int key : map.keySet()) {
            if (map.get(key).size() < 2) continue;
            ArrayDeque<FireBall> curBalls = map.get(key);
            int r = key / 100;
            int c = key % 100;
            int totalCnt = curBalls.size();
            int totalM = 0;
            int totalS = 0;

            Set<Boolean> isEven = new HashSet<>();
            while (!curBalls.isEmpty()) {
                FireBall cur = curBalls.poll();
                totalM += cur.m;
                totalS += cur.s;
                isEven.add(cur.d % 2 == 0);
            }


            int nextM = (int) Math.floor(totalM / 5);
            if (nextM == 0) continue;
            int nextS = (int) Math.floor(totalS / totalCnt);
            int startIDX = isEven.size() == 1 ? 0 : 1;
            for (int i = startIDX; i < dx.length; i += 2) {
                map.get(key).add(new FireBall(r, c, nextM, nextS, i));
            }
        }

    }

    static int makeKey(int r, int c) {
        return r * 100 + c;
    }

    static int cal(int t) {
        return ((t - 1) % n + n) % n + 1;
    }
}

/*

 i번 파이어볼의 위치는 (ri, ci), 질량은 mi이고, 방향은 di, 속력은 si이다
 1번 행은 N번과 연결되어 있고, 1번 열은 N번 열과 연결되어 있다.
 범위를 넘어가면 사이클로,,
 n 은 50이하
 __ __
 n = 4
 0 1 2 3
 1 2 3 4

*/