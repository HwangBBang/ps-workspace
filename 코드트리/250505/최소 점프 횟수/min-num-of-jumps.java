import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int answer = 999;
    static int[] grid;
    static List<Integer> queue = new ArrayList<>();
    static List<List<Integer>> answers = new ArrayList<>();

    //     재귀함수를 이용하면, 순열과 조합을 만들 수 있다 . ( 백 트랙킹 )
    // 후보 : queue 에 담겨 있음 (자리수)
    // 범위 :
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        grid = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            grid[i] = Integer.parseInt(st.nextToken());
        }

//        grid  의 값은 "최대" 점프 범위
//        grid 의 값이 선택지 의 범위
//        자리수가 최소가 되도록..
//        수많은 케이스를 보관하자.
//        보관 후 가장 짧은 자리수를 출력하자

        choice(0);
        getAnswer(answers);

        if (answer == 999) {
            System.out.println(-1);

        } else {
            System.out.println(answer);
        }
    }

    static void choice(int idx) {
        if (idx >= grid.length-1) {
            answers.add(new ArrayList<>(queue));
            return;
        }

        for (int i = grid[idx]; i > 0; i--) {
            queue.add(grid[idx]);
            choice(idx + i);
            queue.remove(queue.size() - 1);
        }
    }

    static void getAnswer(List<List<Integer>> result) {
        for (List<Integer> line : result) {
            answer = Math.min(answer, line.size());
        }
    }
}
