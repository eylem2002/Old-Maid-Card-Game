The Old Maid Card Game
This project implements the classic card game "Old Maid" using Java Multithreading and Object-Oriented Programming (OOP) concepts. 
In this game, each player is represented as a separate thread, and the game is played automatically by the computer without any human players.

Game Rules
The Old Maid game is played with a standard 52-card deck plus one additional card, the Joker. 
Players aim to discard all their cards by forming matching pairs, where two cards have the same value and color (e.g., Spades match with Clubs, Diamonds match with Hearts). The player left with the Joker at the end of the game loses.

Implementation Details
Java Multithreading: Each player is represented as a separate thread, allowing for concurrent execution of player actions.
Object-Oriented Design: The game utilizes OOP principles for modular design and implementation.
Main Thread: The main thread is responsible for starting player threads, distributing cards, and reporting game results at the end.
Wait/Notify Mechanism: Efficient use of CPU resources is ensured by using the wait/notify mechanism between threads. 
Players wait in a "wait" state when it's not their turn, reducing unnecessary CPU consumption.

Project Objectives
Use Java Multithreading and OOP to implement the Old Maid game.
Implement each player as a separate thread, with the main thread managing the game flow.
Ensure efficient CPU usage by utilizing the wait/notify mechanism between threads.
Focus on Java multithreading while also considering OOP design principles for grading purposes.
This project provides an interactive and automated way to enjoy the Old Maid card game while exploring Java multithreading and OOP concepts.
