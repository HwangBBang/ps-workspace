
while True:
    s = input()
    if s == "0":
        break
    rs = "".join(reversed(s))
    if s == rs:
        print("yes")
    else:
        print("no")

