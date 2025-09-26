import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        int[] B = new int[m];
        for (int i = 0; i < m; i++) {
            B[i] = sc.nextInt();
        }
        String answer = isSub(A,B) ? "Yes" : "No";

        System.out.println(answer);
    }

    static boolean isSub(int []superSet, int []subSet){
        int i = 0, j = 0;
        int superLen = superSet.length, subLen = subSet.length;

        while(i < superLen && j < subLen){
            if (superSet[i] == subSet[j]) j ++;
            i++;
        }

        return j == subLen;
    }
}
