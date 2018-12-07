 A statement in C++ is the smallest independent unit in the language.

Statements in C++ are terminated by a semicolon.

int x is a declaration statement. It tells the compiler that x is a variable.

x = 5 is an assignment statement.

An expression is a combination of literals, variables, operators, and functions that evaluates to a value. 

A function is a collection of statements that executes sequentially.

Every C++ program must contain a special function called main(). When the C++ program is run, execution starts with the first statement inside of main().

Libraries are groups of functions that have been “packaged up” for reuse in many different programs.

A comment is a line (or multiple lines) of text that are inserted into the source code to explain what the code is doing.
- At the library, program, or function level, describe what 
- Inside the library, program, or function, describe how 
- At the statement level, describe why.

A variable in C++ is a name for a piece of memory that can be used to store information.

 An integer is a whole number.

Rule: Always assign values to your variables when you declare them.

A function call is an expression that tells the CPU to interrupt the current function and execute another function.

calls (executes)

A return type of void means the function does not return a value.

In the statement, ReturnNothing() returns void. It is not valid to pass void to cout, and the compiler will give you an error when you try to compile this line.

A good rule of thumb is that each function should perform one (and only one) task.

Operators tell how to combine the operands to produce a new result.

Rule: When addressing compile errors in your programs, always resolve the first error produced first.

In a forward declaration, we declare (but do not define) our function in advance of where we use it, typically at the top of the file. 

A function prototype is a declaration of a function that includes the function’s name, parameters, and return type, but does not define the function.

Keep in mind that header files typically only contain declarations.

Rule: Use angled brackets to include header files that come with the compiler. Use double quotes to include any other header files.

Rule: use the non .h version of a library if it exists, and access the functionality through the std namespace. If the non .h version does not exist, or you are creating your own headers, use the .h version

The preprocessor is perhaps best thought of as a separate program that runs before the compiler when you compile your program. It’s purpose is to process directives. 

Directives are specific instructions that start with a # symbol and end with a newline (NOT a semicolon).

#Include tells the preprocessor to insert the contents of the included file into the current file at the point of the #include directive

#define identifier replacement.Whenever the preprocessor encounters this directive, any further occurrence of ‘identifier’ is replaced by ‘replacement’.(A magic number is a hard-coded number in the middle of the code that does not have any context — what does 122 mean? To avoid this we used #define)

The conditional compilation preprocessor directives allow you to specify under what conditions something will or won’t compile.

The #ifdef preprocessor directive allow the preprocessor to check whether a value has been previously #defined. If so, the code between the #ifdef and corresponding #endif is compiled. If not, the code is ignored.

Header guards.Because header files can include other header files, it is possible to end up in the situation where a header file gets included multiple times.To prevent this from happening, we use header guards, which are conditional compilation directives that take the following form:
To prevent this from happening, we use header guards, which are conditional compilation directives that take the following form:
#ifndef SOME_UNIQUE_NAME_HERE
#define SOME_UNIQUE_NAME_HERE
// your declarations here
#endif

The smallest unit of memory is a binary digit (bit), which can hold a value of 0 or 1.

Memory is organized into individual sections called addresses.

When we assign values to a variable using the assignment operator (equals sign), it’s called an explicit assignment:

int nValue = 5; // explicit assignment 

int nValue(5); // implicit assignment

Rule: Declare variables where they are needed.

The name of a variable, function, class, or other entity in C++ is called an identifier. 

An integer type variable is a variable that can only hold whole numbers

a variable with n bits can store 2^n different values. We call the set of values that a data type can hold it’s range. 

Overflow occurs when bits are lost because a variable does not have enough memory to store them.

pe of this tutorial, but it is very similar to how numbers are written in scientific notation. Scientific notation is a useful shorthand for writing lengthy numbers in a concise manner. In scientific notation, a number has two parts: the significand, and a power of 10 called an exponent. The letter ‘e’ or ‘E’ is used to separate the two parts. Thus, a number such as 5e2 is equivalent to 5 * 10^2, or 500.

The precision of a floating point number is how many digits it can represent without information loss.

Variables of type float typically have a precision of about 7 significant digits (which is why everything after that many digits in our answer above is junk). Variables of type double typically have a precision of about 16 significant digits.

Rounding errors
One of the reasons floating point numbers can be tricky is due to non-obvious differences between binary and decimal (base 10) numbers. In normal decimal numbers, the fraction 1/3rd is the infinite decimal sequence: 0.333333333… Similarly, consider the fraction 1/10. In decimal, this is easy represented as 0.1, and we are used to thinking of 0.1 as an easily representable number. However, in binary, 0.1 is represented by the infinite sequence: 0.00011001100110011…

One additional note: when converting integers to booleans, the integer zero resolves to boolean false, whereas non-zero integers all resolve to true.

One word of caution: be careful not to mix up character (keyboard) numbers with actual numbers. The following two assignments are not the same

Name		Symbol	Meaning
Alert		\a	Makes an alert, such as a beep
Backspace	\b	Moves the cursor back one space
Formfeed	\f	Moves the cursor to next logical page
Newline		\n	Moves cursor to next line
Carriage return	\r	Moves cursor to beginning of line
Horizontal tab	\t	Prints a horizontal tab
Vertical tab	\v	Prints a vertical tab
Single quote	\’	Prints a single quote
Double quote	\”	Prints a double quote
Backslash	\\	Prints a backslash
Question mark	\?	Prints a question mark
Octal/hex nr.	\(nr)	Translates into char represented by octal/hex number

Integer constants can have a u or U suffix that means they are unsigned. Integer constants can also have a l or L suffix, which means they are long integers. However, these suffixes are typically optional

const keyword. Const variables must be assigned a value when declared, and then that value can not be changed.

Variable prefixes are composed of 3 parts: a scope modifier, a type modifier, and a type prefix (in that order). Scope modifier and type modifier may not apply. 

Type prefix	Meaning			Example
b		boolean			bool bHasEffect;
c (or none*)	class			Creature cMonster;
ch		char (used as a char)	char chLetterGrade;
d		double, long double	double dPi;
e		enum			Color eColor;
f		float			float fPercent;
n		short, int, long	char used as an integer	int nValue;
s		struct			Rectangle sRect;
str		C++ string		std::string strName;
sz		Null-terminated string	char szName[20];

Type modifier	Meaning		Example
a		array on stack	int anValue[10];
p		pointer		int* pnValue;
pa		dynamic array	int* panValue = new int[10];
r		reference	int rnValue;
u		unsigned	unsigned int unValue;

Scope modifier	Meaning			Example
g_		global variable		int g_nGlobalValue;
m_		member of class		int m_nMemberValue;
s_		static member of class	int s_nValue;

Integers are used for holding whole numbers. When using integers, keep an eye out for overflow and integer division problems.

Floating point numbers are used for holding real numbers (which can have fractional components). When using floating point numbers, keep an eye out for precision issues, rounding errors, and comparison issues.

Boolean values hold only true and false. They do not have any major issues.

Char values are integers that can be interpreted as an ASCII value. When using chars, be careful not to mix up ASCII code values and numbers, and watch for overflow and integer division problems.

Use the const keyword to declare symbolic constants instead of #define. It’s safer.

The order in which operators are evaluated in a compound expression is called operator precedence. 

A side effect is a result of an operator, expression, statement, or function that persists even after the operator, expression, statement, or function has finished being evaluated

As a general rule, it is a good idea to avoid the use operators that cause side effects inside of compound expressions.

The comma operator allows you to evaluate multiple expressions wherever a single expression is allowed.

The arithmetic if operator (?:) is also known as the conditional operator, and it is C++’s only ternary operator (it takes 3 operands). The ?: operator provides a shorthand method for doing a particular type of if/else statement.

If/else statements in the following form:
.	if (condition)
.   		x = some value
.	else
.    		x = some other value
can be rewritten as:
.	x = (condition) ? some value : some other value;


using the == operator on floating point numbers is not advised. 

Rule: If logical NOT is intended to operate on the result of other operators, the other operators and their operands need to be enclosed in parenthesis.

Short circuit evaluation.In order for logical AND to return true, both operands must evaluate to true. If the first operand evaluates to false, logical AND knows it must return false regardless of whether the second operand evaluates to true or false. In this case, the logical AND operator will go ahead and return false immediately without even evaluating the second operand! This is known as short circuit evaluation, and it is done primary for optimization purposes.

logical AND has higher precedence than logical OR,

De Morgan’s law tells us how the logical NOT should be distributed in these cases:
!(x && y) is equivalent to !x || !y
!(x || y) is equivalent to !x && !y

			CHAPTER 4


A block of statements, also called a compound statement, is a group of statements that is treated by the compiler as if it were a single statement.

There is no practical limit to how many nested blocks you can have. However, it is generally a good idea to try to keep the number of nested blocks to at most 3 (maybe 4) blocks deep. If your function has a need for more, it’s probably time to break your function into multiple smaller functions!

A variable’s scope determines who can see the variable, and how long it lives for.

Variables declared inside a block are called local variables,

local variables, and local variables have block scope (also called local scope).

variables inside nested blocks can have the same name as variable inside outer blocks. When this happens, the nested variable “hides” the outer variable.This is generally something that should be avoided, as it is quite confusing!

Variables declared outside of a block are called global variables. Global variables have program scope,

Similarly, in order to use a global variable that has been declared in another file, you have to use a forward declaration or a header file, along with the extern keyword.

Generally speaking, if a global variable is going to be used in more than 2 files, it’s better to use the header file approach. Some programmers place all of a programs global variables in a file called globals.cpp, and create a header file named globals.h to be included by other .cpp files that need to use them.

In fact, global variables should generally be avoided completely!

A variable with file scope can be accessed by any function or block within a single file. To declare a file scoped variable, simply declare a variable outside of a block (same as a global variable) but use the static keyword:

File scoped variables act exactly like global variables, except their use is restricted to the file in which they are declared (which means you can not extern them to other files).

The static keyword is probably the most confusing keyword in the C++ language. This is because it has different meanings depending on where it is used. When applied to a variable declared outside of a block, it changes the variable from a global variable to a file scoped variable. When applied to a variable declared inside a block, it has a different meaning entirely!

Using the static keyword on local variables changes them from automatic duration to fixed duration (also called static duration). A fixed duration variable is one that retains it’s value even after the scope in which it has been created has been exited! Fixed duration variables are only created (and initialized) once, and then they are persisted throughout the life of the program.

By default, local variables have automatic duration, which means they are destroyed when the block they are declared in goes out of scope. You can explicitly declare a variable as having automatic duration by using the auto keyword,

One of the most common uses for fixed duration local variables is for unique identifier generators. When dealing with a large number of similar objects within a program, it is often useful to assign each one a unique ID number so they can be identified. This is very easy to do with a fixed duration local variable:

often it is the case that data needs to be converted from one type to another type. This is called type conversion.

Implicit type conversion is done automatically by the compiler whenever data from different types is intermixed. When a value from one type is assigned to another type, the compiler implicitly converts the value into a value of the new type. 

Warning: Microsoft’s Visual C++ 2005 does not seem to issue warnings for unsafe signed/unsigned conversions.

If operands of mixed types are used, the compiler will convert one operand to agree with the other. To do this, it uses a heirarchy of data types:

Long double (highest)
Double
Float
Unsigned long int
Long int
Unsigned int
Int (lowest)

“why is integer at the bottom of the tree? What about char and short?”. Char and short are always implicitly promoted to integers (or unsigned integers) before evaluation. This is called widening.

This heirarchy can cause some interesting issues. For example, you might expect the expression 5u - 10 to evalute to -5 (5u means 5 as an unsigned integer). But in this case, the signed integer (10) is promoted to an unsigned integer, and the result of this expression is the unsigned integer 4294967291!

if you try something like this: float fValue = 10 / 4;. However, because 10 and 4 are both integers, no promotion takes place. Integer division is performed on 10 / 4, resulting in the value of 2, which is then implicitly converted to 2.0 and assigned to fValue!In the case where you are using literal values (such as 10, or 4), replacing one or both of the integer literal value with a floating point literal value (10.0 or 4.0)

C++ will also let you use a C style cast with a more function-call like syntax:

float fValue = float(nValue1) / nValue2;

C++ introduces a new casting operator called static_cast. A static cast works similarly to the C style cast, except it will only do standard type conversions, which reduces the potential for inadvertant misuse:
float fValue = static_cast<float>(nValue1) / nValue2; 

Casting should be avoided if at all possible, because any time a cast is used, there is potential for trouble. But there are many times when it can not be avoided. In these cases, the C++ static_cast should be used instead of the C-style cast.

An enumerated type is a data type where every possible value is defined as a symbolic constant (called an enumerator).
Enumerated types are declared via the enum keyword.

Typedefs allow the programmer to create an alias for a data type, and use the aliased name instead of the actual type name. To declare a typedef, simply use the typedef keyword, followed by the type to alias, 

Typedefs are used mainly for documentation and legibility purposes.

Furthermore, typedefs allow you to change the underlying type of an object without having to change lots of code.(...)However, with a typedef, all you have to do is change typedef short studentID to typedef long studentID and you’re done.

Because typedefs do not define new types, they can be intermixed like normal data types. Even though the following does not make sense conceptually, syntactically it is valid C++.
typedef long miles;  
typedef long speed;  
miles nDistance = 5;  
speed nMhz = 3200;  
  // The following is okay, because nDistance and nMhz are both type long  
nDistance = nMhz;  

An aggregate data type is a data type that groups multiple individual variables together. One of the simplest aggregate data type is the struct. A struct (short for structure) allows us to group variables of mixed data types together into a single unit.

In order to access the individual members, we use the member selection operator (which is a period).

The sequence of statements that the CPU executes is called the program’s path.

Straight-line programs have sequential flow — that is, they take the same path (execute the same statements) every time they are run (even if the user input changes).

control flow statements (also called flow control statements), which allow the programmer to change the CPU’s path through the program. 

The most basic control flow statement is the halt, which tells the program to quit running immediately. In C++, a halt can be accomplished through use of the exit() function that is defined in the cstdlib header. The exit function takes an integer parameter that is returned to the operating system as an exit code, much like the return value of main().

A jump unconditionally causes the CPU to jump to another statement. The goto, break, and continue keywords all cause different types of jumps — we will discuss the difference between these in upcoming sections.

A conditional branch is a statement that causes the program to change the path of execution based on the value of an expression.

A loop causes the program to repeatedly execute a series of statements until a given condition is false.

C++ provides 3 types of loops: while, do while, and for loops. Unlike more modern programming languages, such as C# or D, C++ does not provide a foreach keyword. We will discuss loops at length toward the end of this section.

Finally, exceptions offer a mechanism for handling errors that occur in functions. If an error occurs that the function can not handle, it can raise an exception, and control jumps to the nearest block of code that has declared it is willing to catch exceptions of that type.

if statement
if (expression)
    statement
else
    statement2

dangling else problem. Is the else statement in the above program matched up with the outer or inner if statement?

The answer is that an else statement is paired up with the last unmatched if statement in the same block. Thus, in the program above, the else is matched up with the inner if statement.

If statements are commonly used to do error checking.

If statements can also be used to do early returns
If statements are also commonly used to do simple math functionality, such as a min() or max() function that returns the minimum or maximum of it’s parameters.

the switch expression is evalutated to produce a value, and each case label is tested against this value for equality. If a case label matches, the statements after the case label are executed. If no case label matches the switch expression, the code under the default label is executed (if it exists).The one restriction on this expression is that it must evaluate to an integral type (that is, char, short, int, long, or enum). Floating point variables and other non-integral types may not be used here.

When execution flows from one case into another case, this is called fall-through. Fall-through is almost never desired by the programmer, so in the rare case where it is, it is common practice to leave a comment stating that the fall-through is intentional.

Warning: Forgetting the break statements in a switch block is one of the most common C++ mistakes made!

The goto statement is a control flow statement that causes the CPU to jump to another spot in the code. This spot is identified through use of a statement label. 

Spaghetti code has a path of execution that resembles a bowl of spaghetti (all tangled and twisted), making it extremely difficult to follow the logic of such code.

Rule: Avoid use of goto unless necessary





------ POINTERS
 A pointer is a variable that holds the address of another variable.
int *pnPtr; // a pointer to an integer value 

To get the address of a variable, we can use the address-of operator (&):
int nValue = 5;  
int *pnPtr = &nValue; // assign address of nValue to pnPtr 

The type of the pointer has to match the type of the variable being pointed to

(*). A dereferenced pointer evaluates to the contents of the address it is pointing to.

In other words, when pnPtr is assigned to &nValue:
pnPtr is the same as &nValue
*pnPtr is the same as nValue

Sometimes it is useful to make our pointers point to nothing. This is called a null pointer. We assign a pointer a null value by setting it to address 0

C (but not C++) also defines a special preprocessor define called NULL that evaluates to 0. Even though this is not technically part of C++, it’s usage is common enough that it will work in every C++ compiler

int *pnPtr = NULL; // assign address 0 to pnPtr 

anArray is actually a pointer that points to the first element of the array! Because the array variable is a pointer, you can dereference it, which returns array element 0:

int anArray[5] = { 9, 7, 5, 3, 1 };  
  
// dereferencing an array returns the first element (element 0)  
cout << *anArray; // prints 9!  
  
char szName[] = "Jason"; // C-style string (also an array)  
cout << *szName; // prints 'J'  

The C language allows you to perform integer addition or subtraction operations on pointers. If pnPtr points to an integer, pnPtr + 1 is the address of the next integer in memory after pnPtr. pnPtr - 1 is the address of the previous integer before pnPtr.

Note that pnPtr+1 does not return the address after pnPtr, but the next object of the type that pnPtr points to. If pnPtr points to an integer (assuming 4 bytes), pnPtr+3 means 3 integers after pnPtr, which is 12 addresses after pnPtr. If pnPtr points to a char, which is always 1 byte, pnPtr+3 means 3 chars after pnPtr, which is 3 addresses after pnPtr.

When calculating the result of a pointer arithmetic expression, the compiler always multiplies the integer operand by the size of the object being pointed to. This is called scaling.

If anArray is a pointer that points to the first element (element 0) of the array, and adding 1 to a pointer already returns the next object, then anArray+1 must point to the second element (element 1) of the array!


the variables must be declared at compile time. This leads to two issues: First, it’s difficult to conditionally declare a variable, outside of putting it in an if statement block (in which case it will go out of scope when the block ends). Second, the size of all arrays must be decided upon in advance of the program being run.

cout << "How many variables do you want? ";
int nVars;
cin >> nVars;
int anArray[nVars]; // wrong!  The size of the array must be a constant

Dynamic memory allocation allows us to allocate memory of whatever size we want when we need it.
int *pnValue = new int; // dynamically allocate an integer
delete pnValue; // unallocate memory assigned to pnValue
pnValue = 0;

Declaring arrays dynamically allows us to choose their size while the program is running. To allocate an array dynamically, we use the array form of new and delete (often called new[] and delete[]):
int nSize = 12;
int *pnArray = new int[nSize]; // note: nSize does not need to be constant!
pnArray[4] = 7;
delete[] pnArray;

Because we are allocating an array, C++ knows that it should use the array version of new instead of the scalar version of new. Essentially, the new[] operator is called, even though the [] isn’t placed next to the new keyword.

When deleting a dynamically allocated array, we have to use the array version of delete, which is delete[]. This tells the CPU that it needs to clean up multiple variables instead of a single variable.

Note that array access is done the same way with dynamically allocated arrays as with normal arrays. While this might look slightly funny, given that pnArray is explicitly declared as a pointer, remember that arrays are really just pointers in C++ anyway.

One of the most common mistakes that new programmers make when dealing with dynamic memory allocation is to use delete instead of delete[] when deleting a dynamically allocated array. Do not do this! Using the scalar version of delete on an array can cause data corruption or other problems.

Dynamically allocated memory effectively has no scope. That is, it stays allocated until it is explicitly deallocated or until the program ends. However, the pointers used to access dynamically allocated memory follow the scoping rules of normal variables. This mismatch can create interesting problems.

Consider the following function:

void doSomething()
{
    int *pnValue = new int;
}

This function allocates an integer dynamically, but never frees it using delete. Because pointers follow all of the same rules as normal variables, when the function ends, pnValue will go out of scope. Because pnValue is the only variable holding the address of the dynamically allocated integer, when pnValue is destroyed there are no more references to the dynamically allocated memory. This is called a memory leak. As a result, the dynamically allocated integer can not be deleted, and thus can not be reallocated or reused. Memory leaks eat up free memory while the program is running, making less memory available not only to this program, but to other programs as well. Programs with severe memory leak problems can eat all the available memory, causing the entire machine to run slowly or even crash.


functions are firstclass
objects used for many tasks.


A pattern in the broader sense of the word is a “theme of recurring events or objects…
it can be a template or model which can be used to generate things”.

In software development, a pattern is a solution to a common problem.


verbatim

An
antipattern is not the same as a bug or a coding error; it’s just a common approach that
causes more problems than it solves. Antipatterns are clearly marked with a comment
in the code.

An object is just a collection of named properties,
a list of key-value pairs (almost identical to an associative array in other languages).

no classes in JavaScript
It's no need to cry.
As you probably know* class is a blueprint for object, which means class is a recipe for how to make object.
JavaScript creators decided that is really boring to writing 

MyObjectMaker myObjectMaker = new MyObjectMaker();

and then you can start do funky stuff with myObjectMaker, so they abaddon this idea of creating recipe and make life easier and you just create object straight away using:
1) object literals  (my favorite one)
2) function 
3) singleton ( my "hate" one,because it's one of example why learning javascript is annyoing and confusing experience.My feeling about learning javascript is similar to person who has biegunka i nie dotarl do toalety na czas z powodu gigantycznej kolejki do klopa (ktora w javascript reprezentuja zarowno pewne zawilosci zwiazane z samym jezykiem jak i w przypadku aplikacji webowej po stronie klienta z kompatybilnoscia) , who has d with learning javascript is ) 


* yeah,sure.
Not having classes makes your programs shorter—you don’t need to have a class to
create an object.
A “blank” object is not entirely blank; it comes with
a few built-in properties already but has no “own” properties

as mentioned in book js:pattern 
"Gang of Four book says, “Prefer object composition to
class inheritance.” This means that if you can create objects out of available pieces you
have lying around, this is a much better approach than creating long parent-child inheritance
chains and classifications. In JavaScript it’s easy to follow this advice—simply
because there are no classes and object composition is what you do anyway"
http://www.phpied.com/3-ways-to-define-a-javascript-class/
