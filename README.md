#  Quiz Game (Java Console Project)

## Overview
This is a **menu-driven Quiz Game** built in Java using Object-Oriented Programming concepts.  
The project allows users to:
- Create their own quiz by entering questions, options, and correct answers
- Play the quiz and get real-time scoring
- Save scores to a file for persistence
- View a **Leaderboard (Top 5 players)** with highest scores

This project demonstrates the use of **Java OOP, Collections, File Handling, and Input Handling**.

---

## Features
- **Menu system**
  - Create Quiz
  - Play Quiz
  - View Leaderboard (Top 5 scores saved from previous runs)
  - Exit
- **Question randomization** each time the quiz is played
- **File handling** to store all scores persistently (`highscore.txt`)
- **Leaderboard system** instead of a single high score
- **Fully user-input driven** (no hardcoded questions)

---

## 🛠 Technologies Used
- **Java** (Core concepts: Classes, Objects, Collections, File I/O)
- **Scanner** for user input
- **File Handling** for persistent storage

---

## Project Structure
QuizGame

├── Question.java # Represents a single question

├── Quiz.java # Manages quiz logic and gameplay

├── HighScoreManager.java # Handles saving & displaying leaderboard

├── QuizGame.java # Main class with menu system

├── highscore.txt # (Auto-created) Stores scores persistently

└── README.md # Project documentation

##  How to Run
1. Clone the repository or download the project.
2. Compile the Java files:
   ```bash
   javac *.java
3.Run the main program:
   java QuizGame

Author
Akankhya-Dash
Developed as part of an Internship Project.
