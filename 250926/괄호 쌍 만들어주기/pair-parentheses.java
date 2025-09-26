import java.util.Scanner;

public class Main {    
    public static final int MAX_N = 100000;
    
    // 변수 선언
    public static int n;
    public static String str;
    public static int[] R = new int[MAX_N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력:
        str = sc.next();
        n = str.length();
        
        // R 배열을 채워줍니다.
        // Ri = i번지부터 N - 1번지 까지 있는 문자열중에 
        //      연속하여 ))가 나오는 횟수
        R[n - 1] = 0;
        for(int i = n - 2; i >= 0; i--) {
            // i, i + 1로 )) 조합이 만들어진다면
            // i번부터 만들 수 있는 조합 수가 1만큼 더 늘어납니다.
            if(str.charAt(i) == ')' && str.charAt(i + 1) == ')')
                R[i] = R[i + 1] + 1;
            // 그렇지 않다면, i + 1번부터 만들 수 있는 조합 수와 같습니다.
            else
                R[i] = R[i + 1];
        }
        
        // 답을 구해줍니다.
        // 현재 i, i + 1 조합과
        // 쌍을 이루는 서로 다른 가짓수를 세어
        // 답에 더해줍니다.
        long ans = 0;
        for(int i = 0; i < n - 2; i++) {
            if(str.charAt(i) == '(' && str.charAt(i + 1) == '(')
                ans += R[i + 2];
        }
        
        System.out.print(ans);
    }
}
