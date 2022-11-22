from collections import Counter

X = [None]*3
Y = [None]*3

for i in range(3):
    X[i], Y[i] = map(int, input().split())

xCnt = Counter(X)
yCnt = Counter(Y)

# key 와 벨류 값을 바꿔준다. get()을 쓰기위해서
reverseX = dict(map(reversed,xCnt.items()))
reverseY = dict(map(reversed, yCnt.items()))

# 벨류가 1인 것들을 출력
print(reverseX.get(1), reverseY.get(1))
