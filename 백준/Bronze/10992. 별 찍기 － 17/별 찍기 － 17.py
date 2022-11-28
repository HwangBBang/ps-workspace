n = int(input())
def star(n):
    if n == 1:
        print("*")
    else:
        print("*",end="")
        for o in range(2*(n-1)-1):
            print(" ",end="")
        print("*")

for i in range(1,n+1):
    for k in range(n-i,0,-1):
        print(" ",end="")
    if i == n:
        for u in range(2*(n-1)+1):
            print("*",end="")
    else:
        star(i)
    

# star(1)
# star(2)
# star(3)
# star(4)
