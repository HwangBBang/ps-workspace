import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            minHeap.offer(Integer.parseInt(st.nextToken()));
        }
        int result = 0;
        for (int i = 0; i < k; i++) {
            if (!minHeap.isEmpty()) {
                result = minHeap.poll();
            }
        }
        System.out.println(result);
    }
}
