

Arr = [0]*5
for i in range(5):
    a = int(input())
    if a >= 40:
        Arr[i] = a
    else:
        Arr[i] = 40

print(sum(Arr)//5)