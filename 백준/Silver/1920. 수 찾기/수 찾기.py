n = int(input())
A = set(map(int,input().split()))

m = int(input())
B = list(map(int, input().split()))

#  set의 탐색 시간 O(1)
#  list의 탐색 시간 O(n)


for elem in B:
    if elem in A:
        print(1)
    else:
        print(0)
