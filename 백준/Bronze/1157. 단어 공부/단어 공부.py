from collections import Counter

S = input()
S = S.upper()
sCnt = Counter(S).most_common()
if len(S)>1:
    if sCnt[0][1] == sCnt[1][1]:
        print("?")
    else:
        print(sCnt[0][0])
else:
    print(sCnt[0][0])
