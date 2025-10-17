import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            int num = sc.nextInt();
            if (map.containsKey(num)){
                continue;
            }
            map.put(num, i);
        }

        int[] queries = new int[m];
        for (int i = 0; i < m; i++) {
            int num = sc.nextInt();
            int result = map.getOrDefault(num,-1);
            System.out.println(result);
        }
    }
}