import sys,math
input = sys.stdin.readline

# 테케 갯수
T = int(input())

# x1, y1 시작
# x2, y2 종료

# 시작/종료점 중 하나만 어떤 원안에 있다면 +1
# 시작/종료점 둘 다 어떤 원안에 있다면 0
# 시작/종료점 둘 다 어떤 원밖에 있다면 0

def isIn(sample, x, y):
    cx = sample[0]
    cy = sample[1]
    r = sample[2]

    d = math.sqrt(pow(cx - x, 2)+pow(cy - y, 2))
    # 원 안에 있다면?
    if d <= r:
        return True
    else:
        return False
# 함수 종료

for _ in range(T):
    x1, y1, x2, y2 = map(int,input().split())
    n = int(input())
    count = 0
    
    circle = [0 for _ in range(n)]
    for i in range(n):
        circle[i] = list(map(int,input().split()))
        if isIn(circle[i], x1, y1) and isIn(circle[i], x2, y2):
            continue
        elif isIn(circle[i], x1, y1) or isIn(circle[i], x2, y2):
            count += 1
        else:
            continue
    print(count)


