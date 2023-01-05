
t = int(input())

for _ in range(t):
    a,b = map(int,input().split())
    if a % 10== 1 : 
        print(1)
    
    elif a % 10 == 2 :
        if b%4 == 1:
            print(2)
        if b%4 == 2:
            print(4)
        if b%4 == 3:
            print(8)
        if b%4 == 0:
            print(6)
    
    elif a % 10 ==3 :
        if b%4 == 1:
            print(3)
        if b%4 == 2:
            print(9)
        if b%4 == 3:
            print(7)
        if b%4 == 0:
            print(1)

    elif a % 10 ==4 :
        if b%2 == 1:
            print(4)
        if b%2 == 0:
            print(6)
    
    elif a % 10 ==5 :
        print(5)
    elif a % 10 ==6:
        print(6)
    
    elif a % 10 ==7:
        if b%4 == 1:
            print(7)
        if b%4 == 2:
            print(9)
        if b%4 == 3:
            print(3)
        if b%4 == 0:
            print(1)
    
    elif a % 10 ==8:
        if b%4 == 1:
            print(8)
        if b%4 == 2:
            print(4)
        if b%4 == 3:
            print(2)
        if b%4 == 0:
            print(6)
    
    elif a % 10 ==9:
        if b%2 == 1:
            print(9)
        if b%2 == 0:
            print(1)
    else:
        print(10)
    