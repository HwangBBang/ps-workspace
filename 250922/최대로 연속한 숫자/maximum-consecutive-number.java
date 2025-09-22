import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        TreeSet<Integer> tree = new TreeSet<>();
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            tree.add(Integer.parseInt(st.nextToken()));

            int result = solution(tree, n);
            
            System.out.println(result);
        }

    }

    static int solution(TreeSet<Integer> tree, int n){
        if (tree.isEmpty()) return n + 1;

        int maxLen = 0;
        Integer first = tree.first();
        
        // 첫 구간 
        if(first > 0){
            maxLen = Math.max(maxLen, first);
        }
        // 중간 구간들 
        Integer prev = null;
        for (Integer curr : tree){
            if (prev != null){
                int eachLen = curr - prev - 1;
                maxLen = Math.max(maxLen, eachLen);
            }
            prev = curr;
        }

        // 마지막 구간 
        Integer last = tree.last();
        if(last < n){
            maxLen = Math.max(maxLen, n - last);
        }
        return maxLen;
    }
}
/*

    N이 최대 10^9라서 전체 배열을 들고 있는 건 불가. 매번 선형으로 훑는 것도 불가.
    
    지워진 수들의 위치에 의해서만 결정 -> 최장 구간 결정 
    0 1 2 3 4 5 6 7 8 / 8

    0 1 2   4 5 6 7 8 / 5
    3을 끊어 버리면, 3과 연결된 2,4 서브셋을 순회해서 서브셋 크기 카운트 ??

    0 1 2   4 5   7 8 / 3

    0 1     4 5   7 8 / 2

    [0] 2 3 6 [n] 끊어진 부분 

    길이 n (8)
    
*/
