import java.util.*;

class Solution {    
    static int answer;
    
    static class Dungeon{
        int minNeed;
        int cost;
        
        public Dungeon(int minNeed, int cost){
            this.minNeed = minNeed;
            this.cost = cost;
        }
    }
    
    public int solution(int k, int[][] dungeons) {
        
        List<Dungeon> list = new ArrayList<>(dungeons.length);
        for (int[] each : dungeons) list.add(new Dungeon(each[0], each[1]));        
        boolean[] visited = new boolean[dungeons.length];
        answer = 0;
        dfs(k, list, visited, 0);
        
        return answer;
    }
    
    
    static void dfs(int energy, List<Dungeon> list, boolean[] visited, int cnt){
        if (cnt > answer ) {
            answer = cnt;
        }
        
        for (int i = 0; i < list.size(); i ++){
            if (visited[i]) continue;
            Dungeon dungeon = list.get(i);
            if (dungeon.minNeed > energy) continue;
            
            visited[i] = true;
            dfs(energy - dungeon.cost, list, visited, cnt + 1);
            visited[i] = false;
            
        }
    }
    
}

/*
    k : 피로도 자연수 
    일정 피로도를 사용
    
    "최소 필요 피로도" : 각 던전마다 탐험을 시작하기 위해 필요한 
    "소모 피로도" : 던전 탐험을 마쳤을 때 소모되는 
    
    이 던전들을 최대한 많이 탐험
    
    2중 정렬 
    
    ["최소 필요 피로도", "소모 피로도"]
    
    소모 피로도 기준으로 정렬 후 , 최소 피로도 기준으로 정렬 
*/
