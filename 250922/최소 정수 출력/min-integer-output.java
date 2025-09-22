import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            if (x == 0) {
                int result = 0;
                if (pq.isEmpty()) System.out.println(result);
                else System.out.println(pq.poll());
                continue;
            }
            pq.add(x);
        }
    }
}