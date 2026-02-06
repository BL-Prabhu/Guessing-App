🎯 Guessing App – Java Console Application
📌 Overview

The Guessing App is a console-based Number Guessing Game developed as a hands-on learning project to master core Java programming concepts.

This application helps learners understand how Java syntax, data types, control flow, methods, OOPS principles, and user interaction work together in a real-world, interactive console-based application.

The project emphasizes:

Problem-solving skills

Interactive user experience

Incremental logic building

Clean, readable, and extensible code design

🎯 Objective

Initialize the guessing game with required configurations

Allow the player to submit guesses

Validate input and provide real-time feedback

Ensure predictable and controlled game behavior

🧠 Concepts Covered

Primitive Data Types

Scanner Input Handling

Random Number Generation

Control Flow (if-else, loops)

Constructor Initialization

Encapsulation (private fields)

Constants using final keyword

Method Invocation

Separation of Concerns (OOPS)

🎮 UC1 – Game Initialization
🎯 Goal

Initialize the guessing game with required configurations.

👥 Actors

Player (Primary)

Game Engine (Secondary)

🔑 Key Requirements

Generate a random target number within a predefined range

Initialize maximum number of attempts

Store game configuration values

Display welcome message and game rules

🔄 Flow

Start the application

Initialize game variables

Generate random target number

Display rules and instructions to the user

⭐ Key Benefits

Controlled game setup

Reusable configuration logic

Predictable game behavior

Clear separation of initialization logic

Easy modification of difficulty levels

🎮 UC2 – User Guess Submission
🎯 Goal

Allow the player to submit a guess and receive immediate feedback.

👥 Actors

Player

GuessValidator

🔑 Key Requirements

Accept user input using Scanner

Validate numeric input

Compare guessed number with target number

Track number of attempts

Provide feedback (Correct / Higher / Lower)

🧠 Key Concepts

1. Scanner input handling

2. Control flow (if-else)

3. Looping (while)

4. Method invocation

5. Input validation

🔄 Flow

1. Prompt user for a guess

2. Validate numeric input

3. Compare guess with target number

4. Display feedback message

Repeat until correct guess or attempts exhausted

📤 Output

correct → When the guess matches the target

high → When the guess is lower than the target

low → When the guess is higher than the target

⭐ Key Benefits

Interactive user experience

Structured decision making

Reduced runtime errors

Improved logical thinking

Clear user feedback loop

📂 Project Structure

guessing-app/
│
└── guessingapp/
├── GuessingApp.java        // Main controller
├── GameConfig.java        // Game configuration
└── GuessValidator.java    // Guess comparison logic

⚠️ Drawbacks of Previous Approach

Hardcoded logic

No flexibility

No replay support