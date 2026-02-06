# 🎯 Guessing App – Java Console Application

---

## 📌 Overview

The **Guessing App** is a console-based **Number Guessing Game** developed as a hands-on learning project to master **core Java programming concepts**.

This application helps learners understand how Java syntax, data types, control flow, functions, exception handling, file handling, and database integration work together in a real-world, interactive console-based application.

The project emphasizes:
Problem-solving skills
User interaction
Incremental logic building
Clean, readable, and extensible code design

---

## 🎯 Objective

Initialize the guessing game with required configurations
Prepare the game environment before user interaction
Ensure predictable and controlled game behavior

---

## 🧠 Concepts Covered

Primitive Data Types
Random Number Generation
Constructor Initialization
Encapsulation (private fields)
Constants using final keyword

---

## 🎮 UC1 – Game Initialization

### 🎯 Goal
Initialize the guessing game with required configurations.

### 👥 Actors
**Player** (Primary)
**Game Engine** (Secondary)

### 🔑 Key Requirements

Generate a random target number within a predefined range
Initialize maximum number of attempts
Initialize hint counter
Store game configuration values
Display welcome message and game rules

### 🔄 Flow

1. Start the application
2. Initialize game variables
3. Generate random target number
4. Display rules and instructions to the user

### ⭐ Key Benefits

Controlled game setup
Reusable configuration logic
Predictable game behavior
Clear separation of initialization logic
Easy modification of difficulty levels

### ⚠️ Drawbacks of Previous Approach

Hardcoded logic
No flexibility
No replay support