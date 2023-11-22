from collections import Counter

def solution(nums):
    answer = 0
    n = len(nums)
    nums = Counter(nums)
    c = len(nums)
    
    if n//2 >= c:
        return c
    else: 
        return n//2
    
    