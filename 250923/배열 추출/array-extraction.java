import java.util.*;

public class Main {
    public static void main(String[] args) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(5, (a,b)-> Integer.compare(b,a));

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            if (x != 0){
                if (pq.size() < 5) pq.add(x);
                else {
                    if (pq.peek() > x) continue;
                    else pq.add(x);
                }
                continue;
            }
            int result = 0;
            if (!pq.isEmpty()) {
                result = pq.poll();
            }
            System.out.println(result);

        }
    }
}