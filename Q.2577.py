
A = int(input())
B = int(input())
C = int(input())
Mul = A*B*C
count = [0 for i in range (10)]
    
list_mul = list(map(int, str(Mul)))
for i in range (len(list_mul)):
    for j in range (10):
        if list_mul[i] == j:
            count[j] += 1
for i in range (10):
    print(count[i])
