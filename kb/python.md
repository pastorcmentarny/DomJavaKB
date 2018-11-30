List of basics that it is worth to remember
* break get out from loop
* continue go back to beginning to loop
* pip3 install -r x.txt
  * install all libs from file
* name = None #Python is dynamic, so you don't need to declare things;
* Although the string value of a number is considered a completely different value from the integer or floating-point version, an integer can be equal to a floating point.
* name = None  # Python is dynamic, so you don't need to declare things;
* There are some values in other data types that conditions will consider equivalent to True and False. When used in conditions, 0, 0.0, and '' (the empty string) are considered False, while all other values are considered True.
* Data types: Integer, Floating-Point, and String
* ```not True```   not operate on only single value
* **var** as one word can have alphanumeric with _ but cannot start with number.
* Variable names are **_case-sensitive_**, meaning that spam, SPAM, Spam, and sPaM are four different variables. It is a Python convention to start your variables with a lowercase letter.
* -1 in list index means last value. -2 means second to the last and so on!
``` +---+---+---+---+---+---+---+
    | D | o | m | i | n | i | k |
    +---+---+---+---+---+---+---+
      0   1   2   3   4   5   6
     -7  -6  -5  -4  -3  -2  -1
```
* change multiple elements in list
```python
table = ['apples', 'oranges', 'cherries', 'banana']
table[1:3] = ['mango', 'blueberry', 'blackberry'] # change multipe elements in list
print(table)
```
* All Python programs can call a basic set of functions called built-in functions, including the print(), input(), and len() functions you’ve seen before. Python also comes with a set of modules called the standard library. Each module is a Python program that contains a related group of functions that can be embedded in your programs.
An alternative form of the import statement is composed of the from keyword, followed by the module name, the import keyword, and a star; for example, from random import *.

 With this form of import statement, calls to functions in random will not need the random. prefix. However, using the full name makes for more readable code, so it is better to use the normal form of the import statement.



### **Class**
#### _object, self and `__init__`_
* Classes can be thought of as blueprints for creating objects.
* self is the instance of the Class that withdraw is being called on.
* unit.doesDamage(25) is just shorthand for Unit.withdraw(unit, 25), which is perfectly valid (if not often seen) code.
* `__init__`, we initialize objects
* The rule of thumb is, don't introduce a new attribute outside of the `__init__` method, otherwise you've given the caller an object that isn't fully initialized. 
* It should be impossible for an object to get into an invalid state just by calling its methods. It goes without saying, then, that an object should start in a valid state as well, which is why it's important to initialize everything in the __init__ method.
*  Methods have access to all the data contained on the instance of the object; they can access and modify anything previously set on self. 
* they use self, they require an instance of the class in order to be used. For this reason, they're often referred to as "instance methods".
* @decoratorexample for example 
```python
@staticmethod
```

### The Operators

* The ** operator is evaluated first; the *, /, //, and % operators are evaluated next, from left to right; and the + and - operators are evaluated last (also from left to right).
* The while loop keeps looping while its condition is True
* You can use break and continue statements inside for loops as well. The continue statement will continue to the next value of the for loop’s counter, as if the program execution had reached the end of the loop and returned to the start. In fact, you can use continue and break statements only inside while and for loops. If you try to use these statements elsewhere, Python will give you an error.
* Division (/) always returns a float. To do floor division and get an integer result (discarding any fractional result) you can use the // operator; to calculate the remainder you can use %:
* rounding The behavior of round() for floats can be surprising: for example, round(2.675, 2) gives 2.67 instead of the expected 2.68. This is not a bug: it’s a result of the fact that most decimal fractions can’t be represented exactly as a float. See Floating Point Arithmetic: Issues and Limitations for more information.


Basics that will be deleted shortly    
```python
print(2 ** 3)  # Exponent
print(8 % 3) # Module
print(22 // 8)  # Integer division
print(22 / 8)  # Normal division
# None - represent lack of value,
d = print()
print(d == None)
print('dom', end='')
print('i', end='-')
print('nik')
print('goodbye')
def local():
    alien = 'vulcan'
    print(alien)


def globaly():
    global alien  # it suggest that alien use global
    alien = 'klingon'
    print(alien)


alien = 'earthlings'
print(alien)
local()
print(alien)
globaly()
print(alien)

listExample = ['cheese', 'garlic', 'mushroom', 'chili']
print(listExample[1: 3])
pakChoi = 'pak choi'
listExample *= 3
del listExample[6:9]
# A common Python technique is to use range(len(someList)) with a for loop to iterate over the indexes of a list.

for i in range(len(listExample)):
    print('In list example index no. ' + str(i) + ' is ' + listExample[i])

# 'in' and 'not in' are used in expressions and connect two values:
# a value to look for in a list and the list where it may be found.

result = 'ham' in listExample
print(result)
result = 'ham' not in listExample

params = ['dom', 32, 'software developer']
name, age, job = params
print(name + ' is ' + str(age) + ' years old and he works as ' + job)
# When there are duplicates of the value in the list,
# the index of its first appearance is returned.

listExample.append(garlic)
# append() method call adds the argument to the end of the list.
# The insert() method can insert a value at any index in the list.

# List works in different way.
# When you assign a list to a variable, you are actually assigning a list reference to the variable.
# Variables will contain references to list values rather than list values themselves.
# But for strings and integer values, variables simply contain the string or integer value.
# Python uses references whenever variables must store values of mutable data types, such as lists or dictionaries.
# For values of immutable data types such as strings, integers, or tuples, Python variables will store the value itself.

counter = [0, 1, 2, 3, 4, 5]
digits = counter
counter[1] = "1 1 1"
print('counter:' + str(counter) + ' digits: ' + str(digits))


# copy() can be used to make a duplicate copy of a mutable value like a list or dictionary,
# not just a copy of a reference.

cats = [{'age': 13, 'name': 'Puszek'}, {'age': 9, 'name': 'Reksio'}]
cats += [name]
def d42by(by):
    try:
        return 42 / by
    except ZeroDivisionError:
        print('you cannot divide by zero')
        
for sym, w, h in (('*', 4, 4), ('O', 20, 5), ('x', 1, 3), ('ZZ', 3, 3)):
    try:
        boxPrint(sym, w, h)
    except Exception as err:
        print('Shocking! An exception happen: ' + str(err))
      startTime = time.time()
      
if not os.path.exists(destination):
    os.makedirs(destination, exist_ok=True)


for i in range (-5,-1,1):
    print(i)
```


main method in python:
```python
# when python run a file it set a few attributes for example file that is run __name__ 
# for file that it starts from give name main -> __main__ that

def main():
    print("Run main method")
    
if __name__ == '__main__':
    main()

```


Resources:
https://www.youtube.com/watch?v=sugvnHA7ElY