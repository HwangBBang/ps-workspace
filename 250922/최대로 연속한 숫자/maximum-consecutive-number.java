import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        TreeSet<Integer> removed = new TreeSet<>();
        st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            removed.add(num);
            
            // 현재 상태에서 최장 연속 구간 계산
            int maxLen = calculateMaxLength(removed, n);
            System.out.println(maxLen);
        }
    }
    
    static int calculateMaxLength(TreeSet<Integer> removed, int n) {
        if (removed.isEmpty()) {
            return n;
        }
        
        int maxLen = 0;
        
        // 첫 번째 구간: 0부터 첫 번째 제거된 수 전까지
        Integer first = removed.first();
        if (first > 0) {
            maxLen = Math.max(maxLen, first);
        }
        
        // 마지막 구간: 마지막 제거된 수 다음부터 n까지
        Integer last = removed.last();
        if (last < n) {
            maxLen = Math.max(maxLen, n - last);
        }
        
        // 중간 구간들: 연속된 제거된 수들 사이의 구간
        Integer prev = null;
        for (Integer curr : removed) {
            if (prev != null) {
                int gapLen = curr - prev - 1;
                maxLen = Math.max(maxLen, gapLen);
            }
            prev = curr;
        }
        
        return maxLen;
    }
}