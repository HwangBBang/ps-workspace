# 하노이 탑
# 맨 밑의 원판을 제외하고 통으로 옮기는거 (원래 옮기고 싶은 곳 말고): T(n-1)
# 맨 밑의 원판을 옮긴다 (원래 옮기고 싶은 곳으로) T(1)
# 맨 밑의 원판을 제외하고 통으로 옮기는거 (원래 옮기고 싶은 곳으로 ): T(n-1)

# T(n) =  2*T(n-1) + T(1)
#
# T(2) = 2*T(1) + T(1)
# dp 사용~

n = int(input())
dp = [None]*n; dp[0] = 1

i = 0
while i < n-1:
    dp[i+1] = 2*dp[i]+1
    i += 1

k = dp[-1]

print(k)
# <1번탑의 n-1 개를 옮겨야함 2번탑으로 옮겨야함>

# <1번 탑에 하나남은 가장 아래 원판을 3번으로>

# <2번탑의 n-1 개를 옮겨야함 3번탑으로 옮겨야함>


# n = 2   (1, 1, 1)
def shiftDisk(n,start,end):
    if n < 2:
        return
    
    if n == 2:
        if (start == 1 and end == 2) or (start == 2 and end == 1):
            print(start, 3)
            print(start, end)
            print(3, end)
        else:
            print(start, abs(end-start))
            print(start, end)
            print(abs(end-start),end)
            return
    
    if n > 2:
        if (start == 1 and end == 2) or (start == 2 and end == 1):
            shiftDisk(n-1, start, 3)
            
            print(start, end)
            
            shiftDisk(n-1, 3, end)
        else:
            shiftDisk(n-1,start,abs(end-start))
        
            print(start, end)
        
            shiftDisk(n-1, abs(end-start),end)
        return

# n = 4
# 1 2
# 1 3
# 2 3
# 1 2
# 3 1
# 3 2
# 1 2

# 1 3




# 원판이 두개 이상 일 떄

if n > 1:
    # # <1번탑의 n-1 개를 옮겨야함 2번탑으로 옮겨야함>
    # shiftDisk(n-1, 1, 2)
    # # <1번 탑에 하나남은 가장 아래 원판을 3번으로>
    # print(1,3)
    # # <2번탑의 n-1 개를 옮겨야함 3번탑으로 옮겨야함>
    # shiftDisk(n-1, 2, 3)
    shiftDisk(n,1,3)

# 원판이 하나 일 떄
else:
    print(1, 3)