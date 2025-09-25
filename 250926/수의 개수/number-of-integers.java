import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<Integer, Integer> map = new HashMap<>();
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        // int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            // arr[i] = sc.nextInt();
            int num = sc.nextInt();
            map.put(num, map.getOrDefault(num,0) + 1); 
        }
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int result = map.getOrDefault(x,0);
            System.out.println(result);

        }
    }
}

// 2 2 5 7 7 7 9 10
