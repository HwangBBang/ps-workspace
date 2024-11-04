class Solution {
    public int solution(int price) {
         // 10만 원 이상 사면 5%
         // 30만 원 이상 사면 10%
         // 50만 원 이상 사면 20%
        
        if (price >= 500_000){
            return discountPrice(price, 20);
        }else if(price >= 300_000){
            return discountPrice(price, 10);
        }else if(price >= 100_000){
            return discountPrice(price, 5);
        }
        return price;
        
    }
    
    private int discountPrice(int price, int discountRate){
        // double discountAmount = price * ((double) discountRate / 100);
        // int result = price - (int)discountAmount;
        // return result;
        return (int) (price * (1 - discountRate / 100.0));
    }
}