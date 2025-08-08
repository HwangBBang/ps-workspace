class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;

        
//       칸 차이가 0 일 때 까지 
        
        while (a != b){
            answer ++;
            a = a % 2 == 1 ? (a + 1) / 2 : a / 2;
            b = b % 2 == 1 ? (b + 1) / 2 : b / 2;
        }
        
        
        

        return answer;
    }
}

/*
N명의 참가자는 각각 1부터 N번을 차례대로 배정

인접한 녀석들 끼리 게임
1번↔2번 ... N-1번↔N번 게임을 진행

각 게임에서 이긴 사람은 다음 라운드에 진출

라운드 변경시 번호 다시 부여 

라운드 마다 번호의 길이는 1/2 

n 의 범위 는 2^ 1~20
라운드 마다 루트 취하면됨 


  1       2       3       4
1 - 2 | 3 - 4 | 5 - 6 | 7 - 8  (Round 1) 
  2   |   4   |   x   |   7    (Round 2)
      2       |       7        (Round 3)

1 | 2 | 3 | 4 | 5 | 6 | 7 | 8  (Round 1) 
  2   |   4   |   x   |   7    (Round 2)
      2       |       7        (Round 3)
      
1 | 2 | 3 | 4 | 5 | 6 | 7 | 8  (Round 1) 
  1   |   x   |   6   |   8    (Round 2)
      1       |       6        (Round 3)
      
1 | 2 | 3 | 4 | 5 | 6 | 7 | 8  (Round 1) 
  x   |   3   |   5   |   x    (Round 2)

7 - 2 => 5 3라운드 
6 - 1 => 5

*/ 