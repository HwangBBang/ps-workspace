import sys
input = sys.stdin.readline

t = int(input())
vdList = [None]*6
vList = [0]*6 # 0,1,2,3,4
l = 0;h = 0
# 방향이 한번만 나온 것은 큰 직사각형의 높이와 밑변을 나타냄

# 방향이 한번만 나온 것들 끼리의 곱 => 전체 직사각형의 크기
# 방향이 두번씩 나온 것들 끼리의 곱 => 작은 직사각형의 크기

# 전체 직사각형의 크기 - 작은 직사각형의 크기 = S
# SM -sm
# S*k 가 정답.

for i in range(6):
    # vec, dis
    vdList[i] = list(map(int, input().split()))
    vList[vdList[i][0]] += 1

for j in range(6):
    if vList[vdList[j][0]] == 1:
        if vdList[j][0] == 3 or vdList[j][0] == 4:
            h = vdList[j][1]
        if vdList[j][0] == 1 or vdList[j][0] == 2:
            l = vdList[j][1]

flag1 = True
flag2 = True

k = 0
sh = 0;sl = 0

while flag1 or flag2:
    if flag1 and vdList[k][1] == l:
        k += 3
        if k > 5:
            k -= 6
            sl = vdList[k][1]
            k += 3
        else:
            sl = vdList[k][1]
            k -= 3
        flag1 = False
        
    if flag2 and vdList[k][1] == h:
        k += 3
        if k > 5:
            k -= 6
            sh = vdList[k][1]
            k += 3
        else:
            sh = vdList[k][1]
            k -= 3
        flag2 = False
    k += 1
    
S = l*h
s = sl*sh
print((S-s)*t)

# 7
# 1 60
# 3 20
# 1 100
# 4 50
# 2 160
# 3 30
