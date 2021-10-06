## **HONEST WARNING**

**Content in this KB is for me ONLY.**
It contains definitions that explain things in the way that is easiest for me to understand.
_I am not the author of these definitions so check resources section for the origin of definitions._


# Java 17

Things, i care about it (Rest is useful and important too)
2. 356: 	Enhanced Pseudo-Random Number Generators
3. 403: 	Strongly Encapsulate JDK Internals
```
You cannot do this:
System.out.println(sun.security.util.SecurityConstants.ALL_PERMISSION);
You will see error: Package 'sun.security.util' is declared in module 'java.base', which does not export it to the unnamed module
```
5. 409: 	Sealed Classes
6. 415: 	Context-Specific Deserialization Filters