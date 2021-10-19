# Food-related Features

## Architecture

Operates on a list of food records, and a food storage object.
Food storage object contains static methods to read and write data form said list.

## Adding Food Record

This feature allows user to add a new Food Record.
Tags `n/` `c/` stand for name and calorie count respectively.

### Why is there a need for calorie count?

Health tracking is important for students, especially during the pandemic
where we stress eat during online lessons.

Additionally, each food calorie count
would be summed up to show the user the total calories consumed per day.

**Code example**

`food add n/ Samurai Burger c/ 411`

## Removing Food Record

This feature allows user to remove a Food Record created in the past.

### Why is there a need to remove a record? We can't un-eat stuff

Yes, however due to the limitations of the CLI interface there may be wrongly spelled
entries that the user wouldn't want reflected in the list.

**Code example**

`food delete [INDEX]`
## Listing All Food Records

This feature allows user to view all Food Records.

This would be particularly useful for deleting items.

**Code example**

`food list`

## Clearing food list

This feature allows users to clear their Food List.

**Code example**

`food clear`

## Saving food list on successful command

The storage on hard-disk would be automatically 
updated on every successful command entered by the user.

The interworking of this is described in detail in architecture.

## Design considerations

The abstract class `ListOfRecords` may seem uneventful to you on the surface, however
much consideration was taken in account in the making. For instance, in our current iteration
we are introducing a way to integrate current food names and calorie count from existing
food courts - e.g. TechnoEdge. Another class could inherit from `ListOfRecords` in order to parse in
the correct data, hence the generic `T` type used in the list.

# Help feature

The valid commands and syntax of each command would be displayed at runtime 
to the user, sorted alphabetically for easier reference

## Architecture

We base the software on getting all `Command` classes on runtime. This ensures scalability of code with additional syntax
for each command, and improves testability by reducing the need to hard-code all syntax of commands.

## Design and Implementation

We included some nuance in the code to make the output readable and neater.
1. A comparator is implemented for the `Command` classes in order to sort them by name
1. Every `Command` class is parsed such that it reads better. 

For example, addFoodCommand --> Add Food
   
Notice the removal of Command as it is implied, and the separation and capitalization of characters.

## Alternatives considered

Previously, the help command was hard-coded line by line where developers had to
manually type in every command with its syntax. By implementing this architecture,
much time is saved as well as making the code a lot more readable.


**Code example**

`help`