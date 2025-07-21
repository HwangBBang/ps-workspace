class Solution {
    public String solution(int[] food) {
        StringBuilder answer = new StringBuilder();
        
        /*
            인덱스 + 1 에 벨류가 갯수 
        */
        
        int n = food.length; 
        for (int i = 0; i < n; i ++) {
            int cnt = food[i] / 2;
            for (int j = 0; j < cnt; j ++){
                answer.append(String.valueOf(i));            
            }           
        }
    
        answer.append("0");
    
        for (int i = n-1; i >= 0; i --) {
            int cnt = food[i] / 2;
            for (int j = 0; j < cnt; j ++){
                answer.append(String.valueOf(i));
            }   
        }
        
        return answer.toString();
    }
}

/*
예를 들어, 3가지의 음식이 준비되어 있으며, 
칼로리가 적은 순서대로 
1번 음식을 3개, 
2번 음식을 4개, 
3번 음식을 6개 준비했으며, 

물을 편의상 0번 음식이라고 칭한다면, 

두 선수는 
1번 음식 1개, 
2번 음식 2개, 
3번 음식 3개씩을 먹게 되므로 음식의 배치는 "1223330333221"이 됩니다. 

따라서 1번 음식 1개는 대회에 사용하지 못합니다.
*/