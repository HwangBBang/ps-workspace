import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int j = 0;
        int sum = 0;
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++){
            
            while(j < n && sum < s){
                sum += arr[j++];
            }

            int len = j - i;
            if (sum >= s) answer = Math.min(answer, len);

            sum -= arr[i];
        }

        answer = answer == Integer.MAX_VALUE ? -1 : answer;
        System.out.println(answer);

    }
}