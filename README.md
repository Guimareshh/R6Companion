# R6-Companion

[![Build Status](https://app.bitrise.io/app/a480acf045454fe4/status.svg?token=JBzlAKfwzhaBQpQiuP4Dbw&branch=master)](https://www.bitrise.io/app/a480acf045454fe4)

Android application made by an R6 fan for R6 players. Currently under development. What the app does/will do :
* Feed of news about major Rainbow Six Siege information, no spam or useless info (TODO)
* List of operators with all theirs abilities and more (TODO)
* List of maps (TODO)
* List of tips posted by the community (text, video, guide ...) (TODO)
* Find someone to play with (TODO)


## Issues and Pull requests

Feel free to report issues and make pull requests. 


## Architecture


### Design pattern

TBD

### Clean Architecture

Clean Architecture has one objective, which is the separation of concerns. It's achieved this 
separation by dividing the software into layers. That give us the following advantages : 

* Independent of Frameworks. The architecture does not depend on the existence of some library of 
feature laden software. This allows you to use such frameworks as tools, rather than having to cram 
your system into their limited constraints.
* Testable. The business rules can be tested without the UI, Database, Web Server, or any 
other external element.
* Independent of UI. The UI can change easily, without changing the rest of the system. A Web UI 
could be replaced with a console UI, for example, without changing the business rules.
* Independent of Database. You can swap out Realm or SQLite, for Room or something else. Your 
business rules are not bound to the database.
* Independent of any external agency. In fact your business rules simply don’t know anything at all 
about the outside world.

![Here how it works :](images/clean_architecture.jpg)

A deeper and complete explanation of Clean Architecture can be found 
[here](https://8thlight.com/blog/uncle-bob/2012/08/13/the-clean-architecture.html)


### Implementation

TBD


### Testing

Mock / Kluent / Espresso (UI)
