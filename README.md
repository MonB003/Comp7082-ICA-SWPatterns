# COMP 7082 Week 11 In Class Exercise
> This assignment has an App class that prompts the user for a start-date and an end-date. Then, it lists all the files in the default folder that were created or modified during the specified dates.
<br>

## Table of Contents
- [Technologies](#technologies)
- [How to run the project](#how-to-run-project)

<br>

## Technologies
* Java

<br>

## <a id="how-to-run-project">How to run the project</a>
### Prerequisites:
- Have a Git and GitHub account
- Have [IntelliJ](https://www.jetbrains.com/idea/download) or another coding editor

### Configuration instructions:

Cloning the repository:
- Open Command Prompt or Terminal
- `cd` into the folder you want the repository stored in
- Type: `git clone https://github.com/MonB003/Comp7082-ICA-SWPatterns.git`


### Running the project:
- In IntelliJ, the program files can be run from the IDE
- The command line can be used

#### Compile the program:
```
cd src
javac -classpath . Models\IRepository.java Models\Repository.java
javac -classpath . Presenters\Presenter.java
javac -classpath . Views\Activity.java Views\ActivityMain.java Views\OnInputListener.java
javac -classpath . Utilities\InputValidation.java
javac -classpath . App.java
```

#### Run the program:
```
java App
```
