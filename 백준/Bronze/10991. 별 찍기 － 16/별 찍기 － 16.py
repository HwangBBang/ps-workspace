n = int(input())
def star(n):
    if n == 1:
        print("*")
    else:
        for o in range(n-1):
            print("*",end=" ")
        print("*")

for i in range(1,n+1):
    for k in range(n-i,0,-1):
        print(" ",end="")
    star(i)
    

# star(1)
# star(2)
# star(3)
# star(4)
