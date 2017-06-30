# kotlin-dojo
A Kotlin programming challenge around the game of Noughts and Crosses.

Requirements
* IntelliJ IDEA 2017.1.4 CE (or Ultimate)
* Kotlin Plugin 1.1.3
* Java8

The codebase contains a simple console based version of the game Noughts and Crosses
where two human players play against each other.

A simple execution of the game will look like that (coordinates are 0 indexed starting from the top left corner):

     | | 
    -----
     | | 
    -----
     | | 
    Player X please make a move: 
    0 0
    X| | 
    -----
     | | 
    -----
     | | 
    Player O please make a move: 
    1 0
    
    X| | 
    -----
    O| | 
    -----
     | | 
    Player X please make a move: 
    0 1
    X|X| 
    -----
    O| | 
    -----
     | | 
    Player O please make a move: 
    1 1
    X|X| 
    -----
    O|O| 
    -----
     | | 
    Player X please make a move: 
    0 2
    X|X|X
    -----
    O|O| 
    -----
     | | 
    X is the winner!
    
The code challenge is divided into checkpoints each contained in a separate directory where a README gives hints about solving the problem.
The solution of a challenge in directory _n_ is provided in directory _n+1_. If you are new to Kotlin we strongly suggest to approach the challenges following the provided sequence.
Every solution will teach you something about the language and how to solve the next steps.