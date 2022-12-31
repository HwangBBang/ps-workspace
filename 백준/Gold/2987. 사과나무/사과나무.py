
Xa,Ya = map(int,input().split())
Xb,Yb = map(int,input().split())
Xc,Yc = map(int,input().split())

s = abs(Xa*(Yb-Yc)+Xb*(Yc-Ya)+Xc*(Ya-Yb))/2

global cnt 
cnt = 0


def isIn(Xp,Yp):
    global cnt 
    # 백터의 외적으로 접근한다. 
    # P(x,y) 점과  삼각형을 이루는 선분과의 외적 값이 음수가 나오는 것이 있다면 
    # 삼각형 외부 있는 것이다. CCW 확장문제 
    #반시계방향(CCW) : 외적 값이 양수
    #시계방향(CW) : 외적 값이 음수
    # 모든 부호가 같다면? 내부 에있는거임 0 인 경우는 경계
    
    # PA x PC , PC x PB, PB x PA
    sign1 = (Xa-Xp)*(Yc-Yp)-(Xc-Xp)*(Ya-Yp)
    sign2 = (Xc-Xp)*(Yb-Yp)-(Xb-Xp)*(Yc-Yp)
    sign3 = (Xb-Xp)*(Ya-Yp)-(Xa-Xp)*(Yb-Yp)
    if (sign1 >= 0 and sign2 >= 0 and sign3 >= 0) or (sign1 <= 0 and sign2 <= 0 and sign3 <= 0):
        cnt +=1
        return
    
    # 밖에 있음
    else:        
        return




n = int(input())

for _ in range(n):
    x,y = map(int,input().split())
    isIn(x,y)

print(round(s,1))
print(cnt) 