#A 는 고정 비용(매년) , B는 가변 비용(per 한대 ) C 는 가격

#C(판매가격) x n개 >  A + B(한대 생산비) x n  , n 의 최소값이 손익분기점 
# (C-B)n > A 

A,B,C = map(int, input().split())
n = 0 

while True:
    if C-B <= 0:
        print(-1)
        break
    else:
        n = A//(C-B)
        print(n+1)
        break