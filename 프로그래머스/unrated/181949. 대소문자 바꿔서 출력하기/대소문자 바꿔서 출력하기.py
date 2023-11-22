str = input()
res = []
for i, s in enumerate(str):
    if chr(65) <= s and s <= chr(65+25):
        res.append(chr(ord(s)+32))
    elif chr(97) <= s and s <= chr(97+25):
        res.append(chr(ord(s)-32))

print(*res, sep="")
