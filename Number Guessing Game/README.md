# Number Guessing Game

A simple command-line-based number guessing game in Java where the user tries to guess a randomly generated number within a limited number of attempts.

## Table of Contents
- [Introduction](#introduction)
- [Features](#features)
- [Installation](#installation)
- [Usage](#usage)
- [Configuration](#configuration)
- [Dependencies](#dependencies)
- [Troubleshooting](#troubleshooting)
- [Contributing](#contributing)
- [Url Roadmap](#url-roadmap-)

## Introduction
This Java-based number guessing game generates a random number between 1 and 100. The player selects a difficulty level that determines the number of attempts allowed. The game provides hints after each incorrect guess and tracks the time taken to guess correctly.

## Features
- Three difficulty levels:
    - Easy: 5 attempts
    - Medium: 3 attempts
    - Hard: 2 attempts
- Random number generation between 1 and 100
- Real-time feedback on guesses
- Stopwatch tracking to measure the player's time
- Option to replay after winning or losing
- Input validation for numbers and difficulty levels

## Installation
1. Ensure you have [Java JDK 8+](https://www.oracle.com/java/technologies/javase-downloads.html) installed.
2. Clone or download the repository.
3. Compile the Java file:
   ```sh
   javac Main.java
   ```
4. Run te program
    ```sh
    java main
   ```
   

# Usage

1. Run the game.
2. Select a difficulty level (Easy, Medium, Hard).
3. Enter a number between 1 and 100 to make a guess.
4. Receive hints about whether your guess is too high or too low.
5. Continue guessing until you find the correct number or run out of attempts.
6. View your time and choose to play again or exit.

# Configuration
* The game difficulty level affects the number of attempts allowed.
* Modify the randomNumber() method if you want to change the range of numbers.
* Adjust difficulty settings in the dificultyLevel() method.


# Dependencies
* Uses java.util.Scanner for user input.
* Uses org.apache.commons.lang3.time.StopWatch for time tracking.

# Troubleshooting
* If the game crashes due to an invalid input, restart and enter a valid number.
* Ensure your Java version is compatible.
* If StopWatch causes issues, ensure you have Apache Commons Lang3 installed.

# Contributing

Feel free to fork this repository and submit pull requests for improvements.

# Url Roadmap 

https://roadmap.sh/projects/number-guessing-game


   
