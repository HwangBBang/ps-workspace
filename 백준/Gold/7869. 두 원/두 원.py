import math

x1, y1, r1, x2, y2, r2 = map(float,input().split())
# 두 원의 중심사이 거리
d = math.sqrt(pow(x1-x2,2)+pow(y1-y2,2))

def getS(d,r1,r2):
    # 제2 코사인 으로 사잇각 구하기
    theta = math.acos((pow(r1,2) + pow(d,2) - pow(r2,2)) / (2*r1*d))
    
    s2 = math.sin(2*theta)*pow(r1,2)/2
    s1 = pow(r1,2)*theta
    
    return(s1-s2)

#영역이 없다.
if r1+r2<=d :
    result = 0.000

# 큰원에 작은원이 포함된 경우
elif abs(r1-r2)>=d :    
    result = math.pi * pow(min(r1,r2),2) 
    
else:
    result = getS(d,r1,r2)+ getS(d,r2,r1)  
    



print('%.3f' % result)