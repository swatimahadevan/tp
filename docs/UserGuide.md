# Click - User Guide

## Table of Contents

1. [Introduction](#1-introduction)
2. [Quick Start](#2-quick-start)
3. [Features](#3-features)\
3.0 [Help feature](#301-help-feature)\
3.1 [Features Related to Module](#31-features-related-to-module)\
3.2 [Features Related to Zoom Link](#32-features-related-to-zoom-link)\
3.3 [Features Related to Calendar](#33-features-related-to-calendar)\
3.4 [Features Related to Journal](#34-features-related-to-journal)\
3.5 [Features Related to Food](#35-features-related-to-food)
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

### 3.0.1 Help Feature

Shows all available commands and syntax

Format: `help`

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

Format: `module delete INDEX`

Expected outcome:

```
I have deleted this module:
CS1231 | Discrete Structure | Expected grade: N/A
```

### 3.2 Features Related to Zoom Link

### 3.3 Features Related to Calendar

### 3.4 Features Related to Journal
### 3.4.1 Adding a notebook: `journal notebook`
Adds a notebook with the desired name.

Format: `journal notebook n/ NOTEBOOK_NAME`

Example: `journal notebook n/ Today`

Expected outcome:

```
Great you have added the notebook: Today
```

### 3.4.2 Adding an entry: `journal entry`
Adds an entry with the desired name to a specific notebook

Format: `journal entry n/ NOTEBOOK_NAME e/ ENTRY_NAME`

Example: `journal entry n/ Today e/ Random Observation`

Expected outcome:

```
Great you have added the entry: Random Observation
```

### 3.4.3 Listing notebooks with entries: `journal list`
Lists all notebooks with their entries.

Format: `journal list`

Example: `journal list`

Expected outcome:

```
The notebook Today contains:
Random Observation
```

### 3.5 Features Related to Food
### 3.5.1 Adding a food item: `food add`
Adds a food item with name and calorie count.

Format: `food add n/FOOD_NAME n/KCALORIE`

Example: 

```
food add n/ Samurai Burger c/ 433
food add n/ Seaweed Shaker Fries Seasoning c/ 15
food add n/ Large Fries c/  461
food add n/ Caramel Frappé - Medium c/ 624
food add n/ A Thousand Tide Pods c/ 92
```

Expected outcome:

```
Nice.  I've added Samurai Burger to the list, with 433 calories!
Nice.  I've added Seaweed Shaker Fries Seasoning to the list, with 15 calories!
Nice.  I've added Large Fries to the list, with 461 calories!
Nice.  I've added Caramel Frappé - Medium to the list, with 624 calories!
Nice.  I've added A Thousand Tide Pods to the list, with 92 calories!
```

### 3.5.2 Listing food records: `food list`

Format : `food list`


Expected outcome:

```
1st,You consumed  Samurai Burger , which has a calorie count of : 433!
2nd,You consumed  Seaweed Shaker Fries Seasoning , which has a calorie count of : 15!
3rd,You consumed  Large Fries , which has a calorie count of : 461!
4th,You consumed  Caramel Frappé - Medium , which has a calorie count of : 624!
5th,You consumed  A Thousand Tide Pods , which has a calorie count of : 92!
Wow, that's a lot of food! Finished reading today's list
You consumed 1625 calories in total today!
```

### 3.5.3 Deleting food records: `food delete`

Format: `food delete INDEX`

Example: `food delete 5`

Expected outcome:

```
Deleted food record  A Thousand Tide Pods at index: 5
```

### 3.5.4 Clearing food list: `food clear`

Format : `food clear`


Expected outcome:

```
Cleared food record list for today!
```


## 4. Command Summary

**Action** | **Format, Examples**
|----------|---------------------|
**Add Entry**|`journal entry n/ NOTEBOOK_NAME e/ ENTRY_NAME`
**Add Food**|`food add`
**Add Lecture**|`calendar lecture m/ MODULE_CODE s/ DD-MM-YYYY(START_DATE) e/ DD-MM-YYYY(END_DATE)`
**Add Module**|- `module add c/MODULE_CODE n/MODULE_NAME e/EXPECTED_GRADE`<br><br> Example: `module add c/CS2113T n/Software Engineering e/A`<br><br>- `module add c/MODULE_CODE n/MODULE_NAME`<br><br> Example: `module add c/CS2113T n/Software Engineering`<br><br>- `module add c/MODULE_CODE`<br><br> Example: `module add c/CS2113T`
**Add Note**|`journal notebook n/ NOTEBOOK_NAME`
**Add Todo**|`calendar todo n/ TASK_NAME d/ DD-MM-YYYY`
**Add Zoom**|`zoom add [MODULE_CODE] [ZOOM_LINK]`
**Clear Food**|`food clear`
**Delete Food**|`food delete INDEX`
**Delete Module**|`module delete INDEX`<br><br> Example: `module delete 2`
**Delete Note**|`journal delete NOTE_INDEX`
**Delete Task**|`calendar delete TASK_INDEX`
**Display**|`calendar MM-YYYY`
**Edit Tasks**|`calendar delete TASK_INDEX`
**List  Food Items**|`food list`
**List  Journal**|`journal list`
**List  Modules**|`module list`
**List Tasks**|`calendar list`
**List Zoom Links**|`zoom list`
**Exit**|`exit`


## 5. Frequently Asked Questions

Below are the answers to some of frequently askes questions about Click.

**Q:** Can I use Click on different operating systems such as Windows and macOS?\
**A:** Yes. Click is compatible with Windows, macOS, and Linus as long as you have Java 11 or above installed in your machine.

**Q:** What will happen to my data if Click crashed?\
**A:** Data is saved automatically to `STORAGEFILE` whenever you change your tasks. Therefore, your data will be safely saved even though Click is crashed.

**Q:** Can I exit Click without using the bye command?\
**A:** Yes, you can. As mentioned above, your data will be saved automatically if a change of the tasks occurs, so you can exit Click worry-free.


