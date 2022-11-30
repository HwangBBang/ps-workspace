n = int(input())
arr = [None]*n

for i in range(n):
    arr[i] = input()

arr = list(set(arr))
arr = sorted(arr,key=lambda x:(len(x),x))

for elem in arr:
    print(elem)