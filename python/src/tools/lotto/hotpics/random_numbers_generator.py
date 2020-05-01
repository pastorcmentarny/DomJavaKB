import random

numbers = []
for i in range(1, 60):
    if i != 2 or i != 32 or i != 35 or i != 42:
        numbers.append(i)
random.shuffle(numbers)

count = 1
for i in numbers:
    print(i)
    count += 1
    if count == 7:
        count = 1
        print()
