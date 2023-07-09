import pandas

dataframe = pandas.read_csv('credentials.csv')
print(dataframe)

print(" ")
print(dataframe["Usernames"])

print(" ")
print("Second credential: ")
print("Username: ", dataframe["Usernames"][1], " | ", "Password: ", dataframe["Passwords"][1])

print(" ")
print("Usernames in Ascending order")
print(dataframe.sort_values("Usernames"))

print(" ")
print("Passwords in Descending order")
print(dataframe.sort_values("Passwords", ascending=False))