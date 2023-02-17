n = int(input())
arr = [11] + list(map(int,input().split()))

# 바이토닉 수열 10, 20, 30, 40
# 바이토닉 수열 50, 40, 25, 10
# 바이토닉 수열 아님 1, 2, 3, 2, 1, 2, 3, 2, 1
# 바이토닉 수열 아님 10, 20, 30, 40, 20, 30
# 바이토닉 수열이란? :  (증가하는 수열 + 감소하는 수열) or (증가 하는 수열) or (감소하는 수열)

# 가장 긴 바이토닉 수열의 점화식은 어떻게 될까..? 
# 증가하는 수열의 dp 값과 감소하는 수열의 dp의 합의 MAX 값이 정답이 될것이다 .
# dp = increaseDP+decreaseDp
# result = max(dp)

# 가장 긴 증가하는 수열을 생성하기위해 increaseDP 초기화 
increDp = [1]*(n+1)

# 가장 긴 감소하는 수열을 생성하기위해 increaseDP 초기화 
decreDp = [1]*(n+1)

# 1로 초기화하는 이유는? i번째 인덱스는 무조건 선택되기 때문에 길이는 1 디


#increDP[i] 끝나는 증가하는 수열의 길이
#decreDp[i] 시작하는 감소하는 수열의 길이
# 테스트 케이스 
# 10
# 1 5 2 1 4 3 4 5 2 1
# 1   2     3 4 5    
#                 2 1

for i in range(1,n+1):
    for j in range(1,i+1):
        if arr[i]>arr[j]:
            increDp[i] = max(increDp[i], increDp[j]+1)

for i in range(n,0,-1):
    for j in range(n,i,-1):
        if arr[i]>arr[j]:
            decreDp[i] = max(decreDp[i], decreDp[j]+1)

dp = [increDp[i]+decreDp[i]-1 for i in range(1,n+1)]
result = max(dp)

print(result)

# 이렇게나 잘 풀었는데 ? 틀렸다
# 이유는 한가지 간과한 것이있다.
# 만나는 지점에서 두번 카운팅하기때문에 -1 씩 빼줘야한다.
