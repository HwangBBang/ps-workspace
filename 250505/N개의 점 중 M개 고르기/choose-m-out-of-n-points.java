import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static List<Position> positions = new ArrayList<>();
    static List<Position> selected = new ArrayList<>();
    static int answer = Integer.MAX_VALUE;

    static class Position {
        int x, y;
        Position(int x, int y) { this.x = x; this.y = y; }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            positions.add(new Position(
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
            ));
        }

        choose(0, 0);
        System.out.println(answer);
    }

    // start: 다음에 고를 인덱스, depth: 지금까지 고른 수
    static void choose(int start, int depth) {
        if (depth == m) {
            // 선택된 m개의 점 중 가장 먼 두 점 사이 거리(제곱)
            int maxDist = 0;
            for (int i = 0; i < m; i++) {
                for (int j = i + 1; j < m; j++) {
                    maxDist = Math.max(maxDist, getDist(selected.get(i), selected.get(j)));
                }
            }
            answer = Math.min(answer, maxDist);
            return;
        }
        for (int i = start; i < n; i++) {
            selected.add(positions.get(i));
            choose(i + 1, depth + 1);
            selected.remove(selected.size() - 1);
        }
    }
    
    static int getDist(Position p1, Position p2) {
        int dx = p1.x - p2.x;
        int dy = p1.y - p2.y;
        return dx * dx + dy * dy;
    }
}
