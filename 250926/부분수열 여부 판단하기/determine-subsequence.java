import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st; 
        
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] A = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        int[] B = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            B[i] = Integer.parseInt(st.nextToken());
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
