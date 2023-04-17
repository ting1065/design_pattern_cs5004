# Obeserver Design Pattern
Group: Fengting Tang, Yang Li, Yunke Li


## Introduction
The Observer Design Pattern is a well-established behavioral design pattern that plays a crucial role in facilitating a one-to-many dependency between objects. In this pattern, an object (referred to as the subject or observable) is responsible for notifying all of its dependents (observers) of any state changes automatically. 

This pattern is designed to maintain consistency among related objects while circumventing tight coupling. It addresses two key features: 
1. One-to-many relationship. This relationship enables the subject to notify all its observers about state changes without knowing their concrete implementations. 

2. Loose coupling. It promotes loose coupling between the subject and its observers by using a common interface or abstract class to define the method for updating observers when the subject's state changes. 

### Comparison with MVC:
This pattern bears similarities to the Model-View-Controller (MVC) pattern, as both patterns emphasize the separation of concerns and loose coupling between objects. In the MVC architectural pattern, the Model functions as the subject, while the Views act as observers. Consequently, whenever the Model's data undergoes changes, it notifies the Views, prompting them to update their display accordingly.

Despite these similarities, a key distinction exists between the two patterns. The MVC pattern represents an architectural pattern with a broader scope, encompassing the organization of an entire application. Conversely, the Observer pattern concentrates on a specific aspect of communication between objects. This pattern is useful in maintaining consistency among related objects while avoiding tight coupling.

### Components:
There are several key components for the Observer Design Pattern:
1. Subject (Observable): This component is an object that maintains a list of its observers and is responsible for notifying them about state changes, typically by invoking one of their methods.

2. Observer: Represented as an interface or abstract class, this component outlines the update method, which the subject calls upon to notify observers of changes.

3. Concrete Observer: This component entails a concrete implementation of the Observer interface or abstract class, incorporating the update method and retaining a reference to the subject.


### Application:
The Observer Design Pattern is extremely useful in creating event-driven systems. It allows an object to communicate with other objects about changes in its state, without needing to know how many of those objects there are or what kind they are. It suits any process by which data arrives from some input that is not available to the CPU at startup, but instead arrives seemingly at random (HTTP requests, GPIO data, user input from peripherals, distributed databases and blockchains, etc.).

As a behavioral pattern listed among the 23 well-known "Gang of Four" design patterns, the Observer Design Pattern is built-in in most modern programming languages. Examples of relevant use cases include weather monitoring applications, stock market tracking systems, and user interface updates.


### Example: Stock Market Application
Consider a stock market application where investors want to receive real-time updates on stock prices. According to the features of Observer Design Pattern, corresponding components are applied:
1. Stock (Subject): A Stock class represents the stock market data, maintaining a list of investors (observers) and notifying them when the stock price changes.

2. Observer: An Investor interface defines the update method, which the Stock class calls to notify investors about price changes.
3. Investor(Concrete Observer): A concrete implementation of the Investor interface (e.g., IndividualInvestor, InstitutionalInvestor) implements the update method and maintains a reference to the Stock object.
4. DisplayElement: An interface contains the method displaying investment strategies.

When the stock price changes, the Stock object notifies all its registered investors, allowing them to decide their investment strategies. If the price is too high to buy, an investor would choose to sell his/her stocks. If the price is low enough to buy, an investor would buy it and announce this decision. Since different investors apply different investment strategies in their own concrete observer classes, this example can be a primitive dashboard displaying investing behaviors in a mocking stock market. This design enables easy addition or removal of investors without modifying the Stock class or other investors, demonstrating the benefits of the Observer Design Pattern.

### Strong & Weak: 
By fostering a flexible and maintainable system, this pattern provides several key benefits:
1. Limited knowledge between subject and observer. 
- The subject only knows that the observer implements a specific interface (the Observer interface). It does not require knowledge of the observer's concrete class, functionality, or any other information. 

2. Dynamic addition or removal of observers.
- Observers can be added or removed at any time without affecting the subject or other observers. The subject maintains a list of objects implementing the Observer interface, allowing for seamless registration or unregistration of observers during runtime.

3. No modification required for new observer types. 
- Adding new observer types does not necessitate changes to the subject. To accommodate a new observer, simply implement the Observer interface in the new class and register it as an observer. The subject remains unaffected, as it delivers notifications to any object implementing the Observer interface.

4. Independent reusability of subjects and observers.
- The loose coupling between subjects and observers allows for their independent reusability in different contexts, providing flexibility and promoting code reusability.

5. Unaffected changes to subject or observer.
- Since subjects and observers are loosely coupled, changes to one do not impact the other, as long as they continue to implement the required Subject or Observer interfaces. This ensures a robust system that can adapt to changes without causing cascading effects.


However, It is also necessary to concern the following aspects when considering implementing the Observer Design Pattern: 
1. Performance concerns. 
- In instances where numerous observers exist or the update process is time-consuming, the notification process may place considerable strain on system resources.

2. Unanticipated side effects. 
- Occasionally, the order in which observers are notified can give rise to unexpected behavior, particularly if observers exhibit dependencies on one another.

### Summary:
The Observer Design Pattern is a behavioral pattern that establishes a one-to-many dependency between objects, promoting loose coupling and separation of concerns. It shares similarities with the MVC pattern but focuses on object communication. Key components are included to build a standard Observer Design Pattern.

The pattern is applicable in various scenarios, such as event-driven systems, and offers numerous advantages, including limited knowledge between subject and observer, dynamic addition or removal of observers, no modification required for new observer types, independent reusability of subjects and observers, and unaffected changes to subject or observer. 

### Reference:
[1] Freeman, Eric, and Elisabeth Robson. Head First Design Patterns: Building Extensible and Maintainable Object-Oriented Software. O'Reilly, 2021. 

[2] “Observer Pattern.” Wikipedia, Wikimedia Foundation, 15 Apr. 2023, https://en.wikipedia.org/wiki/Observer_pattern. 

[3] “Observer Pattern - Javatpoint.” Www.javatpoint.com, https://www.javatpoint.com/observer-pattern. 


## Coding Example
We created a coding example of stock market application using Observer Design Pattern. 

In this example, the subject is the stock market, it maintains the list of observer (investors), and notifying them when the stock price changes. The observers are investors, who can receive real-time updates on stock price  from the stock market, and decide whether to buy, sell or wait accordingly. 

**We include a Main.java file in the repository. Please run this file to see the sample output. We will also walk through the sample output later.**

### UML Diagram
![diagram](https://github.com/ting1065/design_pattern_cs5004/blob/master/diagram.PNG?raw=true)

### Explanation
The example has following components:

1. Subject interface - defines the basic operations that a subject (stock market) must implement to maintain its observers, which are registerObserver, removeObserver, notifyObservers, priceChanged, and setPrice.
* Methods:
    * void registerObserver(Observer o) - register an Observer object as an observer of this subject. Throws IllegalArgumentException if the observer is already in the list.
    * void removeObserver(Observer o) - remove an observer from the subject's observer list. Throws IllegalArgumentException if there is no such observer in the list.
    * void notifyObservers() - notify the observers when the subject's state has changed.
    * void priceChanged() - operations when the price is changed.
    * void setPrice(float newPrice) - set the new price of the stock.

2. Observer interface - defines the method to update the observer (investor) when the subject's state changes.
* Methods:
    * void update(float newPrice) - update the new price of stock been observed.
    * String getName() - return the name of the observer.
    * float getSellThreshold() - return the sell threshold of the observer.
    * float getBuyThreshold() - return the buy threshold of the observer.

3. DisplayElement interface - defines the method to display the observer (investor)'s current investment strategy.
* Method:
    * void display() - display the observer's current investment strategy.

4. Stock class- represents the subject that is being observed. It implements the Subject interface and maintains a list of observers. It has methods to register, remove, and notify observers (investors), as well as methods to set the stock's price and notify the observers (investors) about the price change.
* Fields: 
    * ArrayList< Observer > observers - a list of investors.
    * float price - current price of the stock.
* Constructor:
```java
// a stock with a list of observers which is initially empty.
public Stock() {
    this.observers = new ArrayList<Observer>();
}
```
* Methods of Subject interface 


5. Investor class - represents the concrete observer. It implements the Observer and DisplayElement interfaces, which define the methods that an observer (investor) must implement to receive updates and display strategy information. The Investor class also has a name, a buyThreshold, a sellThreshold, and a strategy (which is updated whenever the stock price changes).
The investor's strategy would change to:
    * buy - if the observed stock price is lower than his/her buyThreshold
    * sell - if the price is higher than his/her sellThreshold
    * wait and see - if the price is between these two thresholds.
* Fields:
    * String name - the name of the investor.
    * float buyThreshold - the price threshold that urges the investor to sell.
    * float sellThreshold - the price threshold that urges the investor to buy.
    * Strategy strategy - the stategy of the investor to sell, buy or wait.
* Constructor:
```java
//an investor that has a name, sellThreshold, and buyThreshold.
public Investor(String name, float buyThreshold, float sellThreshold)
      throws IllegalArgumentException {
    if (sellThreshold <= buyThreshold) {
      throw new IllegalArgumentException(
          "investor's sellThreshold must be higher than buyThreshold");
    }
    this.name = name;
    this.buyThreshold = buyThreshold;
    this.sellThreshold = sellThreshold;
  }
```
* Methods:
    * Methods of Observer and DisplayElement interfaces.
    * boolean equals(Object o) - compare two investors to see if they are the same person.
    * int hashCode() - generates a hash code value based on the name field of the object.

6. Strategy enumeration - represents investment strategies of buy, sell, and wait, with toString() methods.
    * BUY
    * SELL
    * WAIT


### Sample Output
We include a Main.java file in the repository with a tryout sample to initialize a stock, try adding and moving investors, try changing the prices in different ways and watch if the program works as expected.

We first create a stock and three investors. The three investors have different buyThreshold and sellThreshold.

Then we change the stock price for several times, and see how will the strategies of the three investors change.

Then we add and remove investors, change the stock price for several times, and see how will the strategies of the three investors change.

Below is the sample output:


```java
--------
created a stock
--------




--------
Added Yang Li, who would sell over 20.0, buy under 10.0, otherwise wait and see.
--------



--------
Added Yunke Li, who would sell over 25.0, buy under 15.0, otherwise wait and see.
--------



--------
Added Fengting Tang, who would sell over 30.0, buy under 20.0, otherwise wait and see.
--------



--------
set stock price at 5
--------


Yang Li: I wanna buy more!
Yunke Li: I wanna buy more!
Fengting Tang: I wanna buy more!


--------
set stock price at 12
--------


Yang Li: I wanna wait and see!
Yunke Li: I wanna buy more!
Fengting Tang: I wanna buy more!


--------
set stock price at 18
--------


Yang Li: I wanna wait and see!
Yunke Li: I wanna wait and see!
Fengting Tang: I wanna buy more!


--------
set stock price at 28
--------


Yang Li: I wanna sell all!
Yunke Li: I wanna sell all!
Fengting Tang: I wanna wait and see!


--------
set stock price at 31
--------


Yang Li: I wanna sell all!
Yunke Li: I wanna sell all!
Fengting Tang: I wanna sell all!


--------
Added Yifan Pan, who would sell over 35.0, buy under 25.0, otherwise wait and see.
--------



--------
set stock price at 34
--------


Yang Li: I wanna sell all!
Yunke Li: I wanna sell all!
Fengting Tang: I wanna sell all!
Yifan Pan: I wanna wait and see!


--------
set stock price at 50
--------


Yang Li: I wanna sell all!
Yunke Li: I wanna sell all!
Fengting Tang: I wanna sell all!
Yifan Pan: I wanna sell all!


--------
Removed Fengting Tang.
--------



--------
set stock price at 45
--------


Yang Li: I wanna sell all!
Yunke Li: I wanna sell all!
Yifan Pan: I wanna sell all!


--------
set stock price at 22
--------


Yang Li: I wanna sell all!
Yunke Li: I wanna wait and see!
Yifan Pan: I wanna buy more!


--------
the end
--------



Process finished with exit code 0
```

