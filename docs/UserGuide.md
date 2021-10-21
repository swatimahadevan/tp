# Click - User Guide

## Table of Contents

1. [Introduction](#1-introduction)
2. [Quick Start](#2-quick-start)
3. [Features](#3-features)\
3.1 [Features Related to Module](#31-features-related-to-module)\

4. [Command Summary](#4-command-summary)
5. [Frequently Asked Questions](#5-frequently-asked-questions)

## 1. Introduction

Click (which stands for "command line interface for cramming & knowledge") is a desktop app for managing modules, lifestyle, schedule, and CAP planning. Click is optimised for those who prefer typing and can type fast.

Jump in to the section [2. Quick Start](#2-quick-start) to get started!

## 2. Quick Start

1. Ensure you have Java `11` or above installed in your Computer.
2. Download the latest `click.jar` from [here](https://github.com/AY2122S1-CS2113T-T09-4/tp/releases/tag/v1.0).
3. Copy the file to the folder you want to use as the _home folder_ for Click.
4. In the home folder for Click, launch the `jar` file using the `java -jar click.jar` command on Command Prompt (for Windows) or Terminal (for Unix-based OS, such as macOS and Linux) to start the app. If the setup is correct, you should see some think like this:

```
	__________________________________________________
	 _____ _  _     _
	/  __ \ |(_)   | |
	| /  \/ |_  ___| | __
	| \__/\ | | (__|   <
	\_____/_|_|\___|_|\_\

	Hello! I'm Duke
	What can I do for you?
	__________________________________________________
```

5. Type the valid command into the terminal (or Command Prompt) and press <kbd>return</kbd> (or <kbd>Enter</kbd>) to run the command.

## 3. Features 

**Notes about the command format:**

- Words in `UPPER_CASE` are the parameters to be supplied by the user.
- The `INDEX` used in various commands is a number specifying the order of an item in the list of items (1-based).
- Parameters cannot be reordered.
  Example: If the command specifies `module add c/MODULE_CODE n/MODULE_NAME`, keying in `module add n/MODULE_NAME c/MODULE_CODE` will result in an invalid command.

### 3.1 Features Related to Module

### 3.1.1 Adding a Module: `module add`

Adds a new Module to the list of Modules.

Click supports 3 types of adding Modules:
- Adding with module code, module name, and expected grade.
- Adding with module code and module name.
- Adding with module code only.

**Adding with module code, module name, and expected grade**

Format: `module add c/MODULE_CODE n/MODULE_NAME e/EXPECTED_GRADE`

Example: `module add c/CS2113T n/Software Engineering e/A`

Expected outcome:

```
Added CS2113T | Software Engineering | Expected grade: A
```

**Adding with module code and module name**

Format: `module add c/MODULE_CODE n/MODULE_NAME`

Example: `module add c/CS1231 n/Discrete Structure`

Expected outcome:

```
Added CS1231 | Discrete Structure
```

**Adding with module code only**

Format: `module add c/MODULE_CODE`

Example: `module add c/GEQ1000`

Expected outcome:

```
Added GEQ1000
```

### 3.1.2 Listing all Modules: `module list`

Lists all Modules in Click with numbering according to the order they are added (1-based index).

Format: `module list`

Expected outcome:

```
Here are the modules in your list:
1. CS2113T  |   Software Engineering | Expected grade: A
2. CS1231  |   Discrete Structure   | Expected grade: N/A
3. GEQ1000  |  NONE  | Expected grade: N/A
```

### 3.1.3 Deleting a Module: `module delete`

Deletes the specified Module from the list of Modules.

Format: `module delete 2`

Expected outcome:

```
I have deleted this module:
CS1231 | Discrete Structure | Expected grade: N/A
```


## 4. Command Summary

**Action** | **Format, Examples**
|----------|---------------------|
**Add Module**|- `module add c/MODULE_CODE n/MODULE_NAME e/EXPECTED_GRADE`<br><br> Example: `module add c/CS2113T n/Software Engineering e/A`<br><br>- `module add c/MODULE_CODE n/MODULE_NAME`<br><br> Example: `module add c/CS2113T n/Software Engineering`<br><br>- `module add c/MODULE_CODE`<br><br> Example: `module add c/CS2113T`
**List All Modules**|`module list`
**Delete Module**|`module delete INDEX`<br><br> Example: `module delete 2`
**Exit**|`exit`


## 5. Frequently Asked Questions

Below are the answers to some of frequently askes questions about Click.

**Q:** Can I use Click on different operating systems such as Windows and macOS?\
**A:** Yes. Click is compatible with Windows, macOS, and Linus as long as you have Java 11 or above installed in your machine.

**Q:** What will happen to my data if Click crashed?\
**A:** Data is saved automatically to `STORAGEFILE` whenever you change your tasks. Therefore, your data will be safely saved even though Click is crashed.

**Q:** Can I exit Click without using the bye command?\
**A:** Yes, you can. As mentioned above, your data will be saved automatically if a change of the tasks occurs, so you can exit Click worry-free.


