# inputSentence = '''
#  The setdefault() method is a nice shortcut to ensure that a key exists.
#   Here is a short program that counts the number of occurrences of each letter in a string.'''


result = 17 / 4 * 3 - 1 ** 2
print(result)

result = 17 // 3
print(result)

result = 17 // result + 17 % result
print(result)

result = 1j
print(result)

result = 1j ** 3  # need to learn how to use imaginary number
print(result)

# raw string If you don’t want characters prefaced by \ to be interpreted as special characters, you can use raw strings by adding an r before the first quote:
print(r'C:\to\nowhere')
print('C:\to\nowhere')

print('moon' * 10)

print('I wish Dominik pay more attention to coding'
      ' instead of wasting time on learning Python')

# Strings can be indexed (subscripted), with the first character having index 0 / However, out of range slice indexes are handled gracefully when used for slicing:


result = 'abcdefgh'

for character in result:
    print('character:' + character)

print(result[0], result[2])  # starts from 0 (first character)
print(result[-8], result[-6])  # starts from -1 (last character)

# slicing in string
result = 'Dominik'
print(result[:3] + result[3:])
print(result[0:3] + result[3:len(result)])

# String is immutable so you cannot do this result[0] = J but you can:
result = 'J' + result[1:]
print(result)

# Lists

result = [1, 4, 9, 16, 25]
print(result)
print(str(result[0]) + "::" + str(result[-5]))

# All slice operations return a new list containing the requested elements. This means that the following slice returns a new (shallow) copy of the list:

result += [36, 49, 64, 81, 100, 121]
print(result)
print('size: ' + str(len(result)))

# Unlike strings, which are immutable, lists are a mutable type, i.e. it is possible to change their content:

result[0] = 2
print(result)
result[0] = 1
result.append(12 ** 2)
print(result)

result[2:5] = []  # remove values for 3,4 and 5th element

print(result)
result[:] = []
print(result)

result = [[1, 3, 5, 7, 9], [2, 4, 6, 8]]
print(result[1][2])  # 6

var = 128 * 3
print('Value of var is', var)

# ]	Since ** has higher precedence than -, -3**2 will be interpreted as -(3**2) and thus result in -9. To avoid this and get 9, you can use (-3)**2.
