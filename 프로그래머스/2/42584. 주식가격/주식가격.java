class Solution {
    static int[] priceList; 
    static int[] answer;
    static int n; 
    
    public int[] solution(int[] prices) {
        n = prices.length;
        answer = new int[n];
        priceList = prices;
        
        for (int i = 0 ; i < n; i++){
            update(i);
        }
        return answer;
    }
    
    static void update(int idx){
        int cnt = 0;
        for (int i = idx ; i < n; i++){
            answer[idx] = cnt++;
            if (priceList[idx] > priceList[i]){
                break;
            }
        }
    }
    
    
    
    
}