n = int(input())
arr = []
while n != 1:
    for i in range(2,n+1):
        if n%i == 0:
            arr.append(i)
            n = n//i
            break

arr.sort()
for i in range(len(arr)):
    print(arr[i])