import java.util.*;

class Solution {    
    
    static List<Integer>[] graph;
    
    public static class Local{
        int dist;
        int num;
        Local(int dist, int num){
            this.dist = dist;
            this.num = num;
        }
    }
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        
        graph = new ArrayList[n+1];
        for (int i = 0; i <= n; i++){
            graph[i] = new ArrayList<>();
        }
        
        for (int[] road : roads){
            graph[road[0]].add(road[1]);
            graph[road[1]].add(road[0]);
        }
        
        
        int[] dists = daijkstra(n,destination);
        
        for (int i = 0; i < sources.length; i++){
            int start = sources[i];
            
            if (dists[start] == Integer.MAX_VALUE) 
                dists[start] = -1;
            
            answer[i] = dists[start];
        }
        
        return answer;
    }
    
    public static int[] daijkstra(int n , int start){
        int [] minDist = new int[n+1];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        
        PriorityQueue<Local> frontier = new PriorityQueue<>(
        (a,b) -> Integer.compare(a.dist,b.dist));
        
        minDist[start] = 0;
        frontier.add(new Local(0,start));
        while (!frontier.isEmpty()){
            Local polled = frontier.poll();
            int currentDist = polled.dist;
            int currentNum = polled.num;
            
            if(minDist[currentNum] != currentDist) continue;
            
            for (int nextNum : graph[currentNum]){
                
                int nextDist = currentDist + 1;
                if (minDist[nextNum] > nextDist){
                    minDist[nextNum] = nextDist;
                    frontier.add(new Local(nextDist,nextNum));
                }       
            }   
        }
        
        return minDist;
    }
}

// 부대원들이 강철부대로 복귀하는 최단 거리 
// 가중치 = 1 ,최단시간, 양방향 
// 지역 == 노드 
// 간선들 roads
// 부대원 시작위치들 sources
// 도착위치들 destination
