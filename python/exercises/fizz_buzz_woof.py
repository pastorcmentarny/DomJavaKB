for number in range(358):
    if number % 3 == 0:
        print(str(number) + "Fizz")
    if number % 5 == 0:
        print(str(number) + "Buzz")
    if number % 7 == 0:
        print(str(number) + "Woof")

    if number % 3 == 0 and number % 5 == 0 and number % 7 == 0:
        print(str(number) + "!")
