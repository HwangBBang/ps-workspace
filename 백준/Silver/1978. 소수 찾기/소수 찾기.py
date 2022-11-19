n = int(input())
box = list(map(int, input().split()))
cunt = 0
prime_cunt = 0
for i in range (n):    
    for j in range(1,box[i]+1):
        if box[i]%j == 0 :
            cunt += 1
    if cunt == 2:
        prime_cunt+=1
    cunt = 0
print(prime_cunt)