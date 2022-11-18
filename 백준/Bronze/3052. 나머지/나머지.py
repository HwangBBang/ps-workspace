box=[];count = 0
for i in range(10):
    box.append(int(input()))
    box[i] = box[i]%42

for j in range(42):
    if j in box:
        count+=1
print(count)