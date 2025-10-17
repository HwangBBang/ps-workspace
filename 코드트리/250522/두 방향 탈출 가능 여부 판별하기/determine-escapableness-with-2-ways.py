

# for i in range(1,41,1):

#  순 회  돌아라  뭐를? iterable object

# for i in range()
# 반복가능한 객체 : range()

# 반복가능한 객체
# 반복가능한 객체는 뭐에요? 어떻게 구분하죠?
# 반복가능한 객체 : 반복가능한 (객체 == 어떤 것)


# str
#         iterable
# 1         | X | 객체 int
# "@31"     | O | 객체 str
# "1"       | O | 객체 str
# 43141.31  | X | 객체 float
# False     | X | 객체 bool
# [1]       | O | 객체 list
# [1,1,1]   | O | 객체 list
# range()   | O | 객체 range


# 배 열
# 문자 열

# 기본형..
# 참조형..

# 판단 근거..?
# int, bool, float


# print(type(range(0)))
# print(type([1, 414, 3]))
# for i in "1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1":
# print(i)

# for


# 별로 없엉,, for 개좋아 ! 컨트롤이 쉬워요
# 기말에 어려워

# while

# 쌤 이번에 차샀어
# => 무슨 차요?

# 영화  "총"이 나와
# 반드시 ... 쏴야해

#  별표 찍기 1.

# n = 4
# *
# * *
# * * *
# * * * *


# n = 6
# *
# * *
# * * *
# * * * *
# * * * * *
# * * * * * *

# 반복해서 출력

#  n 을 받음 ..
# n 의 의미?

# n = int(input())

# for i in range(1, n+1):  # 행
#     print("* " * i)

# ==============
def rangeOut(nextRow, nextColumn):
    global n
    global m
    return nextRow < 0 or nextRow >= n or nextColumn < 0 or nextColumn >= m  # true


def sol(r, c):
    global n
    global m
    global result
    if r == n-1 and c == m-1:
        result = 1
        return

    for i in range(2):
        nr = r + dR[i]
        nc = c + dC[i]

        if rangeOut(nr, nc):
            continue

        if v[nr][nc]:
            continue

        if grid[nr][nc] == 0:
            continue

        v[nr][nc] = True
        sol(nr, nc)


global n
global m
global result

dR = [1, 0]
dC = [0, 1]

result = 0

n, m = map(int, input().split())

v = [[False for _ in range(m)] for _ in range(n)]
grid = []
for i in range(n):
    grid.append(list(map(int, input().split())))


sol(0, 0)
print(result)
