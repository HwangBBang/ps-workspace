H , M = map(int,input().split())

if M-45 > 0:
    print(H, M)
elif M == 45:
    print(H, 0)
else: 
    if H==0:
        print(23, M+15)
    else:
        print(H-1, M+15)