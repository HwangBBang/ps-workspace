import sys
input = sys.stdin.readline
n = int((input()))

arr = []
stack = []
newArr = []
result = []
for i in range(n):
    arr.append(int(input()))

flag = True
j = 0

while flag:
    if j == n :
        break
    for i in range(1,n+1):
        if len(newArr) == n:
            flag = False
        stack.append(i)
        result.append("+")
        while True:
            if len(stack) == 0 or j == n:
                flag = False
            if len(stack) > 0 and arr[j] == stack[-1]:
                newArr.append(stack.pop()); 
                result.append("-")
                j+=1
            else:
                break
    flag = False

if arr == newArr:
    for k in range(len(result)):
        print(result[k])
else:
    print("NO")

# 4 3 6 8 7 5 2 1

# ///// (입구)

# 1
# 1 2 
# 1 2 3
# 1 2 3 4 
# 1 2 3 (pop)
# 1 2 (pop)
# 1 2 5
# 1 2 5 6
# 1 2 5 (pop)
# 1 2 5 7
# 1 2 5 7 8
# 1 2 5 7 (pop)
# 1 2 5 (pop)
# 1 2 (pop)
# 1 (pop)
# (pop)
