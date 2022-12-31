a,b,c = map(int,input().split())
arr = []
arr.append(a)
arr.append(b)
arr.append(c)
arr.sort()

for i in range(3):
    print(arr[i],end=" ")

