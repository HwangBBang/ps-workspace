from collections import Counter
import math
n = input()
# 가장 많이 나온놈이 뭐냐? (6,9를 제외한 수 중)
n = Counter(n).most_common()

cnt = 0
cnt69 = 0

for i in range(0,len(n)):
    if n[i][0] != '6' and n[i][0] != '9' :
        if cnt < n[i][1]:
            cnt = n[i][1]
    # 6,9 일 때
    else:
        cnt69 += n[i][1]
    
if cnt < math.ceil(cnt69/2):
    print(math.ceil(cnt69/2))
else:
    print(cnt)