color = ['black', 'brown', 'red', 
'orange', 'yellow', 'green', 'blue', 'violet', 'grey', 'white']

f = color.index(input())
s = color.index(input())
t = color.index(input())
r = int(str(f) + str(s)) * (10 ** t)
print(r)