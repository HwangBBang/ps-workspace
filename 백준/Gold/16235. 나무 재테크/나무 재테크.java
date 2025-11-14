// package baekjoon.gold;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int n,m,k;
    static int[][] current;
    static PriorityQueue<Tree>[][] grid;
    static final int[] dx = new int[]{0, 1, 1, 1, 0, -1, -1, -1};
    static final int[] dy = new int[]{1, 1, 0, -1, -1, -1, 0, 1};

    static class Tree implements Comparable<Tree> {
        int age;
        public Tree(int age) {
            this.age = age;
        }
        public int compareTo(Tree other) {
            return Integer.compare(age, other.age);
        }
    }

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        // 현재 양분
        current = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) Arrays.fill(current[i], 5);

        // 매년 추가되는 양분
        int[][] amount = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                amount[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 각 위치에 우선순위큐 세팅 (원활한 디버깅을 위해 For 문 분리)
        grid = new PriorityQueue[n + 1][n + 1]; // type : PriorityQueue<Tree>[][]
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                grid[i][j] = new PriorityQueue<>();
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int age = Integer.parseInt(st.nextToken());

            grid[x][y].add(new Tree(age));
        }

//      시뮬레이션 시작 (k 년 반복)
        for (int i = 0; i < k; i++) simulation(amount);

        System.out.println(countTree());
    }

    private static void simulation(int[][] amount) {

//        1-1. 자신의 나이만큼 양분을 먹는다. (나이 ++)
//        1-2. 해당 칸의 가장 어린 나무부터 (양분을 먹고 나이++), 양분을 먹지 못한다면 나무 사망
//        2. 사망한 나무는 양분이 된다. 양분 = (사망 나무 / 2) // *1-1.1-2 다 하고 해야해

        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++)
                use(i,j);

//        3. 인접 8칸에 나이1 짜리 나무를 추가한다.
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++)
                dupTree(i, j);

//        4. 주어진 양분을 추가한다.
        addAmount(amount);

    }

    private static void use(int x, int y) {
        int curAmount = current[x][y];
        PriorityQueue<Tree> trees = grid[x][y];
        PriorityQueue<Tree> nextTrees = new PriorityQueue<>();

        while (!trees.isEmpty()) {
            if (trees.peek().age <= curAmount) {
                Tree forUp = trees.poll();
                curAmount -= forUp.age;
                nextTrees.add(new Tree(forUp.age + 1));
            } else {
                break;
            }
        }
        current[x][y] = curAmount;
        grid[x][y] = nextTrees;

        int sum = 0;
        for (Tree dead : trees) {
            sum += (dead.age / 2);
        }
        current[x][y] += sum;

    }
    private static void dupTree(int x, int y) {
        for (Tree each : grid[x][y]) {
            if (each.age % 5 != 0) continue;
            for (int i = 0; i < dx.length; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (outOfRange(nx,ny)) continue;
                grid[nx][ny].add(new Tree(1));
            }
        }
    }
    private static void addAmount(int[][] amount) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                current[i][j] += amount[i][j];
            }
        }
    }
    private static boolean outOfRange(int x, int y) {
        return x < 1 || x > n || y < 1 || y > n;
    }
    private static int countTree() {
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                answer += grid[i][j].size();
            }
        }
        return answer;
    }
}


/*
    모든 땅의 초기값은 5
    m 개의 나무를 심는다.
    한칸에 여러나무가 존재 할 수 있다.

    반복 (K 번)
        1-1. 자신의 나이만큼 양분을 먹는다. (나이 ++)
        1-2. 해당 칸의 가장 어린 나무부터 (양분을 먹고 나이++), 양분을 먹지 못한다면 나무 사망
        2. 사망한 나무는 양분이 된다. 양분 = (사망 나무 / 2)
        3. 인접 8칸에 나이1 짜리 나무를 추가한다.
        4. 주어진 양분을 추가한다.

    각 격자 마다 우선순위 큐를 둔다 .(3D) 메모리 괜찮을까? 512MB

    현재 양분 : current
    매년 추가되는 양분 : amount
    위치별 나무의 존재 : grid

 */