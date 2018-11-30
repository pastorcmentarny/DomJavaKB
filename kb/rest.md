IQA:
What is RESTFul Web Service?

What are the differences between HTTP and REST?
HTTP is a stateless, application-layer protocol for communicating between distributed systems
REST is not a standard . It is an architectural style for distributed hypermedia systems. REST is a design style for protocols,

Difference between POST and PUT?
POST is a method to create a new resource and get id, if resource was created successfully. I
PUT is a method to update existing resource. It can be used to create an new resource with given id. 
The key difference between PUT and POST is that.No matter how many times you send a PUT request, the results will be same. Making a POST multiple times may result in multiple resources getting created on the server.
Another difference is that, with PUT, you must always specify the complete URI of the resource.


Request
Operation
PUT http://MyService/Persons/
Won't work. PUT requires a complete URI
PUT http://MyService/Persons/1
Insert a new person with PersonID=1 if it does not already exist, or else update the existing resource




POST http://MyService/Persons/
Insert a new person every time this request is made and generate a new PersonID.
POST http://MyService/Persons/1
Update the existing person where PersonID=1

Difference between HEAD and GET?
HEAD returns only the response headers with an empty body. 
GET HEAD returns only the response headers with a body.


What do you understand by payload in RESTFul? [TODO improve it]
Payload means data which passed inside request body also payload is not request parameters. So only you can do payload in POST.

DATABASE


alter session set current_schema=’x’
UPDATE column SET X_ID = 1 WHERE X_KEY = 'dms.active';	



REST

GET          /users                  - will get you all of your users
GET          /users/olafur      - will get you one user
POST       /users                  - will make a new user
PUT         /users/olafur      - will update the user
DELETE /user/olafur         - will delete the user

A quick review of CRUD

CRUD-based APIs refer to APIs that offer resource collections that contain instances, mimicking the (c)reate, (r)ead, (u)pdate, and (d)elete lifecycle pattern. The CRUD pattern is useful when we have a collection of resource instances that represent content or state. It often follows this familiar pattern:

GET /articles – List/paginate/filter the list of available articles
POST /articles – Create a new article
GET /articles/{articleId} – Retrieve the representation of an article instance
PATCH /articles/{articleId}– Update specific fields for an article instance
DELETE /articles/{articleId} – Delete a specific article instance

There is nothing about CRUD being a requirement for a “RESTful” API.



REST is about constraining the way we interact between client and server, to take advantage of what the protocol (in this case, HTTP) offers. These constraints give us freedom to focus on our API design:

Uniform interface – requests from different clients look the same, whether the client is a browser, mobile device, or anything else
Client-server separation – the client and the server act independently and the interaction between them is only in the form of requests and responses
Stateless – the server does not remember anything about the user who uses the API, so all necessary information to process the request must be provided by the client on each request. Note: this isn’t about storing server-side state
Layered system – the client is agnostic as to how many layers, if any, there are between the client and the actual server responding to the request. This is a key principle of HTTP, allowing for caching servers, reverse proxies, and access security layering – all transparent to the client sending the request
Cacheable – the server response must contain information about whether or not the data is cacheable, allowing the client and/or intermediaries (see layered constraint, above) to cache data outside of the API server
Code-on-demand (optional) – the client can request code from the server, usually in the form of a script, for client-side execution
Again, there is nothing about REST requiring a resource with a CRUD-based lifecycle. CRUD is a pattern we can apply to our APIs, but it isn’t a requirement for composing a REST-based API.


POST /articles/{articleId}/submit
POST /articles/{articleId}/approve
POST /articles/{articleId}/decline
POST /articles/{articleId}/publish

GET /search?q=api
GET /postal-code-to-region?postalCode=78701
POST /calc-sales-tax

TODO:
https://github.com/yangshun/tech-interview-handbook/blob/master/preparing/cheatsheet.md