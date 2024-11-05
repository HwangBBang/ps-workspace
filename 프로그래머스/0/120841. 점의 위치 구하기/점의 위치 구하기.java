class Solution {
    public int solution(int[] dot) {
        int answer = 0;
        int x = dot[0];
        int y = dot[1];
        
        
        boolean is1 = x > 0 && y > 0; 
        boolean is2 = x < 0 && y > 0; 
        boolean is3 = x < 0 && y < 0; 
        boolean is4 = x > 0 && y < 0; 
        
        if(is1){
            answer = 1;
        }else if(is2){
            answer = 2;
        }else if(is3){
            answer = 3;
        }else if(is4){
            answer = 4;
        }
        return answer;
    }
}