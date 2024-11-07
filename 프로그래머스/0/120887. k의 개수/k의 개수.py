from collections import Counter
def solution(i, j, k):
    counts = Counter()
    k = str(k)
    
    for num in range(i, j+1, 1):
        parsedStr = str(num)
        counts = counts + Counter(parsedStr)

    if k in counts.keys():
        return counts.get(k)
    return 0
