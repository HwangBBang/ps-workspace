import sys
from collections import Counter
n = int(sys.stdin.readline())
A=[None]*n
for i in range(n):
    A[i] = int(sys.stdin.readline())
A.sort()

#1
aver = sum(A)/n
if -0.5<aver and aver<0:
    print(0)
else:
    print("%.0f" %aver)
#2
print(A[n//2])
#3
cntA = Counter(A).most_common()
if len(cntA) > 1:
    if cntA[0][1]==cntA[1][1]:
        print(cntA[1][0])
    else:
        print(cntA[0][0])
else:
    print(cntA[0][0])
#4
print(A[-1]-A[0])