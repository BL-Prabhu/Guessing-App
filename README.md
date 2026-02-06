🎯 Guessing App – Java Console Application

📌 Overview

The Guessing App is a console-based Number Guessing Game developed as a hands-on learning project to master core Java programming concepts.

This application helps learners understand how Java syntax, data types, control flow, methods, OOPS principles, and user interaction work together in a real-world, interactive console-based application.

The project emphasizes:

• Problem-solving skills  
• Interactive user experience  
• Incremental logic building  
• Clean, readable, and extensible code design

--------------------------------------------------

🎯 Objective

• Initialize the guessing game with required configurations  
• Allow the player to submit guesses  
• Validate input and provide real-time feedback  
• Provide controlled hints after incorrect guesses  
• Ensure predictable and controlled game behavior

--------------------------------------------------

🧠 Concepts Covered

• Primitive Data Types  
• Scanner Input Handling  
• Random Number Generation  
• Control Flow (if-else, loops)  
• Constructor Initialization  
• Encapsulation (private fields)  
• Constants using final keyword  
• Method Invocation  
• Separation of Concerns (OOPS)

--------------------------------------------------

🎮 UC1 – Game Initialization

🎯 Goal

Initialize the guessing game with required configurations.

👥 Actors

• Player (Primary)  
• Game Engine (Secondary)

🔑 Key Requirements

• Generate a random target number within a predefined range  
• Initialize maximum number of attempts  
• Store game configuration values  
• Display welcome message and game rules

🔄 Flow

1. Start the application
2. Initialize game variables
3. Generate random target number
4. Display rules and instructions to the user

⭐ Key Benefits

• Controlled game setup  
• Reusable configuration logic  
• Predictable game behavior  
• Clear separation of initialization logic  
• Easy modification of difficulty levels

--------------------------------------------------

🎮 UC2 – User Guess Submission

🎯 Goal

Allow the player to submit a guess and receive immediate feedback.

👥 Actors

• Player  
• GuessValidator

🔑 Key Requirements

• Accept user input using Scanner  
• Validate numeric input  
• Compare guessed number with target number  
• Track number of attempts  
• Provide feedback (Correct / Higher / Lower)

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
5. Repeat until correct guess or attempts exhausted

📤 Output

• correct → When the guess matches the target  
• high → When the guess is lower than the target  
• low → When the guess is higher than the target

⭐ Key Benefits

• Interactive user experience  
• Structured decision making  
• Reduced runtime errors  
• Improved logical thinking  
• Clear user feedback loop

--------------------------------------------------

🎮 UC3 – Hint Generation

🎯 Goal

Provide helpful and controlled hints to guide the player toward the correct answer after incorrect guesses.

👥 Actors

• Player  
• HintService

🔑 Key Requirements

• Generate hints after incorrect guesses  
• Limit the number of hints  
• Provide meaningful hints (even/odd, range-based)  
• Increase difficulty gradually  
• Ensure hints do not reveal the exact number

🧠 Key Concepts

• Conditional logic  
• Modulus and arithmetic operators  
• Method abstraction  
• Encapsulation of hint logic

🔄 Flow

1. Player submits a wrong guess
2. Hint counter is incremented
3. HintService generates a hint
4. Hint is displayed to the user

📤 Output

• Hint: Number is EVEN / ODD  
• Hint: Number is greater than 50 / 50 or less  
• No more hints available

⭐ Key Benefits

• Enhanced user engagement  
• Progressive difficulty learning  
• Encourages analytical thinking  
• Clean separation of hint logic  
• Reusable hint generation engine

--------------------------------------------------

🎮 UC4 – Error Handling & Validation
🎯 Goal

Ensure safe and validated user inputs throughout the game without crashing the application.

👥 Actors

• Player
• ValidationService

🔑 Key Requirements

• Handle non-numeric input
• Prevent out-of-range guesses
• Display user-friendly error messages
• Prevent application crashes
• Log and track invalid attempts

🧠 Key Concepts

• Exception handling (try-catch)
• Custom exceptions
• Input sanitization
• Fail-fast approach
• Separation of validation logic

🔄 Flow

1. Player enters input

2. Input is passed to ValidationService

3. Invalid input throws custom exception

4. Error message is displayed

5. Game continues safely

📤 Output

• Error message → Invalid input
• Accepted input → Game continues

⭐ Key Benefits

• Robust and crash-free execution
• Better user guidance
• Cleaner main game logic
• Easier debugging
• Production-ready behavior

📂 Project Structure
guessing-app/
│
└── guessingapp/
├── GuessingApp.java        // Main controller
├── GameConfig.java        // Game configuration (UC1)
├── GuessValidator.java    // Guess comparison logic (UC2)
├── HintService.java       // Hint generation logic (UC3)
├── ValidationService.java // Input validation (UC4)
└── InvalidInputException.java // Custom exception (UC4)


--------------------------------------------------

⚠⚠️ Drawbacks of Previous Approach

• No hints → frustrating user experience
• Unhandled input → runtime crashes
• Hardcoded logic
• No replay support
--------------------------------------------------

✅ Current Status

✔ UC1 – Game Initialization implemented
✔ UC2 – User Guess Submission implemented
✔ UC3 – Hint Generation implemented
✔ UC4 – Error Handling & Validation implemented

--------------------------------------------------

👨‍💻 Author

Prabhu  
Java Learning Project
