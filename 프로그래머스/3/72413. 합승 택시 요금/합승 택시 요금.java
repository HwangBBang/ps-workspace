import java.util.*;

class Solution {
    static List<Edge>[] graph;
    public static class Edge{
        int to;
        int cost;

        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    public static class Node{
        int num;
        int cost;

        public Node(int num, int cost) {
            this.num = num;
            this.cost = cost;
        }
    }
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        graph = new ArrayList[n+1];
        for (int i = 0; i <= n; i ++){
            graph[i] = new ArrayList<>();
        }
        for (int[] fare : fares){
            graph[fare[0]].add(new Edge(fare[1],fare[2]));
            graph[fare[1]].add(new Edge(fare[0],fare[2]));
        }

        int[] distS = dijkstra(n,s);
        int[] distA = dijkstra(n,a);
        int[] distB = dijkstra(n,b);

        for(int k = 1; k <= n; k++){
            int sum = 0 + distS[k] + distA[k] + distB[k];
            if (sum < answer) answer = sum;
        }

        return answer;   
    }
    
    public static int[] dijkstra(int n, int start){
        PriorityQueue<Node> pq = new PriorityQueue<>((x,y) -> Integer.compare(x.cost,y.cost));
        int [] minDist = new int [n+1];
        Arrays.fill(minDist, Integer.MAX_VALUE);

        // 출발 세팅
        minDist[start] = 0;
        pq.add(new Node(start,0));

        while (!pq.isEmpty()){
            Node polled = pq.poll();
            int curCost = polled.cost;
            int curNode = polled.num;

            if (minDist[curNode] != curCost) continue;
            List<Edge> nextEdges = graph[curNode];
            for (Edge e : nextEdges) {
                int nextNodeNum = e.to;
                int nextNodeCost = e.cost + curCost;

                if(nextNodeCost < minDist[nextNodeNum]){
                    minDist[nextNodeNum] = nextNodeCost;
                    pq.add(new Node(nextNodeNum, nextNodeCost));
                }
            }
        }

        return minDist;
    }
}
/*
- 양방향 가중 그래프 -> 자료구조는 뭘 써야할까,,? 클래스는 만들어야할까? 
- n 개의 노드
- 간선 길이 = 요금 
- 갈땐 같이가다가 나눠 갈 수 도 있음 

출발 4번(A와 B)

dp..? 

i, j  는 분기점


*/

