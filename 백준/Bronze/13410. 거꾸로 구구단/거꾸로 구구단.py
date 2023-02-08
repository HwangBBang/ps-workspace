n,k = map(int,input().split())
box = [n*i for i in range(1,k+1) ]
ans = []

for elem in box:
    L = len(str(elem))
    preVal=""
    for j in range(L-1,-1,-1):
        preVal += str(elem)[j]
    ans.append(int(preVal))
    
        
print(max(ans))