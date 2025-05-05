import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n,m;
    static List<Integer> queue = new ArrayList<>();
    static List<List<Integer>> answers = new ArrayList<>();

    //     재귀함수를 이용하면, 순열과 조합을 만들 수 있다 . ( 백 트랙킹 )
    // 후보 : queue 에 담겨 있음 (자리수)
    // 범위 :
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m =Integer.parseInt(st.nextToken());

        choice(1);

        for (List<Integer> answer : answers) {
            print(answer);
        }
    }

    static void choice(int num) {
        if (num > m) {
            answers.add(new ArrayList<>(queue));
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (isValid(i)) {
                queue.add(i);
                choice(num + 1);
                queue.remove(queue.size() - 1);
            }
        }
    }

    static boolean isValid(int addNum) {
        int len = queue.size();

        for (int i = len - 1; i >= 0; i--) {
            if (queue.get(i) >= addNum) {
                return false;
            }
        }
        return true;
    }

    static void print(List<Integer> line) {
        for (Integer i : line) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
