import java.util.*;

class Solution {
    
    static class Node{
        final int num;
        final boolean isSheep;
        final List<Integer> edgeNodes = new ArrayList<>();
        
        Node(int num, boolean isSheep){
            this.num = num;
            this.isSheep = isSheep;        }
        
        public void addEdgeNode(int edgeNode){
            this.edgeNodes.add(edgeNode);
        }
        
    }
    
    static int answer;
    
    public int solution(int[] info, int[][] edges) {
        answer = 0;
        int n = info.length;
        List<Node> nodes = new ArrayList<>();
        
        for (int i = 0; i < n; i ++){
            nodes.add(new Node(i,info[i] == 0));
        }
        for (int [] edge : edges){
            nodes.get(edge[0]).addEdgeNode(edge[1]);
            nodes.get(edge[1]).addEdgeNode(edge[0]);
        }
        
        boolean[] visited = new boolean[n];
        // 방문 후보 (이웃 노드)
        Set<Integer> candidates = new HashSet<>(nodes.get(0).edgeNodes);
        
        dfs(0,0,0,nodes,visited, candidates);
        
        return answer;
    }
    
    
    public void dfs(int curNode,
                    int sheepCnt,
                    int wolfCnt,
                    List<Node> nodes, 
                    boolean[] visited, 
                    Set<Integer> candidates){
        
        visited[curNode] = true;
        if (nodes.get(curNode).isSheep) sheepCnt ++;
        else wolfCnt ++;
        
        if  (sheepCnt <= wolfCnt) {
            visited[curNode] = false;
            return;
        }
        
        if (answer < sheepCnt) answer = sheepCnt;
        
        Set<Integer> nextCandidates = new HashSet<>(candidates);
        nextCandidates.remove(curNode);
        
        for (int each : nodes.get(curNode).edgeNodes){
            if (!visited[each]) nextCandidates.add(each);
        }
        
        for (int candiNode : nextCandidates){
            dfs(candiNode, sheepCnt, wolfCnt, nodes, visited, nextCandidates);
        }
        
        visited[curNode] = false;
    }
}

/*
2진 트리 모양 초원의 각 노드에 늑대와 양이 한 마리씩 

루트 노드에서 출발, 양을 모으자 

각 노드를 방문할 때 마다 해당 노드에 있던 양과 늑대가 당신을 따라오게 됩니다.

모은 양의 수 <= 늑대의 수,  양의 수 => 0

최대한 많은 수의 양으로  다시 루트 노드

0은 양, 1은 늑대

문제는 대강이해 했다. 

1. 트리를 구현해서 시뮬레이션을 해야할까? 

2. 현재 양과 늑대 수를 클래스로 관리해야할까? 

3. 2차원 배열로 이진트리를 주어졌을 때는 어떻게해야하지? 

트리를 구현하기 위해서, Node 클래스를 우선 만들자.

트리를 구현할 때 사용해야하는 자료구조는 뭐지..? 
-> 일단 ...리스트로 

구현은 했는데 방문은 어떻게하지..? DFS? 

*/