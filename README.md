# Quiz-application-with-Timer

Java Quiz Application with Timer ⏱️

This is a simple command-line Java Quiz Application that challenges the user with multiple-choice questions and enforces a 15-second time limit per question. It tracks the user's score and provides a summary of their answers (correct, incorrect, or skipped due to timeout).

✨ Features
⏳ 15-second timer for each question

✅ Tracks correct, incorrect, and skipped questions

📊 Displays a final score and detailed summary

📚 Beginner-friendly Java code with comments

🎯 Demonstrates use of Timer, TimerTask, synchronized, and basic Java I/O


🧠 Sample Output

Welcome to Java Quiz ! You have 15 seconds per question.

1. What is the default value of a boolean variable in Java?
(a) True
(b) False
(c) null
(d) 0
Your answer:
> b
Correct!

...

Quiz Over! Your final score: 4/5

        'Summary of Your Answers'
1. What is the default value... - Correct!
2. Which Java feature... - Wrong (Your Answer: b)
3. How do you handle... - Skipped (Time's up!)


📌 Concepts Used

Timer and TimerTask for time-bound questions

synchronized blocks for thread-safe input handling

User input with Scanner

Answer tracking with List<String> (ArrayList) to store correct, incorrect, or skipped responses

 🛠️ Improvements (Suggestions)

Add more questions or allow loading from a file

Implement difficulty levels

Add GUI using JavaFX or Swing

Store results in a database or file for persistence
