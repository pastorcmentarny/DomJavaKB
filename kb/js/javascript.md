## **HONEST WARNING**
**Content in this KB is for me ONLY.**
It contains definitions that explain things in the way that is easiest for me to understand.
_I am not the author of these definitions so check resources section for the origin of definitions._ 


*JavaScript* is **single threaded**.

JAVASCRIPT

Global variable n its simplest form, this technique aims to wrap code inside a function scope.It helps decreases chances of:
clashing with other applications/libraries
polluting superior (global most likely) scope
OTHER:
B64 as way to fix escape problems
the object container (JSONObject) was not holding the precision of the original value. The JSONObject actually takes a double, not a float


##Promises
promises are a bit like event listeners except:
* A promise can only succeed or fail once (but not more and you cannot switch from success to failure). 

###A promise can be:

* **fulfilled** The action relating to the promise succeeded
* **rejected**  The action relating to the promise failed 
* **pending**   Hasn't fulfilled or rejected yet 
* **settled**   Has fulfilled or rejected

The promise constructor takes one argument, a callback with two parameters, resolve and reject.

 it's customary, but not required, to reject with an Error object. The benefit of Error objects is they capture a stack trace, making debugging tools more helpful.
 