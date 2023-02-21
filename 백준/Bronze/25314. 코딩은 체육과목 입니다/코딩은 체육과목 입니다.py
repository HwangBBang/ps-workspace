
default = "long int"

n = int(input())

for _ in range ((n // 4) -1):
    default = "long " + default

print(default)