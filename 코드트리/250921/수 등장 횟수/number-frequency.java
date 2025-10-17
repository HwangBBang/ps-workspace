import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        int[] arr = new int[n]; // 원소
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] queries = new int[m]; // 질의 수 
        for (int i = 0; i < m; i++) {
            queries[i] = sc.nextInt();
        }
        // Please write your code here.

        Map<Integer, Integer> map = new HashMap<>();
        for (int elem : arr){
            map.put(elem, map.getOrDefault(elem,0)+1);
        }

        int [] answers = new int[queries.length];
        for (int i = 0; i <queries.length; i++ ){
            answers[i] = map.getOrDefault(queries[i],0);
        }

        for (int answer : answers){
            System.out.print(answer + " ");
        }
        System.out.println();
        
    }
}