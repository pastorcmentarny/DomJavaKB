# AngularJS

## Definitions
AngularJS extends HTML with ng-directives.

The **ng-app** directive defines an AngularJS application.

The **ng-model** directive binds the value of HTML controls (input, select, textarea) to application data.

The **ng-bind** directive binds application data to the HTML view.

AngularJS **directives** are HTML attributes with an data-ng prefix. 

AngularJS expressions bind AngularJS data to HTML the same way as the ng-bind directive.

AngularJS **modules** *define* AngularJS applications.

AngularJS **controllers** *control* AngularJS applications.

The **ng-app directive** defines the application, the **ng-controller directive** defines the controller.

AngularJS expressions can be written inside double braces: {{ expression }} and can be written inside a directive: ng-bind="expression".

AngularJS expressions are much like JavaScript expressions: They can contain literals, operators, and variables.

AngularJS Expressions vs. JavaScript Expressions
* Like JavaScript expressions, AngularJS expressions can contain literals, operators, and variables.
* Unlike JavaScript expressions, AngularJS expressions can be written inside HTML.
* AngularJS expressions do not support conditionals, loops, and exceptions, while JavaScript expressions do.
* AngularJS expressions support filters, while JavaScript expressions do not.

AngularJS has a set of built-in directives which you can use to add functionality to your application.

## APPLICATION
The AngularJS application is defined by  ng-app="myApp". The application runs inside the <div>.

## MODULE

The module is a container for the different parts of an application.
The module is a container for the application controllers.
_Controllers always belong to a module._

```javascript
var app = angular.module("myApp", []);  

```
The [] parameter in the module definition can be used to define dependent modules. Without the [] parameter, you are not creating a new module, but retrieving an existing one.

Global functions should be avoided in JavaScript. They can easily be overwritten or destroyed by other scripts.

AngularJS modules reduces this problem, by keeping all functions local to the module.

AngularJS lets you extend HTML with new attributes called Directives.

AngularJS has a set of built-in directives which offers functionality to your applications and you define your own directives.

The ```{{ firstName }}``` expression, in the example above, is an AngularJS data binding expression. 

Data binding in AngularJS binds AngularJS expressions with AngularJS data.

```{{ firstName }}``` is bound with ```ng-model="firstName".```

The **ng-repeat** directive actually clones HTML elements once for each item in a collection.

The **ng-repeat** directive used on an array of objects:

The **ng-app directive** defines the  ***root element*** of an AngularJS application.

The **ng-app directive** will ***auto-bootstrap*** (automatically initialize) the application when a web page is loaded.

The **ng-model** directive can also:

* Provide type validation for application data (number, email, required).
* Provide status for application data (invalid, dirty, touched, error).
* Provide CSS classes for HTML elements.
* Bind HTML elements to HTML forms.


##DIRECTIVES

In addition to all the built-in AngularJS directives, you can create your own directives.

New directives are created by using the .directive function.

When naming a directive, you must use a camel case name, w3TestDirective, but when invoking it, you must use - separated name, w3-test-directive:

You can invoke a directive by using:
```javascript
    app.directive("domFooter",function () {    
        var year = new Date().getFullYear();       
        return{       
            template : "<h3>Created and crafted by Dominik. &Omega;" + year + "</h3>"            
        };
    }
```

* Element name ```<dom-footer></dom-footer>```
* Attribute ```<div dom-footer></div>```
* Class ```<div class="dom-footer"></div>```
* Comment ```<!-- directive: dom-footer -->```

You can restrict your directives to only be invoked by some of the methods:
```javascript
    app.directive("domFooter",function () {    
    
        var year = new Date().getFullYear();
        
        return{
            restrict: "A",
            template : "<h3>Created and crafted by Dominik. &Omega;" + year + "</h3>"
            
        };
    }
```

The legal restrict values are:

* **E** for **Element name**
* **A** for **Attribute**
* **C** for **Class**
* **M** for **Comment**
(By default the value is EA)
 
 
## Two-Way Binding

The binding goes both ways. If the user changes the value inside the input field, the AngularJS property will also change its value:
 
If the property in the ng-model attribute does not exist, AngularJS will create one for you.
 
**ng-empty** : _the view not contains any value_
**ng-not-empty** : _the view contains a non-empty value_
**ng-touched** : the control has been blurred **???**
**ng-untouched** : ? **???**
**ng-valid** : _the model is valid_
**ng-invalid** : _the model is invalid_
**ng-dirty** : _class tells you that the form has been modified by the user_
**ng-pending** :  any $asyncValidators are unfulfilled **???**
**ng-pristine** : _class tells you that the form has not been modified by the user_
**ng-valid-[key]** : for each valid key added by $setValidity

9from: https://docs.angularjs.org/api/ng/directive/ngModel
 
 
Data binding in AngularJS is the synchronization between the model and the view.
 
The HTML container where the AngularJS application is displayed, is called the view.

You can use the ng-bind directive, which will bind the innerHTML of the element to the specified model property: ```<p ng-bind="description"></p>```or ```{{description}}``` or you can use the ng-model directive on HTML controls to bind the model to the view.

When data in the model changes, the view reflects the change, and when data in the view changes, the model is updated as well.
This happens immediately and automatically, which makes sure that the model and the view is updated at all times.
 
##Controller

AngularJS controllers control the data of AngularJS applications.
AngularJS controllers is a JavaScript Object, created by a standard JavaScript object constructor.
 
 
 
 The ng-controller="myCtrl" attribute is an AngularJS directive. It defines a controller.
 
 In AngularJS, $scope is the application object (the owner of application variables and functions).
 
 The scope is the binding part between the HTML (view) and the JavaScript (controller).
 
 The scope is an object with the available properties and methods.
 
 The scope is available for both the view and the controller.
 When you make a controller in AngularJS, you pass the $scope 
 
 When adding properties to the $scope object in the controller, the view (HTML) gets access to these properties.
 
 In the view, you do not use the prefix $scope, you just refer to a propertyname, like {{carname}}.
 
 
 the Scope
 If we consider an AngularJS application to consist of:
 
 View, which is the HTML.
 Model, which is the data available for the current view.
 Controller, which is the JavaScript function that makes/changes/removes/controls the data.
 Then the scope is the Model.
 
 The scope is a JavaScript object with properties and methods, which are available for both the view and the controller.
 
 All applications have a $rootScope which is the scope created on the HTML element that contains the ng-app directive.
 
 The rootScope is available in the entire application.
 
 If a variable has the same name in both the current scope and in the rootScope, the application use the one in the current scope.
 
 $rootScope is available globally, no matter what controller you are in, whereas $scope is only available to the current controller and it's children.
 
 The main difference is the availability of the property assigned with the object. A property assigned with $scope cannot be used outside the controller in which it is defined whereas the a property assigned with $rootScope can be used anywhere.
 
 f a variable has the same name in both the current scope and in the rootScope, the application use the one in the current scope.
 
 ##Filters
 Filters can be added in AngularJS to format data.
 
 AngularJS provides filters to transform data:
 
 * *currency* **Format a number to a currency format.**
 * *date* **Format a date to a specified format.**
 * *filter* **Select a subset of items from an array.**
 * *json* **Format an object to a JSON string.**
 * *limitTo* **Limits an array/string, into a specified number of elements/characters.**
 * *lowercase* **Format a string to lower case.**
 * *number* **Format a number to a string.**
 * *orderBy* **Orders an array by an expression.**
 * uppercase* **Format a string to upper case.**
 
 Filters are added to directives, like ng-repeat, by using the pipe character |, followed by a filter:
 
 The filter filter selects a subset of an array.
 
 The filter filter can only be used on arrays, and it returns an array containing only the matching items.
 
 AngularJS can validate input data.
 
AngularJS offers client-side form validation.

AngularJS monitors the state of the form and input fields (input, textarea, select), and lets you notify the user about the current state.

AngularJS also holds information about whether they have been touched, or modified, or not.

You can use standard HTML5 attributes to validate input, or you can make your own validation functions.

Form State and Input State
AngularJS is constantly updating the state of both the form and the input fields.

## ngROUTES
The ngRoute module helps your application to become a Single Page Application.

Add styles for these classes to give your application a better and more intuitive user interface.


Remember, when naming a directive, you must use a camel case name, myDirective, but when invoking it, you must use - separated name, my-directive.

The ngRoute module helps your application to become a Single Page Application.


####What is Routing in AngularJS?
If you want to navigate to different pages in your application, but you also wants the application to be a SPA (Single Page Application), with no page reloading, you can use the ngRoute module.

More about it can be found here: 
http://www.w3schools.com/angular/angular_routing.asp

Example of routing :

```javascript

    app.config(function($routeProvider) {
        $routeProvider
        .when("/", {
            templateUrl : "main.htm"
        })
        .when("/red", {
            templateUrl : "red.htm"
        })
        .when("/green", {
            templateUrl : "green.htm"
        })
        .when("/blue", {
            templateUrl : "blue.htm"
        });
    
```