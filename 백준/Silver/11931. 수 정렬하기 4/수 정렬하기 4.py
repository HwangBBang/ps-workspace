import sys
input = sys.stdin.readline


box =[]

for _ in range (int(input())):
    box.append(int(input()))

box.sort(reverse=True)

for i in range (len(box)):
    print(box[i])


