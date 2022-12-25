import sys 
input = sys.stdin.readline

# X,Y 는 궁금한 녀석
# 저직선위에 있니? 물어보는 함수
def isSamePoint(d,x,y,X,Y):
    if Y == d*(X-x) +y:
        return True
    else:
        return False

def findPoint(d1,d2,x1,y1,x3,y3):
    X = (y3-y1+x1*d1-x3*d2)/(d1-d2)
    Y = d1*(X-x1)+y1
    return (X,Y)

def findPointInf(d,X,x,y):
    Y = d*(X-x)+y
    return (X,Y)
# 테케 갯수 
n = int(input())

for _ in range(n):
    x1,y1,x2,y2,x3,y3,x4,y4 = map(int, input().split())
    
    # 기울기 무한이 아닐때 
    if x1 != x2 and x3 != x4:
        # 기울기 계산 
        d1 = (y1-y2)/(x1-x2)
        d2 = (y3-y4)/(x3-x4)
        if d1 == d2:
        # 기울기가 같고,같은점을 지난다면 => LINE
            if isSamePoint(d1,x1,y1,x3,y3):
                print("LINE")
                
        # 기울기가 같고,같은점을 지나지 않는다면 => NONE
            else:
                print("NONE")
        
        else:
        # 그외 모든경우 POINT
            point = findPoint(d1,d2,x1,y1,x3,y3)
            print("POINT {:.2f} {:.2f}".format(point[0],point[1]))
    
    else:
        # 둘다 무한 일때
        if x1 == x2 and x3 == x4:
            if x1==x3:
                print("LINE")
            else:
                print("NONE")
        
        # 둘중 하나만 무한일 때
        else:
            if  x1 == x2 :
                # d1 은 무한
                d2 = (y3-y4)/(x3-x4)
                
                point = findPointInf(d2,x1,x3,y3)
                print("POINT {:.2f} {:.2f}".format(point[0],point[1]))
            elif  x3 == x4 :
                d1 = (y1-y2)/(x1-x2)
                # d2 은 무한
                
                point = findPointInf(d1,x3,x1,y1)
                print("POINT {:.2f} {:.2f}".format(point[0],point[1]))

