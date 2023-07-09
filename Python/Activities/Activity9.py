list1 = list(input("Enter a sequence of comma separated values: ").split(", "))
list2 = list(input("Enter a sequence of comma separated values: ").split(", "))

list3 = []

for item in list1:
    if (int(item) % 2 != 0):
        list3.append(item)

for item in list2:
    if (int(item) % 2 == 0):
        list3.append(item)

txt = "Final List is: {}"
print(txt.format(list3))