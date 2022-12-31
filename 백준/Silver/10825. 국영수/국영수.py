
n = int(input())
arr = [0]*n
for i in range(n):
    # 이름 국어 영어 수학 
    arr[i] = list(input().split())

# 정렬 기준
# 국어 내림차순
# 영어 오름차순
# 수학 내림차순 
# 이름 사전 오름차순

arr.sort(key=lambda x:(-int(x[1]),int(x[2]),-int(x[3]),x[0]))


for i in range(0,n):
    print(arr[i][0])
