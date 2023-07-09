def sum(num):
    sum1 = 0
    for n in num:
        sum1 += n
    return sum1

myList = [10, 16, 3, 9, 12, 7]

result = sum(myList)

print("Sum of all items in list: " + str(result))


