import sys

input = sys.stdin.readline

while True:
    a,b,c = map(int,input().split())
    
    if a==0 and b==0 and c==0 :
        break
    
    if max(a, b, c) == a:
        if a**2 == b**2 + c**2:
            print("right")
        else:
            print("wrong")
            
    elif max(a, b, c) == b:
        if b**2 == a**2 + c**2:
            print("right")
        else:
            print("wrong")
    else:
        if c**2 == b**2 + a**2:
            print("right")
        else:
            print("wrong")
