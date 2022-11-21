
box =[]
for i in range(9):
    box.append(int(input()))
print(max(box))
for j in range(9):
    if max(box) == box[j]:
        print(j+1)