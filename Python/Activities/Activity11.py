fruit_dict = {
    "apple": 172,
    "orange": 120,
    "pear": 260
}

fruit = input("Search for the fruit: ")
if (fruit in fruit_dict):
    print("Banana is present in the dictionary")
else:
    print("Banana is not present in the dictionary")
