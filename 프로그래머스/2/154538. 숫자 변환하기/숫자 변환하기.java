import java.util.*;

class Solution {
    public static class Node{
        int value;
        int step;
        public Node(int value, int step){
            this.value = value;
            this.step = step;
        }
    }
    
    public int solution(int x, int y, int n) {
        
        
        Queue<Node> que = new ArrayDeque<>();
        que.add(new Node(y,0)); // 시작점 y
        
        while(!que.isEmpty()){
            Node polled = que.poll();
            int cur = polled.value;
            int step = polled.step;
            
            // x 와 같아 지면 스톱 
            if (cur == x) return step;
                
            if (cur%2 == 0) que.add(new Node(cur/2,step+1));
            if (cur%3 == 0) que.add(new Node(cur/3,step+1));
            if (cur-n > 0) que.add(new Node(cur-n,step+1));   
            
            
        }
        
        return -1;
    }
}
/*
    BFS 
    
    x -> y

    1. x = x + n
    2. x = x * 2
    3. x = x * 3
    
    10 -> 15  -> 
    10 -> 20  -> 
    10 -> 30  -> 
    
    40 -(-5)-> 35 
    40 -(/2)-> 20 
    40 -()-> X 
    
    40 -(-30)-> 10
    40 -(/2)-> 20
    40 -> X
    
    [35, 20]
    [20]
*/