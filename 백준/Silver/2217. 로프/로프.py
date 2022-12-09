
import sys
input = sys.stdin.readline


n = int(input())

A = []
for _ in range(n):
    A.append(int(input()))

# n 개 중 k 개의 로프를 사용하여 중량w 를 들어올릴 때 수 있음
# 이때 k 개의 로프에 걸리는 하중은 w/k 이다
# w/k + w/k + w/k ... w/k + w/k 

# 10버티는 로프, 15버티는 로프
# 10버티는 로프 만 사용할 경우 최대 하중 w는 10
# 15버티는 로프 만 사용할 경우 최대 하중 w는 15
# 두개 다 사용 할 경우  = min(i 까지 버티는 로프)*k(k:선택한 로프 수)

A.sort()

w = 0 # 하중

for i in range(n):
    # 가장 작은 idx = 0 을 선택한경우 
    if A[i]*(n-i) > w:
        w = A[i]*(n-i)
print(w)

