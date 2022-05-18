def d(n):
    n =n + sum(map(int, str(n)))
    return n
Not_selfNum = set() #selfnum 아닌것을 집합에 쳐넣음

for i in range (1,10001):
    Not_selfNum.add(d(i))
for i in range (1,10001):
    if not i in  Not_selfNum:
        print (i)