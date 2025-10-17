import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        
        HashMap<Integer,Integer> map = new HashMap<>();


        int[] points = new int[n];
        for (int i = 0; i < n; i++) {
            points[i] = sc.nextInt();
        }
        Arrays.sort(points);

        for (int i = 0; i < n; i++) map.put(points[i],i+1);

        
        int[][] queries = new int[q][2];
        for (int i = 0; i < q; i++) {
            queries[i][0] = sc.nextInt();
            queries[i][1] = sc.nextInt();


            int a = map.get(queries[i][0]);
            int b = map.get(queries[i][1]);
            System.out.println(b-a+1);
        }
        // Please write your code here.
    }
}

// 1_000_000
// 1_000_000_000