---
Poised - Project management system.
---
A project management system for structural engineers.

## What does the programme do?

Takes various inputs from the user and stores that data in a database. T
the database consists of the details of each project and the contact information of each individual involved.
A user is also able to access the project and contact details of the contractor and modify certain details as they wish.

### Details

User will be asked to enter the details of 3 individuals: 
* Contractor.
* Customer.
* Architect.

Under each individual the user is asked to enter the following details:
* Name.
* Address.
* Email.
* Telephone number.

This information is then used to create 3 objects in a class called **Person**.

User is then asked to enter details for the project:
* Project name.
* Project number.
* Type of building (house, apartment or store).
* ERF number.
* Amount paid to date.
* Deadline.

A fee value is generated depending on the building type. 
Then all this information along with the 3 objects created earlier are used to create a new object under class **Project**.
This will act as out main database.

**Project** contains a few methods to access and or edit information of each object. It also contains methods to calculate amount of unpaid fees and
a *toString* representation of all the necessary information we wish to display.

## Guide

* Users are required to enter all the information for the 3 individuals.
* Users should enter all the information on the project.
* A menu will be displayed.
* Users may choose between:
  * Change deadline.
  * Change amount of fee paid to date.
  * Update contractor’s details.
    * Name.
    * Telephone number.
    * Address.
    * Email.
  * Finalise the project.
    * Only when the total fee is paid.
    * Project completion date saved.
  * Exit.

Users may choose any of the option any number of times, in any order and can **exit** at will.

## Use

This can be used by companies that work with large volumes of projects or a large volume of projects simultaneously and
wish to store and have easy access to all the information on each project. This is also a convenient way of data storage as
it can easily be updated and modified, and new methods can easily be added to modify/interpret the data at any time.

## Instruction

The *.drawio* file is just a **UML** class diagram.

Download the *__Task 7__* folder and open the folder as a project in an ide of choice and run the code.

## Contributors

Made by *Iftekharul islam*
