import java.util.*;


class Solution{
    public int solution(String s){
        Stack<String> stk = new Stack<>();
        String[] sList= s.split("");
        
        for (String each : sList){
            if (!stk.isEmpty() && stk.peek().equals(each)){
                stk.pop();
            }
            else stk.push(each);
        }
        
        return stk.isEmpty() ? 1 : 0;
    }
    
//     static boolean removePair(StringBuilder sb){
//         for (int i = 0; i < sb.length()-1; i++){
//             if (sb.length() >= 2){
                
//                 String s1 = sb.substring(i,i+1);
//                 String s2 = sb.substring(i+1,i+2);
                
//                 if (s1.equals(s2)){
//                     sb = sb.delete(i,i+2);
//                     return true;
//                 }
//             }
                
//         }
//         return false;
//     }
}

/*
    문자열에서 같은 알파벳이 2개 붙어 있는 짝을 찾기
    그 둘을 제거한 뒤, 
    앞뒤로 문자열을 이어 붙입니다. 

    이 과정을 반복해서 문자열을 모두 제거한다면 짝지어 제거하기가 종료됩니다

    1,000,000 개를 O(n^2) -> 시간 초과 
    
    어떻게하지..?
    
    페어 문제는 스택 구조 활용하자! 

*/