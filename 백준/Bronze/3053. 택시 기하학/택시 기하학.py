import math

r = int(input())
c1 = r*r*math.pi
# x1,y1 = 0,0
# c2 원의 정의는 |x2|+|y2|이다. 
# c2 의 원은 밑면이 루트2*r 인 정사각형 이다.
c2 = 2*r*r
print("%.6f" %c1)
print("%.6f" %c2)