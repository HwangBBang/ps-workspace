import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        
        // boolean[] points = new boolean[n+1];
        Set<Integer> points = new HashSet<>();

        for (int i = 0; i < n; i++) {
            // points[sc.nextInt()] = true;
            points.add(sc.nextInt());
        }

        int [] prefixCnt = new int[1_000_000+1];

        for (int i = 1; i <= 1_000_000; i ++){
            int next = 0;
            if (points.contains(i)){
                next = 1;
            }
            prefixCnt[i] = prefixCnt[i-1] + next;
        }

        for (int i = 0; i < q; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            // Please write your code here.
            int result = prefixCnt[b] - prefixCnt[Math.max(a-1,0)];
            System.out.println(result);
        }
    }
}

/*
n개의 점이 놓여져 있음
범위가 1 000 000이라 선형 배열에 저장시 터질 듯..? 
*/