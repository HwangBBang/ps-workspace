import java.util.*;
import java.io.*;

public class Main {
    static int[] arr1,arr2;
    public static class Pair implements Comparable<Pair>{
        private int x,y; 
        public int sum; 
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
            this.sum = arr1[x] + arr2[y];
            
        }
        @Override 
        public int compareTo(Pair other){
            return Integer.compare(this.sum , other.sum);
        }
        @Override
        public String toString(){
            return String.valueOf(this.sum);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        arr1 = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr1[i] = Integer.parseInt(st.nextToken());
        
        arr2 = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) arr2[i] = Integer.parseInt(st.nextToken());
        
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        PriorityQueue<Pair> minHeap = new PriorityQueue<>(); 
        for (int i = 0; i < n; i++){
            minHeap.add(new Pair(i,0));
        }

        String answer = "";
        for (int j = 0; j < k; j++){
            Pair current = minHeap.poll();
            if (j == k-1) answer = current.toString();

            if (current.y + 1 < m){
                minHeap.add(new Pair(current.x,current.y+1));
            }
        }

        System.out.println(answer);
    }
}

/*

모든 케이스 다하면 무조건 터진다. 10 ^ 12 까지 이니,, 

pq 내부에 넣으면 k 번째를 알 수 있다.
왜? k-1 번째 것까지 제거하면되니까.

  K-1개 까지 | peek -> 정답
{MAX_HEAP} | {MIN_HEAP} 


1 2 3 6 7
1 5 7 8

(1,1), (2,1)

1.	두 배열 A, B를 오름차순 정렬합니다.
2.	각 i(0 ≤ i < n)에 대해 “행” L_i = { A[i]+B[0], A[i]+B[1], ... } 는 오름차순입니다.
3.	k번째 합은 결국 이 N개의 정렬 리스트를 머지하면서 앞에서부터 k개 뽑은 마지막 값입니다.
4.	따라서 PQ(최소 힙)에 초기에는 (i,0) 만 넣습니다. (i는 0..min(n-1, k-1))
	•	이유: i ≥ k인 행의 첫 원소 A[i]+B[0]는 A[0..k-1]+B[0]의 최소 k개보다 작을 수 없습니다.
5.	힙에서 하나 꺼낼 때마다 그 원소가 (i, j)였다면, 같은 행의 다음 원소 (i, j+1)만 추가합니다.
	•	이렇게 하면 항상 “각 행에서 아직 안 뽑힌 최소 후보”만 힙에 존재 → 전역 최소를 올바르게 뽑아 나갈 수 있습니다.

시간복잡도: O(k log min(n, k)), 공간복잡도: O(min(n, k)).
*/