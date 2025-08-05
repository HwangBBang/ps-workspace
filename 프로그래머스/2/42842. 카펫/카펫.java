class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        int totalSize = brown + yellow;
        
        for (int i = 3; i * i <= totalSize; i++){
            if (totalSize % i != 0) continue;
            
            int width = totalSize / i;
            int height = i;
            
            // if (! availableYellow(width, height, yellow)) continue;
            // if (! availableBrown(width, height, brown, totalSize)) continue;
            
            if (yellow == (width-2) * (height-2)){
                answer = new int[]{width, height};    
            }
            
        }
        
        return answer;
    }
    
    static boolean availableYellow(int w , int h, int y){
        int maxPiovt = (w-2) * (h-2);
        
        return maxPiovt >= y;
    }
}
/*
    격자 총 사이즈는 = 갈 + 노 
    totalSize 를 인수분해 하면 그 중 m x n 사이즈를 부합하는녀석이 누구인지 알 수 있음  
    
    가로 >= 세로
    또한, 감싸기 위해서는 세로는 항상 3이상이여야함
    
    사이즈에 부합하는 m x n 일 때, 노랑 갯수와 의 임계 값(m - 2) * (n - 2) 
    
    케이스 3개 틀림 

    뭐가 틀린 것일까? 
*/