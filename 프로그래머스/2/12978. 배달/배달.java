import java.util.*;

class Solution {
    static public class Edge{
        int to;
        int cost;
        
        public Edge(int to, int cost){
            this.to = to;
            this.cost = cost;
        }
        
    }
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        
        List<Edge>[] graph = new ArrayList[N+1];
        for (int i = 0; i <= N; i ++){
            graph[i] = new ArrayList<>();
        }
        
        for (int[] each : road){
            graph[each[0]].add(new Edge(each[1],each[2]));
            graph[each[1]].add(new Edge(each[0],each[2]));
        }
        
        // 정점까지의 거리를 나타내는 배열
        int[] minDist = new int[N+1];
        Arrays.fill(minDist,Integer.MAX_VALUE);
        
        // {거리, 정점} 최소 힙
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> a[0] - b[0]
        );
        
        // 시작점 설정 (시작점은 1 이니까 0)
        minDist[1] = 0;
        pq.add(new int[]{0,1});
        
        while (!pq.isEmpty()){
            int[] polled = pq.poll(); 
            int curCost = polled[0];
            int nodeNum = polled[1];
            if (curCost != minDist[nodeNum]) continue; // 최신 값이 아니면 버림 
            
            // 인접 거리 갱신
            List<Edge> nextEdges = graph[nodeNum]; 
            for (Edge e : nextEdges){
                int nextNodeNum = e.to;
                int nextNodeCost = e.cost + curCost;
                
                // minDist 갱신
                if (nextNodeCost < minDist[nextNodeNum]){
                    minDist[nextNodeNum] = nextNodeCost;
                    pq.add(new int[]{nextNodeCost, nextNodeNum}); 
                }
                
            }
            
        }
        for(int i = 1; i <= N; i++){
            if (minDist[i] <= K) answer ++;
        }

        return answer;
    }
}

/*
 다익스트라는 크게 4단계.
        1. 그래프 구축
        2. 거리배열, 우선순위 큐 초기화 
        3. 메인 루프 
        4. 정답 계산 
*/