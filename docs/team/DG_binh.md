# Module-related Features

## Adding a Module

This feature allows user to add a new Module. 

If the creation is successful, a confirmation message on the newly created Module will be displayed to the user.

**Implementation**

## Removing a Module

This feature allows user to remove a Module created in the past.

If the deletion is successful, a confirmation message on the Module deletion will be displayed to the user.

**Implementation**

## Listing All Modules

This feature allows user to view all Modules.

**Implementation**

When the user types `module list`, the following sequence of steps will then occur:

1. User executes `module list`\
i. `Click` receives user's input.\
ii. `Parser` calls `parser.parseCommand(userInput)` to parse user's input into a `Command`.
2. Creating `ListModuleCommand` object.
3. Executing command.
4. Prompting result to the user.

## Calculating Expected CAP