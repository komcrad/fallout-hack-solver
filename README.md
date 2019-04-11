# fallout-hack-solver

A Clojure cli app designed to solve the word likeness game in fallout.

## Understanding the game

In the game fallout, there's a hacking game that gives you `x` attempts to guess a random word based on previous guesses likeness to the winning word.  
Each round consists of several words of the same length. A word is randomly selected.  
Imagine you have a list of words to choose from:  
```
(let [words ["fanatic" "discuss" "natural" "fertile" "dealing"
             "recruit" "blasted" "bedroom" "records" "regular"
             "defense" "ceiling" "becomes" "durable"]])
```

The winning word here will be <b>records</b> (it's random..... or so I assume).  
If you select <em>fanatic</em>, that would return a likeness of 0. Because no letters in <em>fanatic</em> are in the same position as <b>records</b>.  
If you select <em>becomes</em>, that would return a likeness of 2. Because position 1 (e) and poition 6 (s) of the two words match.  

##### Trying to beat this game was fun. But making a program that would predict the best choices for you was much more fun.

## Usage:

If you have lein:
```
lein run
```
or if you want to take it with you everywhere you go:  
```
lein uberjar
```
or if you want to use graalvm because this is the first you could get it to do anything:
```
sudo docker run -it -v $(pwd):/project --rm tenshi/graalvm-native-image -Dclojure.compiler.direct-linking=true -jar target/fallout-hack-solver-0.1.0-SNAPSHOT-standalone.jar
```
## License

Copyright © 2019 komcrad

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
