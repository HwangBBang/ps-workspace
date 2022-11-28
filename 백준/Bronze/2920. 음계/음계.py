sound = list(map(int, input().split()))
comp1 = [i for i in range(1, 9)]
comp2 = [i for i in range(8, 0,-1)]


def check1(sound, comp1):
    for j in range(8):
        if sound[j] != comp1[j]:
            return False
        else:
            if j == 7:
                return True
def check2(sound, comp2):
    for k in range(8):
        if sound[k] != comp2[k]:
            return False
        else:
            if k == 7:
                return True


if check1(sound, comp1):
    print("ascending")
elif check1(sound, comp2):
    print("descending")
else:
    print("mixed")

# 1 7 2 6 3 5 4 8
