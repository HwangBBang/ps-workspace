import java.util.*;
public class Main {
    public static void main(String[] args) {

        HashSet<Integer> set = new HashSet<>();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        int answer = Integer.MIN_VALUE;

        int j = 0;
        for (int i = 0; i < n; i++){
            while (j < n && !set.contains(arr[j])){
                set.add(arr[j++]);
            }
            int len = j-i;
            // System.out.println("i:"+ i + " " + "j:"+ j);
            answer = Math.max(answer, len);

            set.remove(arr[i]);
        }

        System.out.println(answer);
    }
}