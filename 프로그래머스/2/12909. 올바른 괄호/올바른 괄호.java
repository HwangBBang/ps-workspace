import java.util.*;

//     System.out.println()
class Solution {

    static Queue<Character> queue = new LinkedList<>();    

    boolean solution(String s) {
        char[] chars= s.toCharArray();
        int n = chars.length;
        
        for (int i = 0; i < n ; i++){
            if (chars[i] == '(') queue.add(chars[i]);
            else if (chars[i] == ')') removeChar(chars[i]);
        }
        
        if (queue.isEmpty()) return true;
        return false;
    }
    
    static void removeChar(char c){
        for (Character q :queue){
            if (q == '(') {
                queue.poll();
                return;            
            }
        }
        queue.add(c);
        
    }
}

/*

"()()"	
"(())()" -> "(())" -> "()"
")()("	
"(()("	

*/