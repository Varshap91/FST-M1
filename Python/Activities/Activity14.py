def fibonacci(number):
    if number <= 1:
        return number
    else:
        return (fibonacci(number - 1) + fibonacci(number - 2))


fib = int(input("Enter a number: "))

print("Fibonacci Sequence: ")
for i in range(fib):
    print(fibonacci(i))
