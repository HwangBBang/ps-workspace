
import sys
input = sys.stdin.readline


n = int(input())
rgb = [0]*(n+1)

rgb[0] = [0,0,0]

for i in range(1,n+1):

    rgb[i] = list(map(int,input().split()))

#  1번 집  ! = 2번 집  (숫자 3개 전부 달라야해)
#  n-1번 집  ! = n번 집  (숫자 3개 전부 달라야해)
#  연속된 3개 의 집 모두 (숫자 3개 전부 달라야해)
#  마지막 인덱스는 전 인덱스 영향만받음 

# < 문제가 복잡하다고 생각되면 쪼개서 생각하자 >

# 최소 비용 + rgb라는 조건 인 문제
# 최소 비용 dp 문제는 
# k 값 선택할 때 dp[k] = min(dp[k-1]+rgb[k])

# rgb 조건 문제는 index 가 아래와 같이 주어 질 때
# k-1, k ,k+1
# 0    1    2   0   1   2   0   1   2
# 0    2    1
# 1    0    2
# 1    2    0
# 2    0    1
# 2    1    0
# 인덱스 1은 아무거나 선택
# 인덱스 2은 1의 선택을 제외한 선택
# 인덱스 3은 결정 
# 인덱스 4도 결정 
#
for i in range(1,n+1):
    rgb[i][0] += min(rgb[i-1][1],rgb[i-1][2])
    rgb[i][1] += min(rgb[i-1][0],rgb[i-1][2])
    rgb[i][2] += min(rgb[i-1][0],rgb[i-1][1])

print(min(rgb[n]))