
Xa,Ya = map(int,input().split())
Xb,Yb = map(int,input().split())
Xc,Yc = map(int,input().split())

# 선분 2개 간의 백터의 외적으로 CCW 인지 CW 인지 확인한다.
# 반시계방향(CCW) : 외적 값이 양수
# 시계방향(CW) : 외적 값이 음수
# 외적 값이 0 인 경우는 경계

X1= Xb - Xa
Y1= Yb - Ya

X2= Xc - Xb
Y2= Yc - Yb


# 외적 

sign1 = X1*Y2 - X2*Y1

if sign1 > 0 :
    print(1)
elif sign1 < 0:
    print(-1)
else:
    print(0)