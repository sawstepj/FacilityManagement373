# FacilityManagement
COMP 373 - Project 1

For this project we decided to implement an apartment facility manager that would perform all the required management tasks of an apartment The way we setup the apartment facility is as follows:

3 main interfaces
- Facility
- Maintenance
- Use

Within these three main interfaces the setup is as follows:

Facility:

Facility Detail: contains all the pertinent details of a facility such as the number of units, floors, the name of the facility.
within this class one can add or delete floors and units.
The facility consists of multiple floors, these floors consist of units and extra facilities on each floor. The extra facilities are gym and laundry facilities all units and extra facilities contain a location object which is a unit number and a floor number.

Use:

A facility's use is defined in two main ways: a specific facility (unit or extra facility) can be inspected and/or can have a specfic user such as an employee or a tenant
Inspections can consist of either safety or clean inspections. A tenant can have lease for a specific unit and can also have other depandents living with them. Users can be added or deleted from a specific facility, either a tenant or an employee. The cost of the unit is mainly determined by how many people live in that facility (number of users/dependants for that user).

Maintenance:

Maintenance consists of scheduled maintenances for each facility whether it's an apartment unit or an extra facility. Users or managers can make requests and schedule them. We've decided to store requests in a list and store the overall schedule in a Hashmap that contains the date and type of request. The types of maintenance requests are HVAC, cleaning,grounds keeping, plumbing, and pest control. Each has its own calculated cost, downtime and problem rate

Testing - Client and unit tests:

We tested our project by creating client tests that consisted of reading from a file and instantiating objects and calling their methods in order to ensure they return the correct values.
The same goes for the unit tests, we created classes that tested the objects, methods, and attributes.
Data: We stored our data in a data file in the Base.Model.DAL layer and we were able to access our data from there.

Dependency Injection:
We added in dependenicies where instances of other classes were already present. The UseSchedule class contains the most dependencies where instances of the Units, ExtraFacilities, and Date classes are present. Furthermore, the FacilityClient class has been modified to include an ApplicationContext object inorder to get the beans in the XML file to utilize the dependencies. In order to perform the component scan in the XML file, we created a new package named 'Base' where all parts of the project except the spring components now reside.

Design Patterns:

Observer Design Pattern: 

The way we implemented the observer design pattern was within our Maintenance Request class we had 
a variable "status" which was the status of each type of maintenance request such as "Submitted", "In progress", and "completed"  this was the perfect 
place to implement the observer design pattern because the maintenance request class can keep track of each of the subclasses status's and they would
get notified when a MR(maintenance request) gets changed such as when a new one is submitted, or one moves from
in progress to completed. The methods for setting the status, getting the status, attaching the observers, and notifying all of the obeservers
was defined in the MR class and the rest of the sub classes such as cleaning, HVAC, and pest control
implemented the corresponding update method by overriding it.  This solved a big problem in our project because 
it introduced an easier way to keep track of the status of each MR without having to do manual checks or updates.
The observer pattern took care of that through the update and notify all observers methods that we implemented.

Bridge Design Pattern:

The Brdige pattern is implemented within the MaintenanceRequest class. the MaintenanceRequest class acts as our abstract class that holds the reference to the new interface 'EmployeeType.' The EmployeeType interfaace contains one method type() where a String is returned indicating the type of employee performing the maintenance. There are two concrete classes that implement the EmployeeType interface. These are the 'BuldingEmployee' and 'Contractor' classes. Each class has a corresponding implementation of the type() method where either "Building Employee" or "Contractor" are returned as a String. The concrete classes that extend from the MaintenanceRequest class are the different types of maintenance tasks that can be requested between 'Cleaning', 'GroundsKeeping', 'HVAC', 'PestControl', and 'Plumbing.' Both MaintenanceRequest and the Concrete classes' constructors were modified to include EmployeeType. Now, each type of maintenance requires the distinction between the two possible parties responsible for executing a maintenance request.

Visitor Design Pattern:

The Visitor pattern is implemented throughout the 'Facility' package. A new interface, Visitor, was created with two visit methods corresponding to each concrete visitor. In this case, the 'Detail' and 'Manager' classes are being visited. Each class now contains an accept method to allow for visitation. Furthermore, a new class, 'FacilityVisitor', was also added to the 'Facility' package, acting as the concrete visitor, implementing both the 'visitDetail' and 'visitManager' methods. Each method prints a message to the console indicating the retrieval of an element that corresponds to the class being visited. In the case of the 'Detail' class, the visit method is able to retrieve and utitlize a unit number through the 'Detail' class without changing the current state of said class. This adheres to Open Closed Principle.
