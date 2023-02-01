
while 1:
    a,b = map(int,input().split())
    
    if a == b == 0:
        break
    
    elif b%a == 0:
        print("factor")
    elif a%b == 0:
        print("multiple")
    else:
        print("neither")