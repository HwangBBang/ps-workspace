

s = input()
comp = []
count = []
for alpha in range(97,123):
    comp.append(chr(alpha))
    count.append(0)

for x in s:
    count[comp.index(x)] += 1

for i in count:
    print(i,end=" ")


