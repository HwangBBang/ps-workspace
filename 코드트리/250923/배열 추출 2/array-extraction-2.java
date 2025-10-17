import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        PriorityQueue<Integer> pq 
        = new PriorityQueue<>((a,b) -> {
            if (Math.abs(a) != Math.abs(b)) 
                return Integer.compare(Math.abs(a),Math.abs(b));
            else 
                return Integer.compare(a,b);
            });

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            if (x != 0) {
                pq.add(x); continue;
            }
            Integer result;
            result = pq.isEmpty() ? 0 : pq.poll();
            System.out.println(result);
            
        }
    }
}