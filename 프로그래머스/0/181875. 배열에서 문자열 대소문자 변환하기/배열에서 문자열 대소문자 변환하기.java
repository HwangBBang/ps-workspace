class Solution {
    public String[] solution(String[] strArr) {
        int len = strArr.length;
        for(int i = 0; i < len; i ++){
            if(i%2 == 0){
                strArr[i] = strArr[i].toLowerCase();
            }else{
                strArr[i] = strArr[i].toUpperCase();
            }
            
        }
        return strArr;
    }
}