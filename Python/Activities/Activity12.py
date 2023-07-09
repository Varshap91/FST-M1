def findSum(n):
    if n:
        return n + findSum(n - 1)
    else:
        return 0


res = findSum(10)
print("The sum is: ", res)
