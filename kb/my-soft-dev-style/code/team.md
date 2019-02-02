#   METHODOLOGY

##  BRAINSTORM:
1.  Think of questions, not answers when brainstorming.
2.  (English) Okay, let me make sure I understand ...so you said.
3.  Do we not think enough when coding? Do we jump to the first solution without really considering the problem, without trying to analyze and decompose it and understand the components and orthogonal forces involved? Is that the cause of bad code (together with time press) and the reason why we typically see a “patch evolution” rather than evolution of design?
4.  I usually do some research about existing technology based on following criteria: stability, usability, easy to learn for new people and easy to share knowledge, price (as there are always budget limits. is it value for money? Maintenance cost ? Support cost?), compatibility with existing system, how mature and is it maintenance stage or is it, documentation, API, Support (is it community, is support must be purchased, how author response to improvement request). When best (or top 3 ) x are selected, then is good to do some prototype and write some learning test to see how they meet expectations. We can reuse these tests later to see is changes in third party API didn't break anything.
5.  Make problem simple, because a simple problem is easier to solve.“If you can’t explain it simply, you don’t understand it enough.” - Albert Einstein/Richard Feynman. Explain it as if you are teaching it. Study it more when you get stuck — keep resolving the problem until you can explain it. Simplify and use analogies — relate it to things people already understand.


##  CODE REVIEW:
1.  Code review is not testing and you shouldn't tell what to review.
2.  If those reviewers cannot solve the issues amicably, then the best thing to do is to have a chat with the whole team.
3.  You should spend up to 60 minutes on code review in one session because after an hour you’ll simply grow tired of the task and won’t be as efficient in finding errors and defects. Reduce Interruptions with code review
4.  How much time should you actually assign to each review? 60 minutes is a good, round number that you should focus on. Also, after an hour you’ll simply grow tired of the task and won’t be as efficient in finding errors and defects.
5.  I am always striving to improve my effectiveness at work. I much prefer receiving any feedback directly
6.  Divide the review into time slots. 
7.  Don’t try to review the whole project at once. Experts advise not to review more than 400 lines of code at once.
8.  Stay positive. Code review can sometimes put a strain on the relationships within the team. Nobody likes to be criticised, so it’s very important to keep a friendly atmosphere unless you want your coworkers to lose their motivation. Instead of perceiving each and every bug negatively, think positively, as they are the new opportunities for improving the code quality in general.
    -   (Reason : humans cannot effectively process that amount of information, especially over such a long period of time.)
    
    
##  CONTINUOUS INTEGRATION/DELIVERY:
1.  Continue Delivery is about built the right thing and put changes quickly. Successfully implemented REDUCE THE COST, TIME and RISK of delivering INCREMENTAL CHANGES to users.
2.  The software is always releasable on demand. If is any problem with this process, then work must prioritize keeping system releasable over delivery.
3.  Continuous integration is a skill not tool.
4.  Having Jenkins/Bamboo doesn't mean you do continuous delivery.
5.  However, if the ultimate goal, is to get the new feature that the developer writes to production, in a matter of hours rather than months or half a year, there was still a need to fill the gap between agile development and CI, and actually pushing frequent, small updates to production.


## MEETINGS:
1.  Write stuff down. Send an email with meeting notes where include all decisions made and all “I will do this” statements. It sounds counterintuitive but it will help build trust even if sounds lack trust and catch unexpected misunderstandings.
2.  When you made a decision, write down why. It will help you to remember reasons behind the decision. “Why” is more important than “what.”
3.  It should be one day in the week without Meetings. A Meetingless day (excluding morning standup). Due to distracted nature of the meeting, we should have at least 1 day where we can do just work.
4.  In invitation we use snippets as a mechanism to share information while preventing information overload.


##  PAIR PROGRAMMING:
1.  When you’re pairing, this thinking happens out loud as you argue about the best way to approach the design, the best way to test this class, the best way to refactor it. One thing I really struggle with, but as a navigator, it’s really important: don’t interrupt the driver’s flow. Resist the temptation to tell the driver there’s a missing bracket or semicolon. Resist the urge to tell them what order to fix the compile errors in.
2.  Ping-pong pairing: this is where one person writes a failing test, the other makes it pass then writes another failing test, back to the first to make this test pass and then write another failing test, and so on and so on… This can give a good balance to a pairing session as both developers write test and production code and give a natural rhythm preventing any one developer from dominating the driver role.
3.  The navigator should be taking copious notes, letting the driver stay hands-on-keyboard typing. If there’s a test we’ve spotted we’re missing, an obvious design smell we need to come back to or if there’s a refactoring we should do next, write it down.
4.  Generally, the person that knows the domain/codebase/problem the best should spend the least time is the driver. If I don’t know this code and you’re driving, I’m just gonna sit here watching you type. I can’t really contribute any design ideas because you know the domain. I can’t ask questions because it stops you typing. But the other way round: I can be busy typing learning the code as I go; while you use your superior knowledge to guide me in the right direction.
5.  We need help of others because we are limited in what we can see.


##  TEAM RULES:
1.  Fix crap code immediately or in next iteration because bad code accumulates. If the fix is more than "one liner" or not sure about it, chat with your technical/practical leads about it. Why? Because in reality as LeBlanc’s law said: Later equals never. it is like with broken window in your home. When you broke, you fix it straight away.
2.  ADR architecture decision records. It is a great to track your decision and helps you to make better one in future. Each decision contains:
    -   Decision made
    -   Who
    -   Options consider
    -   Options rejected
    -   Risk introduced
3.  Software should be always releasable. It has the highest priority over doing new work. If a software is not releasable, we do not add new code. We focus on fix a problem first.
4.  Complete each feature before moving on to the next.
5.  How can we share our best practices with others?
6.  The team should have a half day for learning new things or doing fix/improve thing that matter for them.
7.  The pre-live environment is critically important.
8.  The idea of a code retreat is to allow programmers to write the perfect code they would write if they had all the time and resources in the world. And why is it important? Because after experiencing something, calmly and thoroughly, you feel more comfortable integrating it into a daily routine. And so, in the end, we will narrow the gap between the code that we write every day and the perfect code. Another principle of running a code retreat is teamwork. Your team would be exposed to different thinking processes while also learning to work with your teammates.
9.  Email is not the best platform to handle project logistics and materials. Lack of elaborate search and sort features. The entire process of emailing can be highly disruptive to your workflow. 
10. Threads are overwhelming. For teams that end up spending much of their time corresponding via email, you miss the human element. Nuances such as intonation and body language can communicate a lot, but email doesn’t give you much of a chance to pick up on that. What’s more is that brainstorming sessions are best done as a group, so you may be missing out on ingenuity as well.
11. the idea of the “two-pizza team” rule made famous by Jeff Bezos at Amazon, meaning if you can’t feed a team with two pizzas, then the team is too large.
12. PDUs are complete units that own a set of microservices. This helps keep smaller teams focused on specific projects and avoids complications that come with having too many hands on one set of microservices. 
13. The basic rule of thumb is don’t give feedback without permission first.

##  COMPANY RULES:
1.  The performance-based bonus is counterproductive. If a company has a performance-based bonus, try to reduce harm as much as possible like a move from personal to the team . Performance-based bonus is pure evil.
    -   Employee reviews are useless. Use quick and quite often 1 to 1 session to get feedback, work on improvement and remove independents. 
    -   Employee first , customer second.
2.  You don’t need HR or corporate communications, we have the pub instead (tough luck if you have a family).
3.  A broken, dysfunctional organization driven by meeting unhealthy goals and metrics will produce broken, dysfunctional systems @ Jimmy Bogard
4.  Encouraging people to use sick days for mental health when they need them.
5.  40 days paid vacation per year: True disconnection is fundamental to help people de-stress and recharge.
## TDD:
1.  The Golden Rule of Test-Driven Development: Never write new functionality without a failing test.
    -   We always watch the test fail before writing the code to make it pass, and check the diagnostic message. If the test fails in a way we didn’t expect, we know we’ve misunderstood something or the code is incomplete, so we ﬁx that.
2.  TDD is a programer technique to writing software. It helps you increase confidence and focus on writing code that meet criteria.
    -   Write the test first, then write the code that satisfies the test. It leads to less buggy code and better design, because when you have to structure code in a testable way, you end up making smaller, simpler functions that have fewer dependencies.
    -   It clarifies the acceptance criteria for the next piece of work. We have to ask ourselves how we can tell when we’re done (design).
3.  It gives me the freedom to improve later.
4.  Whenever you are tempted to type something into a print statement or a debugger expression, write it as a test instead.
5.  Levels of Testing. We build a hierarchy of tests to gain confidence on various levels:
    -   Acceptance: Does the whole system work?
    -   Integration: Does our code work against code we can't change?
    -   Unit: Do our objects do the right thing, are they convenient to work with?
6.  TDD at the unit level guides us to decompose our system into value types and loosely coupled computational objects. The tests give us a good understanding of how each object behaves and how it can be combined with others.
7.  Martin also explains that a common mistake in TDD is to end up with a one-to-one correspondence between tests and implementation. This could mean there is a single test class per implementation class and a single test method per implementation method. The main negative result of this is a tight coupling between tests and implementation, leading to code that is difficult to refactor and reason about.


##  PROJECT:
1.  How to Choose Language/Framework?
2.  Validate each of them by their performance, syntax stability, security, development cycle, support, cost.
3.  Ship early and often. You could also have eliminated this issue altogether by not shipping a big-bang, all-or-nothing project at the end of a year. By doing this, you create an excessively long feedback loop.
4.  How to start a new project using TDD approach? We want to start from building a “walking skeleton” that we can deploy it into a production-like environment, and then run the tests through the deployed system. Including the deployment step in the testing process. It is critical for two reasons. First, this is the sort of error-prone activity that should not be done by hand, so we want our scripts to have been thoroughly exercised by the time we have to deploy for real. Second, The development team bumps into the rest of the organization and has to learn how it operates currently. If it’s going to take six weeks and four signatures to set up a database, we want to know now, not two weeks before delivery. To design initial structure, we have to have some understanding of the purpose of the system and we need a high-level view of the client’s requirements, both functional and non-functional, to guide our choices. The tools we build to implement the “walking skeleton” are there to support this learning process. Deploying and testing right from the start of a project forces the team to understand how their system ﬁts into the world. It ﬂushes out the “unknown unknowns” technical and organizational risks so they can be addressed while there’s still time. Understand problem → Automate Build, Deployment, End to End Tests → TDD cycle.  The “walking skeleton” is an implementation of the thinnest possible slice of real functionality that we can automatically build, deploy, and test end-to-end. For example, for a database-backed web application, a skeleton would show a ﬂat web page with ﬁelds from the database.
5.  Iteration Zero. In most Agile projects, there’s a ﬁrst stage where the team is doing initial analysis, setting up its physical and technical environments, and otherwise getting started. The team isn’t adding much visible functionality since almost all the work is infrastructure, so it might not make sense to count this as a conventional iteration for scheduling purposes. A common practice is to call this step iteration zero: “iteration” because the team still needs to time-box its activities and “zero” because it’s before functional development starts in iteration one. One important task for iteration zero is to use the walking skeleton to test-drive the initial architecture.0.  Log Aggregation,b. Performance Metrics, Distributed Tracing, Health Check
6.  Make sure to plan the architecture before doing Agile development.
7.  Create a performance test suite for the whole application.
8.  The Intended Results of the Project. The best way to monitor this is through tangible metrics that can be tracked over time. For example, a 25% reduction in rework
0. Software architecture is the skeleton of a system. It defines how the system has to behave in terms of different functional and non-functional requirements. agile movement allows us to welcome changes, even late in the development phase. Although we are moving from a rigid development to a more flexible one, software architecture is a part that is sensitive to changes due to its nature as a skeleton. A key factor therefore, when following the agile movement, is to embrace the notion of a sustainable software architecture – one that enables the expansion of the system to happen in a gradual, easy, and maintainable way along with growth of the complexity of the project.Software architecture defines the skeleton of the future system. It is not just a diagram with lines and dots, but rather a complete set of decisions that govern the development of the system, including the code itself. Every decision made is a trade-off and should be carefully considered. 

##  OTHER:
1.  Learning from experience/failures is one the most important aspect of being better. Be careful, the experience can teach us to repeat poor behavior and to create bad habits. “The Code Works” isn’t where you stop. It’s where you start. When it works, make it better.
2.  Life/work balance is important and long hours means burnout.
3.  Choose good enough solution over perfect. If it is 80% done, and getting it too perfect is going to take a lot more effort, ship it, and fix it later. 
4.  Always add an email address for technical and security issues on your website to allow users to contact you. Why ? Read this story: www.daemonology.net/blog/2014-12-25-when-security-goes-right.html 
5.  Practice coding every day for at least 30 minutes (1h recommended) without excuses If you skip one day for whatever lazy reason then you more likely may skip the following day as well and then give up altogether. Don’t let that happen. I did twice and it has a very bad consequence on me for a long time.
6.  Read lots of Code. While you do it think about:
    -   How would I improve this code?
    -   How would I have written that block of code? 
7.  There are core languages/framework/tools that you use every day. It is a good habit to be up to date with what’s new in new versions of these things are released, it’s worth investing the time to learn about them.
8.  Programming is a creative art based on logic. Every programmer is different so it codes differently. The output is what matters. Always maintain constantly shippable code. Always provide defaults for load things. As soon as u see a bug, fix it.
