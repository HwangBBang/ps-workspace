import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Integer> answer = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;
    static int[] candidates;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n];
        candidates = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            candidates[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(candidates);
        choice(0);
        System.out.println(sb);
        // 1 7 9 9
    }

    protected static void choice(int depth) {
        if (depth == m) {
            for (int s : answer) {
                sb.append(s).append(" ");
            }
            sb.append("\n");
            return;
        }

        int sameDepthValue = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            if (sameDepthValue == candidates[i]) continue;

            visited[i] = true;
            answer.add(candidates[i]);
            choice(depth + 1);
            answer.remove(answer.size() - 1);
            visited[i] = false;
            sameDepthValue = candidates[i];

        }
    }
}
