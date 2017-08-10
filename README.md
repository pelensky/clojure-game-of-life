# Conway's Game of Life
## Clojure

The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970.

The "game" is a zero-player game, meaning that its evolution is determined by its initial state, requiring no further input. One interacts with the Game of Life by creating an initial configuration and observing how it evolves, or, for advanced "players", by creating patterns with particular properties.

[Further information](https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life)

#### Rules 

1. Any live cell with fewer than two live neighbours dies, as if caused by underpopulation.
2. Any live cell with two or three live neighbours lives on to the next generation.
3. Any live cell with more than three live neighbours dies, as if by overpopulation.
4. Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.

#### Prerequisites 
1. Install [Java](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
2. Install [Homebrew](https://brew.sh/) by running `$ /usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"`
3. Install [Clojure](https://clojure.org/guides/getting_started) by running `$ brew install clojure`
4. Install [Leiningen](https://leiningen.org/) by running `$ brew install leiningen`

#### Running instructions
1. Clone the repository by clicking on the green "Clone or Download" button
2. Select Download Zip
3. Double click the zip file to unzip it
4. In terminal, CD into the repository
5. Run the app by running `$ lein run`
6. If your colony dies out the program will end when this occurs. To exit the program, press Control-C to
   kill the app at any time.


