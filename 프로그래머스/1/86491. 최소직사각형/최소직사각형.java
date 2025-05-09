import java.util.*;

// 가장 긴 가로 길이와 세로 길이가 각각 80, 70이기 때문에 80(가로) x 70(세로) 크기의 지갑을 만들면 모든 명함들을 수납할 수 있습니다.
// 하지만 2번 명함을 가로로 눕혀 수납한다면 80(가로) x 50(세로) 크기의 지갑으로 모든 명함들을 수납할 수 있습니다. 
// 이때의 지갑 크기는 4000(=80 x 50)입니다.

// 모든 명함의 가로 길이와 세로 길이를 나타내는 2차원 배열 sizes가 매개변수로 주어집니다. 
// 모든 명함을 수납할 수 있는 가장 작은 지갑을 만들 때, 지갑의 크기를 return 하도록 solution 함수를 완성해주세요.


// [60, 50], -> 3000
// [30, 70], -> 2100
// [60, 30], -> 1800
// [80, 40]	 -> 3200 

// [10, 7], -> 70
// [12, 3], -> 36
// [8, 15], -> 120
// [14, 7], -> 98
// [5, 15]  -> 75


// [60, 50], -> 3000 ->  60, 50

// [60, 50], -> 3000
// [30, 70], -> 2100 -> 60 70
// [70, 30], -> 2100 -> 70 50 

// [60, 30]
// [30, 60] -> 

// [60, 50], -> 3000
// [70, 30], -> 2100 -> 70 50 

// 주어진 가로 최대와 세로 최대가 완전한 것은 아니다.
// 즉, 가로 최대와 세로 최대를 갱신해야한다.
// 명함의 갯수 만큼의 경우수 는 2^n
// 그럼 언제, 갱신되는 것인가? -> 애매함 그냥 다해봐야하나..? 
// 가로 세로의 기존 최대값을 넘는 카드는 리버스 해보자

// 4000 System.out.println()

// [10, 7], -> 70

// [10, 7], 
// [12, 3], -> 12 7 -> 84 
// [3, 12], -> 10 12 -> 120

// [12, 7]  -> 84
// [8, 15], -> 12 15 
// [15, 8], -> 15 8 -> 120

// [15, 8], -> 15 8 -> 120
// [14, 7], -> 15 8
// [7, 14], -> 15 14

// [10, 7], -> 70
// [12, 3], -> 36
// [8, 15], -> 120
// [14, 7], -> 98
// [5, 15]  -> 75
class Solution {
    static int n ;
    static int wMax;
    static int hMax;
    
    public int solution(int[][] sizes) {
        int answer = 0;
        n = sizes.length;
        wMax = sizes[0][0]; 
        hMax = sizes[0][1];
        
        for (int i = 1; i < n; i ++){
            setMaxSize(sizes[i]);
        }
        
        answer = wMax * hMax;
        
        return answer;
    }
    
    static int[] reversed(int[] card){
        int[] tempCard = card.clone();
        int temp = tempCard[0];
        tempCard[0] = tempCard[1];
        tempCard[1] = temp;
        return tempCard;
    }
    
    static void setMaxSize(int[] card){
        int wMaxTemp1 = wMax;
        int hMaxTemp1 = hMax;
        int wMaxTemp2 = wMax;
        int hMaxTemp2 = hMax;
        
        
        if (wMax < card[0]){
            wMaxTemp1 = card[0];
        }
        if (hMax < card[1]){
            hMaxTemp1 = card[1];
        }
        
        
        int[] reversedCard = reversed(card);
        if (wMax < reversedCard[0]){
            wMaxTemp2 = reversedCard[0];
        }
        if (hMax < reversedCard[1]){
            hMaxTemp2 = reversedCard[1];
        }
        
        if (wMaxTemp1 * hMaxTemp1 < wMaxTemp2 * hMaxTemp2 ){
            wMax = wMaxTemp1;
            hMax = hMaxTemp1;
        }else{
            wMax = wMaxTemp2;
            hMax = hMaxTemp2;
        }
           
    }
}




