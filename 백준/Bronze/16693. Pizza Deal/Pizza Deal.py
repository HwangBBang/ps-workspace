import math
a,p1 = map(int,input().split())
r,p2 = map(int,input().split())


ans1 = p1/a
ans2 = p2/(r*r*math.pi)

if ans1 > ans2:
    print("Whole pizza")
else:
    print("Slice of pizza")