
n = int(input())
temp = 0; count = 0; next = 0
conf = n
while 1:
    temp = n//10 + n%10
    next = (n%10)*10 + temp%10
    count += 1
    n = next
    if n == conf:
        print(count)
        break

