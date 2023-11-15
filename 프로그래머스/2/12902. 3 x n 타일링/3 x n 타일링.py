# dpA 딱 잘리는 경우 
# dpA(n) = dpA(n-2)
# dpB 는 한칸 넘는 경우
# dpB = 

def solution(n):
    dpA = [0]*5001
    dpB = [0]*5001

    # 마지막 칸을 바라 볼 때, 
    # 경우의 수는 (위에서 부터)

    # 딱 잘리는 경우 dpA
    # case 1 -> dpA(n-2)
    # 21
    # 21
    # 21

    # 어정쩡하게 짤리는 경우 dpB 
    # case 2 -> dpB(n-1)
    # 21
    # 12

    # 어정쩡하게 짤리는 경우 dpC 
    # case 3 -> dpC(n-1)
    # 12
    # 21
    # dpC 는 dpB 와 완전히 같은 케이스로 볼 수있기 때문에 dpB만 연산해주고 나중에 *2 해준다


    # 점화식
    # dpA(n) = dpA(n-2) + dpB(n-1)*2
    # dpB(n-1) = dpA(n-2) + dpB(n-3)



    # 초기화 (기본 값)/ 바텀업 방식
    dpA[2] = 3
    dpB[1] = 1



    for i in range(3,n+1):
        dpB[i] =(dpA[i-1] +dpB[i-2])%1000000007

        dpA[i] = (dpA[i-2]+dpB[i-1]*2)%1000000007
        

    # print(dpA[n])
    answer = dpA[n]
    # print(answer)
    return answer

# solution(4)