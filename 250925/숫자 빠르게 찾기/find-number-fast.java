import java.util.*;
public class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        Map<Integer,Integer> arrMap = new HashMap<>();
        int[] arr = new int[n+1];

        for (int i = 1; i <= n; i++){
            arr[i] = sc.nextInt();
            arrMap.put(arr[i],i);
        }
            

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            if (!arrMap.containsKey(x)) System.out.println(-1);
            else{
                System.out.println(arrMap.get(x));
            }

        }

    }
}