from collections import Counter

import sys
input = sys.stdin.readline

cards = []

for _ in range (int(input())):
    cards.append(int(input()))


cards = Counter(cards).most_common()

cards.sort(key= lambda x :(-x[1],x[0]))

print(cards[0][0])
