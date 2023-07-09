tuple1 = tuple(input("Enter a sequence of comma separated values: ").split(", "))

for item in tuple1:
    if (int(item) % 5 == 0):
        print(item)