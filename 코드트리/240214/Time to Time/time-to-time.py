a, b, c, d = map(int, input().split())

h = c - a
m = d - b

if m < 0 : 
    h -= 1
    m = m+ 60 

res =  h * 60 + m 
print(res)