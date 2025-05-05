import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int n,m, answer;
    static List<Position> queue = new ArrayList<>();
    static List<Position> answerQueue = new ArrayList<>();
    static List<Position> positions = new ArrayList<>();
    static Pair answerPair;

    static class Position {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Pair {
        Position p1;
        Position p2;

        public Pair(Position p1, Position p2) {
            this.p1 = p1;
            this.p2 = p2;
        }
    }

    //     재귀함수를 이용하면, 순열과 조합을 만들 수 있다 . ( 백 트랙킹 )
    // 후보 : queue 에 담겨 있음 (자리수)
    // 범위 :
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
             positions.add(new Position(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        answer = Integer.MAX_VALUE;

        choice(1);
        System.out.println(getDist(answerPair.p1, answerPair.p2));

    }

    static void choice(int num) {
        if (num > m) {
//            queue 에 담겨 있는 pos 중 가장 먼거 찾아내기
            findFar(1);
            return;
        }

        for (Position position : positions) {
            if (isQueueValid(position)) {
                queue.add(position);
                choice(num + 1);
                queue.remove(queue.size() - 1);
            }
        }
    }

    static void findFar(int num) {
        if (num > 2) {
    //  queue 에 담겨 있는 pos 중 가장 먼거 찾아내기
            int dist = getDist(answerQueue.get(0), answerQueue.get(1));
            if (dist < answer) {
                answer = dist;
                answerPair = new Pair(answerQueue.get(0), answerQueue.get(1));
            }

            return;
        }

        for (Position position : queue) {
            if (isAnswerQueueValid(position)) {
                answerQueue.add(position);
                findFar(num + 1);
                answerQueue.remove(answerQueue.size() - 1);
            }
        }
    }

    static int getDist(Position p1, Position p2) {
        return (int) Math.pow(Math.sqrt((double) (p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y)), 2.0);
    }

    static boolean isQueueValid(Position position) {
            for (Position exist : queue) {
                if (exist.equals(position)) {
                    return false;
                }
            }
            return true;
        }

    static boolean isAnswerQueueValid(Position position) {
        for (Position exist : answerQueue) {
            if (exist.equals(position)) {
                return false;
            }
        }
        return true;
    }
}



/*

3 3
97 42
37 60
37 62

=> 4000
 */

