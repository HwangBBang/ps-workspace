
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/beakjun/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] B = new int[m + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= m; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        int[] prefixA = new int[n + 1];
        for (int i = 1; i <= n; i++)  prefixA[i] = prefixA[i - 1] + A[i];
        

        int[] prefixB = new int[m + 1];
        for (int i = 1; i <= m; i++) prefixB[i] = prefixB[i - 1] + B[i];
        

        int[] caseA = new int[((n+1)*n)/2];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j <= n; j++) {
                caseA[idx++] = prefixA[j] - prefixA[i];
            }
        }
        int[] caseB = new int[((m+1)*m)/2];
        idx = 0;
        for (int i = 0; i < m; i++) {
            for (int j = i+1; j <= m; j++) {
                caseB[idx++] = prefixB[j] - prefixB[i];
            }
        }

        Arrays.sort(caseA);
        Arrays.sort(caseB);

        long answer = 0;
        int pa = 0, pb = caseB.length - 1;
        while (pa < caseA.length && pb >= 0) {
            if (caseA[pa] + caseB[pb] == t){
                int tempA = caseA[pa];
                int tempB = caseB[pb];

                long cntA = 0;
                while (pa < caseA.length && caseA[pa] == tempA) {
                    cntA ++; pa++;
                }
                long cntB = 0;
                while (pb >= 0 && caseB[pb] == tempB) {
                    cntB ++; pb--;
                }

                answer += cntA * cntB;
            }
            else if (caseA[pa] + caseB[pb] > t)
                pb--;
            else
                pa++;
        }


        System.out.println(answer);

    }
}

/*

1,000,000,000

1,000,000 * 1000 => 1_000_000_000 -> int 로도 충분

* */