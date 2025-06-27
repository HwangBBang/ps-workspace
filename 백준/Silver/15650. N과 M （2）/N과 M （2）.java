import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static List<Integer> stack;
    //     재귀함수를 이용하면, 순열과 조합을 만들 수 있다 . ( 백 트랙킹 )
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        stack = new ArrayList<>();
        for (int i = 1; i <= n; i++){
            stack.add(i);
            choice(1);
            stack.clear();
        }

    }
    /*
    * 1
    * 1 1
    * 1 1 1
    * 1 1
    * 1 1 2
    * 1 1
    * 1 1 3
    * 1 1
    * */

    static void choice(int cnt){
        if (cnt >= m) {
            // 출력
            printLine(stack);
            return;
        }
        int startNum = stack.get(stack.size()-1);
        for (int i = startNum; i <= n; i++) {
            if (stack.contains(i)) continue;
            stack.add(i);
            choice(cnt + 1);
            stack.remove(stack.size()-1);
        }



    }

    static void printLine(List<Integer> line){
        for (Integer elem : line) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }
}
