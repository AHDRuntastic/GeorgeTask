# GeorgeTask
This task for the Software quality engineer opportunity 
# Automation FrameWork

## Introduction
Appium is a free (open-source) automated testing framework used to validate mobile applications across different platforms..


### Tech stach:

- Java
- Maven
- Cucumber
- BDD

### This project uses the following tools:

- Cucumber
- Selenium
- Appium
- BDD
- IntelliJ as IDE
- Android as Platform

## Structure
The structure of the project follows the rules of BDD and Cucumber, taking into consideration the Page Object Models

- application

- src

    - main

        - java
             - base
             - pages

    - test
        - java
            - cucumber
               - runner
               - stepDefinitions

        - resources
            - features



**application**-> Folder to locate App.APK to be tested.

**src\main\java\base\PageBase.java** -> Add your common actions for the locators

**src\main\java\base\TestBase.java** -> Add appium configuration and setup 

**src\main\java\\pages** -> Add all your locators for every screen in the app

**src\test\java\cucumber** -> Cucumber test runners and step definitions

**src\test\resources\features** -> Add all the feature files including scenarios using Gherkin.
