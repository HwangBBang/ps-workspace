import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }
        // Please write your code here.
        Map <String, Integer> map = new HashMap<>();

        for (String elem : arr){
            map.put(elem, map.getOrDefault(elem,0)+1);
        }
        

        int answer = 0;
        for (int elem : map.values()){
            if(answer < elem) answer = elem;            
        }

        System.out.println(answer);

    }
}