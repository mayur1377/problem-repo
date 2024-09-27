Design a car booking system and implement two API's.


getAllAvailableCars(int startDate, int endDate);
reserverCar(int startDate, int endDate);
Note:- Input data is coming in infinite stream format like [startDate, endDate]. Example - [10, 12], [13, 15]
This is something which I clarified as part of initial requirements discussion.


Expectation


Discuss initial requirements. Limit the scope of problem. Finalize Assumptions.
List Down Entities and models
Discuss SOLID Principles, Design Patterns and Inheritance/Interfaces
Discuss different booking startegies. Like First Fit, MinimumWastage
Write working code with all entities and helper classes. Define modularity and use Design pattern for implementation.
Finally concurrent user scenerios and if possible working demo.
This round went really well. I was able to answer all the problems except 1 which was minimumWastage Based strategy. This is something which I heard for the first time. But yeah in general board discussion went really well and I was able to explain full scenario and how this can extend for future use cases.
Design Pattern used
a) Singleton for CarBookingApp
b) Strategy for different booking strategies