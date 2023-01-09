
n = int(input())

for i in range(1,n+1):
    dice1, dice2 = map(int,input().split())
    res= dice1+dice2
    print("Case %d: %d" %(i ,res))