import java.util.*;

class Solution {
    
    public int solution(String s) {
        int answer = 0;
        Deque<String> deq = new ArrayDeque();
        for(String each: s.split("")){
            deq.add(each);    
        }
                
        for (int i = 0; i < s.length(); i++){
            if (isCorrect(deq)) answer ++;
            deq = shiftLeft(deq);    
        }
        
        
        
        return answer;
    }
    
    static Deque<String> shiftLeft(Deque<String> s){
        
        String poped = s.removeFirst();
        s.add(poped);
        
        return s;
    }
    
    static boolean isCorrect(Deque<String> s){
        Stack<String> stk = new Stack<String>();
        
        for (String each : s){
            
            if(!stk.empty() && isPair(stk.peek(), each)){
                stk.pop();
            }else{
                stk.push(each);
            }
        }
        return stk.empty();
    }
    
    static boolean isPair(String a, String b){
        if (a.equals("[") && b.equals("]")) return true;
        if (a.equals("{") && b.equals("}")) return true;
        if (a.equals("(") && b.equals(")")) return true;
        
        return false;
    }
}
/*
for (String test : stk) System.out.print(test);
System.out.println();
*/      

