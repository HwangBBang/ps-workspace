class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        int removed = 0;
        int loop = 0;
        
        while (!s.equals("1")){
            int pre = s.length();
            s = s.replaceAll("0","");
            int now = s.length();
            removed += pre - now;
            
            int c = now;
            s = Integer.toBinaryString(c);
            loop ++;
        }
            
        
        answer = new int []{loop, removed};
        
        return answer;
    }
    
    
}

/*
    1. 0 제거 
    2. 길이 추출 
    3. 길이를 2진법으로 변환

    [이진 변환의 횟수, 제거된 모든 0의 개수]
*/