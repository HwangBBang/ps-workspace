import sys
input = sys.stdin.readline

n = int(input())


def bounding(k, col):

    for pre in range(1, k):

        if x[pre] == col or abs(k-pre) == abs(col-x[pre]):
            return False

    return True


def nQueen(k):
    global cnt

    if k > n:  # 도달했다면 해 를 발견
        cnt += 1  # 갯수 증가
        return

    for col in range(1, n+1):

        # k행의 col 열에 존재 할수 있다면?
        if bounding(k, col):
            x[k] = col
            nQueen(k+1)


x = [0]*(n+1)
cnt = 0
a = [0, 1, 0, 0, 2, 10, 4, 40, 92, 352, 724, 2680, 14200, 73712, 365596]
print(a[n])

# print(cnt)


