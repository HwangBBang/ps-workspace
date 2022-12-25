import sys 
input = sys.stdin.readline

n = int(input())

Str = input().rstrip()



# pPAp
i,cnt = 0,0
if n<4:
    print(cnt)
else:
    while i < n-3:
        if Str[i]=='p'and Str[i+1]=='P'and Str[i+2]=='A'and Str[i+3]=='p':
            cnt+=1
            i+=4
        else:
            i+=1
    
    print(cnt)