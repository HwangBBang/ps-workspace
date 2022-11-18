N = int(input())

B = list(map(int,input().split()))
M = max(B);sum=0;
for i in range (N):
    B[i] = B[i]/M*100
    sum += B[i]
print(sum/N)