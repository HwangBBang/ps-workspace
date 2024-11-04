class Solution {
    private static final int DISH_PRICE = 12_000;
    private static final int DRINK_PRICE = 2_000;
    private static final int SERVICE_UNIT = 10;
    
    
    public int solution(int n, int k) {
        int serviceCnt = n / SERVICE_UNIT; 
        
        int answer = purchaseDish(n) + purchaseDrink(k - serviceCnt);    
        return answer;
    }
    
    
    private int purchaseDish(int n){
        return n * DISH_PRICE;
    }
    private int purchaseDrink(int n){
        return n * DRINK_PRICE;
    }
}