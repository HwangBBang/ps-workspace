A = [x for x in range(1,31)]

for i in range(28):
    A.remove(int(input()))



print(min(A))
print(max(A))
