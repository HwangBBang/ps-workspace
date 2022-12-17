import sys
input = sys.stdin.readline


m = int(input())
n = int(input())
result = []

def prime(num):
    cnt = 0
    if num == 1:
        return False
    for i in range(1,num):
        if num%i == 0:
            cnt+=1
            if cnt > 1:
                # 아니라면
                break
    # 소수라면
    if cnt == 1:
        return num
    else:
        return False
    


for i in range(m,n+1):
    if prime(i) != False:
        result.append(prime(i))
    
if len(result)>0:
    print(sum(result))
    print(result[0])
else:
    print(-1)