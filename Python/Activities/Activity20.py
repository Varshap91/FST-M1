import pandas

dataframe = pandas.read_excel("userDetails.xlsx", sheet_name="Sheet1")

print(dataframe)

print(" ")
print("Number of rows and columsn: ", dataframe.shape)

print(" ")
print("Data in the emails column")
print(dataframe["Email"])

print(" ")
print("Data sorted by Firstname")
print(dataframe.sort_values("FirstName"))