class Solution {
    
    static class Pizza {
        int pieceCnt = 7;
    }

    public int solution(int n) {
        int pieceCnt = new Pizza().pieceCnt;
        return (int)Math.ceil((double) n / pieceCnt);
    }
}