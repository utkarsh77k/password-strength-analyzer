# Password Strength Analyzer 

## About the Project

This project is a password strength analyzer I built to better understand how real-world password security works.. Instead of just checking length, it also considers randomness and common patterns that make passwords weak.

I first made a basic CLI version to focus on the logic, and later extended it into a web application using Spring Boot so it’s easier to use.

## What it does

* Checks if a password is weak, moderate, or strong
* Looks at:

  * Length of password
  * Use of uppercase, lowercase, numbers, symbols
* Calculates entropy (to measure randomness)
* Detects weak patterns like:

  * "123", "abc"
  * repeated characters like "aaa"
  * common words like "password"
* Gives suggestions to improve the password


## Tech Used

* Java
* Spring Boot
* HTML, CSS


## How to run

### Web version:

1. Run the Spring Boot application
2. Open browser and go to:
   http://localhost:8080

### CLI version:

Run the main Java file and enter password in terminal
## Screenshots

![App](screenshot/Screenshot (35).png)

## Why I made this

I wanted to explore cybersecurity concepts practically, especially how weak passwords are actually formed and detected. This project helped me understand entropy and pattern-based weaknesses better.


## Future improvements

* Check passwords against leaked databases
* Better UI
* More advanced pattern detection


## Author

Utkarsh
