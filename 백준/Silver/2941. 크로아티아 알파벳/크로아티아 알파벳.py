S= input()

comp = ['c=', 'c-', 'dz=', 'd-', 'lj', 'nj', 's=', 'z=']


for char in comp:
    S = S.replace(char , "1")


print(len(S))