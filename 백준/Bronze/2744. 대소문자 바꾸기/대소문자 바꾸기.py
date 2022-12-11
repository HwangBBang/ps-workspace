
import sys
input = sys.stdin.readline


n = input().rstrip()
n = list(n)
for i in range(len(n)):
    if n[i].isupper():
        n[i] = n[i].lower()
    else:
        n[i] = n[i].upper()


n = "".join(n)
print(n)
