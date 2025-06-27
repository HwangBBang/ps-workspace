import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static List<Integer> stack = new ArrayList<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        choice(0);
    }

    static void choice(int cnt) {
        if (cnt >= m) {
            printLine(stack);
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (stack.contains(i)) continue;
            stack.add(i);
            choice(cnt + 1);
            stack.remove(stack.size() - 1);
        }
    }


    static void printLine(List<Integer> line){
        for (Integer elem : line) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }
}
