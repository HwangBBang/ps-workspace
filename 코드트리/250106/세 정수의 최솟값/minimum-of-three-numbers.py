a,b,c=map(int,input().split(" "))
#최솟값 우케구해?논리 연산자로로
#그래서 최솟값이 뭔데->세수중에서 가장 작은거거
#또 최솟값이 될수 있는건? ->a,b,c
#a가최소일때
if a<=b<=c:
    print(a)
#b가최솟값일때
if b<=a<=c:
    print(b)
# c가 최솟값일때
if c<=b<=a:
    print(c)
    