class Solution {
    
    class Coffee{
        public int cost = 5500;
    }

    public int[] solution(int money) {
        
        Coffee coffe = new Coffee();

        int purchaseCount = money / coffe.cost;
        int extraMoney = money % coffe.cost;

        int[] answer = {purchaseCount, extraMoney};
        return answer;
    }
}