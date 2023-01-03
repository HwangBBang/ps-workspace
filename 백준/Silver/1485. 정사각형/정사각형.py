import math

# 조건 1. 이웃하는 점간의 거리가 모두 같은가? 
def getDis(x1,y1,x2,y2):
    result =  math.sqrt(pow(x2-x1,2)+ pow(y2-y1,2))
    return result

# 조건 2. 이웃하는 점간의 벡터의 내적 값이 0 인가?
def innerProduct(Vx1,Vy1,Vx2,Vy2):
    if Vx1*Vy1 + Vx2*Vy2 == 0:
        return True # 직각이다.
    else:
        return False
# 조건 3. 대각선의 길이 같다. 

T = int(input())

for _ in range(T):
    dots = [0]*4
    
    for i in range(4):
        dots[i] = tuple(map(int,input().split()))
    
    dots.sort()
    re1 = getDis(dots[0][0],dots[0][1],dots[1][0],dots[1][1])
    re2 = getDis(dots[2][0],dots[2][1],dots[3][0],dots[3][1])
    re3 = getDis(dots[0][0],dots[0][1],dots[2][0],dots[2][1])
    re4 = getDis(dots[1][0],dots[1][1],dots[3][0],dots[3][1])

    if not re1 == re2 == re3 == re4 :
        print(0)
        continue
    
    Vx1,Vy1 = dots[1][0]-dots[0][0],dots[1][1]-dots[0][1]
    Vx2,Vy2 = dots[3][0]-dots[1][0],dots[3][1]-dots[1][1]
    if not innerProduct(Vx1,Vy1,Vx2,Vy2):
        print(0)
        continue
    Vx1,Vy1 = dots[3][0]-dots[1][0],dots[3][1]-dots[1][1]
    Vx2,Vy2 = dots[2][0]-dots[3][0],dots[2][1]-dots[3][1]
    if not innerProduct(Vx1,Vy1,Vx2,Vy2):
        print(0)
        continue
    Vx1,Vy1 = dots[3][0]-dots[2][0],dots[3][1]-dots[2][1]
    Vx2,Vy2 = dots[0][0]-dots[2][0],dots[0][1]-dots[2][1]
    if not innerProduct(Vx1,Vy1,Vx2,Vy2):
        print(0)
        continue
    
    if (getDis(dots[3][0],dots[3][1],dots[0][0],dots[0][1]) != getDis(dots[2][0],dots[2][1],dots[1][0],dots[1][1])):
        print(0)
        continue
    print(1)
    