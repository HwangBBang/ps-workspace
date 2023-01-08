s = input()

for i in range(len(s)):
    print(s[i],end="")
    if i%10 == 9:
        print()
