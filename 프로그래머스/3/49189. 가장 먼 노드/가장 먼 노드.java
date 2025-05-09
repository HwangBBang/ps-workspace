import java.util.*;
class Solution {
    
    static Queue<Node> queue = new LinkedList<>();
    static List<Node> nodes = new ArrayList<>();
    static boolean[] v;
    
    static class Node{
        int num;
        int dist = 0;
        List<Node> linked = new ArrayList<>();
        
        public Node(int num){
            this.num = num;
        }
        
        void add(Node no){
            linked.add(no);
        }
    }
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        v = new boolean[n+1];
        v[0] = true;
        
        for(int i = 0; i <= n; i++){
            nodes.add(new Node(i));
        }
        for(int i = 0; i < edge.length; i++){
            Node c = nodes.get(edge[i][0]);
            Node k = nodes.get(edge[i][1]);
            c.add(k);
            k.add(c);
        }
                
        queue.add(nodes.get(1));
        v[1] = true;
        
        bfs();
        int maxDist = Integer.MIN_VALUE;
        for (Node no: nodes){
            maxDist = Math.max(maxDist, no.dist);
        }
        
        for (Node no: nodes){
            if (maxDist == no.dist) answer ++;
        }
        
        return answer;
    }
    
    static void bfs(){
        while(!queue.isEmpty()){
            Node currentNode = queue.poll();
            List<Node> links = currentNode.linked;
            int nodeNum = currentNode.num;
            int currentDist = currentNode.dist;
            
            for (int i = 0; i < links.size(); i++){
                Node nextNode = links.get(i);
                if (v[nextNode.num]) continue;
                
                nextNode.dist = currentDist + 1;
                v[nextNode.num] = true;
                queue.add(nextNode);
            }
            
        }
    }
}