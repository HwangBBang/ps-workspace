rightEye=float(input())
leftEye=float(input())
if rightEye>=1 and leftEye>=1:
    print("High")
elif rightEye>=0.5 and leftEye>=0.5:
    print("Middle")
else:
    print("Low")
    