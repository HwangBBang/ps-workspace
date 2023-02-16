
n = int(input())
ALinkB = [(0,0)]
for _ in range(n):
    ALinkB.append(tuple(map(int,input().split())))

# 문제 예시를 통한 분석을 해보자 . 
# 문제에선 (1,8),(3,9),(4,1)
# 8
# 1 8 (X)
# 2 2
# 3 9 (X)
# 4 1 (X)
# 6 4
# 7 6
# 9 7
# 10 10
# B를 관찰해 보면 2, 4, 6, 7, 10 로 증가 하는 수열임을 알 수 있다.
# 없애는 전기줄이 최소이기 위해선 가장 긴 증가 수열을 만들면 된다.
# 우선 입력받은 리스트(튜플)을 정렬하고 
# 리스트[][1] 은 하나의 리스트이므로 이 리스트에대한 가장 긴 증가 수열을 만들어보자.
# [가장 긴 증가 수열](https://hwangbbang.tistory.com/12)은 에서 볼 수 확인 할 수 있다.

ALinkB.sort()
dp = [1]*(n+1)
for i in range(1,n+1):
    for j in range(1,i+1):
        if ALinkB[i][1] > ALinkB[j][1]:
            dp[i] = max(dp[i], dp[j]+1)
        


print(n - max(dp))























# dp = [0]*(n+1)
# ALinkB = [(0,0)]
# def isCross(x,y):
#     if x != y:
#         if ALinkB[x][0] < ALinkB[y][0] and ALinkB[y][1] < ALinkB[x][1]:
#             return True
#         if ALinkB[x][0] > ALinkB[y][0] and ALinkB[y][1] > ALinkB[x][1]:
#             return True
#     return False

# for _ in range(n):
#     ALinkB.append(tuple(map(int,input().split())))

# for i in range(1,n+1):
#     for j in range(1,n+1):
#         if isCross(i,j):
#             cross[i] += 1

# dp table 만들기 .. 
# 근데 너무 비효율적,, 다른 방법없을까?