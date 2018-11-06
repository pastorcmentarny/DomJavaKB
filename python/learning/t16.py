import random

name = None #Python is dynamic, so you don't need to declare things;
counter = 0

while True:
    counter += 1

    if name != 'Dominik':
        print('And you are ?')
        name = input()

    if name != 'Dominik':
        continue

    print('Warm welcome' + name + '! What\'s your password?')

    password = random.randint(0, 100)
    if password == 10:
        break

    print('Access DENIED')

print('Access granted. You needed ' + str(counter) + ' times to hack into this system. Enjoy reset of your mission...')


#There are some values in other data types that conditions will consider equivalent to True and False. When used in conditions, 0, 0.0, and '' (the empty string) are considered False, while all other values are considered True.


unit = None
while not unit:
    print('type anything on keyboard to continue:')
    unit = input()

# This an example app to shows that isX string methods are helpful when you need to validate user input.

while True:
    print('Enter title')
    title = input()
    if title.istitle() and len(title) > 1:
        break
    print("title must start from upper case and be longer than 1 character")

while True:
    print('Enter year')
    year = input()
    if year.isdecimal() and 1900 <= int(year) <= 2100:
        break
    print('it supports songs created between 1900 and 2100')

print(title + "(" + year + ")")

line = '====== -------- <  < <<>> >  > -------- ======'
# The ** operator is evaluated first; the *, /, //, and % operators are evaluated next, from left to right; and the + and - operators are evaluated last (also from left to right).
# Math

print(3 * 5)
print(((2 + 2) * 2) ** (1 + 1))

# * operator used on one string and  integer is a   string replication operator.
print('string' * 6)

work = 37.5
print(work)
work = 'hello'
print(work)


# input fun ,so not in use
# print('Warm welcome! Who are you ?')
# name = input()
# print()
# print('It is nice to meet you ' + name + '. You name is ' + str(len(name)) + ' characters long.')

# value that is passed to a function call is an argument.

print(len(''))
print('I am ' + str(34) + ' years old.')
varOfIntStringOrFloat = str(0)
print(varOfIntStringOrFloat)
piNumber = 3.14
varOfIntStringOrFloat = str(piNumber)
print(varOfIntStringOrFloat)
varOfIntStringOrFloat = int(piNumber)
print(varOfIntStringOrFloat)
varOfIntStringOrFloat = float(piNumber)
print(varOfIntStringOrFloat)
varOfIntStringOrFloat = float(10)

# to use # comment use ctrl+/ shortcut
# print('type number 1:')
# a = int(input())
# print('type number 2:')
# b = int(input())
# print(a + b)


# Although the string value of a number is considered a completely different value from the integer or floating-point version, an integer can be equal to a floating point.
print(42 == '42')
print(42 == 42.00000)
print(42 == 0042.01)

# rouding The behavior of round() for floats can be surprising: for example, round(2.675, 2) gives 2.67 instead of the expected 2.68. This is not a bug: it’s a result of the fact that most decimal fractions can’t be represented exactly as a float. See Floating Point Arithmetic: Issues and Limitations for more information.

print(round(2.675, 2))

# the Boolean values True and False lack

t = True
f = False
print(t == f)

# Operator  Meaning
#
# ==  Equal to
print(6 == 6)
print(6 != 8)
# !=  Not equal to
print(6 != 6)
print(6 != 8)
# <  Less than
print(6 < 8)
print(8 < 8)
# >  Greater than
print(6 > 4)
print(8 > 8)
# <=  Less than or equal to
print(6 <= 8)
print(8 <= 8)
print(8 <= 6)
# >=  Greater than or equal to
print(9 >= 8)
print(8 >= 8)
print(8 >= 9)

print()
# The <, >, <=, and >= operators, on the other hand, work properly only with integer and floating-point values.

# The three Boolean operators (and, or, and not) are used to compare Boolean values.

print(line)
print('Boolean stuff ....')
print(True and True)
print(True or False)
print(not False)
print(not not not not not False)
print(not ((4 > 3) or (3 >= 4)) and True)

# Python evaluates the not operators first, then the and operators, and then the or operators.

print('What\'s your name?')
name = input()
print('Warm welcome' + name + '\nYour secret password is ?')
password = input()
if password == 'password':
    print('very clever ..')
else:
    if password == '123456':
        print("Access granted")
    else:
        print('Access DENIED')

cats = [{'desc': 'chubby', 'name': 'Zophie'}, {'desc': 'fluffy', 'name': 'Pooka'}]

line = '====== -------- <  < <<>> >  > -------- ======'
# The ** operator is evaluated first; the *, /, //, and % operators are evaluated next, from left to right; and the + and - operators are evaluated last (also from left to right).
# Math

print(3 * 5)
print(((2 + 2) * 2) ** (1 + 1))

# * operator used on one string and  integer is a   string replication operator.
print('string' * 6)

work = 37.5
print(work)
work = 'hello'
print(work)


# input fun ,so not in use
# print('Warm welcome! Who are you ?')
# name = input()
# print()
# print('It is nice to meet you ' + name + '. You name is ' + str(len(name)) + ' characters long.')

# value that is passed to a function call is an argument.

print(len(''))
print('I am ' + str(34) + ' years old.')
varOfIntStringOrFloat = str(0)
print(varOfIntStringOrFloat)
piNumber = 3.14
varOfIntStringOrFloat = str(piNumber)
print(varOfIntStringOrFloat)
varOfIntStringOrFloat = int(piNumber)
print(varOfIntStringOrFloat)
varOfIntStringOrFloat = float(piNumber)
print(varOfIntStringOrFloat)
varOfIntStringOrFloat = float(10)

# to use # comment use ctrl+/ shortcut
# print('type number 1:')
# a = int(input())
# print('type number 2:')
# b = int(input())
# print(a + b)


# Although the string value of a number is considered a completely different value from the integer or floating-point version, an integer can be equal to a floating point.
print(42 == '42')
print(42 == 42.00000)
print(42 == 0042.01)

# rouding The behavior of round() for floats can be surprising: for example, round(2.675, 2) gives 2.67 instead of the expected 2.68. This is not a bug: it’s a result of the fact that most decimal fractions can’t be represented exactly as a float. See Floating Point Arithmetic: Issues and Limitations for more information.

print(round(2.675, 2))

# the Boolean values True and False lack

t = True
f = False
print(t == f)

# Operator  Meaning
#
# ==  Equal to
print(6 == 6)
print(6 != 8)
# !=  Not equal to
print(6 != 6)
print(6 != 8)
# <  Less than
print(6 < 8)
print(8 < 8)
# >  Greater than
print(6 > 4)
print(8 > 8)
# <=  Less than or equal to
print(6 <= 8)
print(8 <= 8)
print(8 <= 6)
# >=  Greater than or equal to
print(9 >= 8)
print(8 >= 8)
print(8 >= 9)

print()
# The <, >, <=, and >= operators, on the other hand, work properly only with integer and floating-point values.

# The three Boolean operators (and, or, and not) are used to compare Boolean values.

print(line)
print('Boolean stuff ....')
print(True and True)
print(True or False)
print(not False)
print(not not not not not False)
print(not ((4 > 3) or (3 >= 4)) and True)

# Python evaluates the not operators first, then the and operators, and then the or operators.

print('What\'s your name?')
name = input()
print('Warm welcome' + name + '\nYour secret password is ?')
password = input()
if password == 'password':
    print('very clever ..')
else:
    if password == '123456':
        print("Access granted")
    else:
        print('Access DENIED')

shopping_items = {'toilet paper': 2,
                  'kefir': 6,
                  'lemon': 1,
                  'cheese': 1,
                  'cheesecake cookies': 16886
                  }


def shopping_list(items, left_width, right_width):
    print_title(left_width, right_width)
    print_items(items, left_width, right_width)


def print_items(items, left_width, right_width):
    for k, v in items.items():
        print(k.ljust(left_width, '.') + str(v).rjust(right_width, ' '))


def print_title(left_width, right_width):
    print('SHOPPING LIST'.center(left_width + right_width, "-"))


shopping_list(shopping_items, 30, 6)
