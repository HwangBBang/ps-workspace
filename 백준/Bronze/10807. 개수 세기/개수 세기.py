n = int(input())
A = map(int,input().split())
v = int(input())

cnt = 0

for elem in A:
    if v == elem:
        cnt +=1 

print(cnt)