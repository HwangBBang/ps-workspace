class Solution {
    public String solution(String bin1, String bin2) {
        int answer = Integer.parseInt(bin1, 2) + Integer.parseInt(bin2, 2);
        return Integer.toBinaryString(answer);
    }


    public int convertToDec(String bin) {
        int answer = 0;
        String[] eachs = bin.split("");

        int length = eachs.length;

        for (int i = 0; i < length; i++) {
            answer +=  Integer.parseInt(eachs[length - i -1]) * (int)Math.pow(2, i);
        }
        return answer;
    }


    public String convertToBin(int dec){
        String answer = "";

        while (dec > 0){
            int div = dec % 2;
            dec = dec / 2;
            answer = div + answer;
        }
        return answer;
    }
}