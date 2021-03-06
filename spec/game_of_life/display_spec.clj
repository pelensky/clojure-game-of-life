(ns game-of-life.display-spec
  (:require [speclj.core :refer :all]
            [game-of-life.display :refer :all]))

(describe "Display grid"
          (it "prints an empty grid as an empty string"
              (should-contain ""
                              (with-out-str (display #{}))))

          (it "prints a grid with a single value in 0 0 as a star"
              (should-contain "*"
                              (with-out-str (display #{[0 0]}))))

          (it "prints two cells if given two"
              (should-contain "*\n*"
                              (with-out-str (display #{[0 0] [0 1]} ))))

          (it "prints a cell not in position zero"
              (should-contain "  \n *"
                              (with-out-str (display #{[1 1]}))))

          (it "prints lots of rows for a high number"
              (should-contain "     \n     \n     \n     \n     \n     \n     \n     \n     \n    *"
                              (with-out-str (display #{[4 9]}))))

          (it "prints living cells in different rows"
              (should-contain "*    \n *   \n  *  \n   * \n    *"
                              (with-out-str (display #{[0 0] [1 1] [2 2] [3 3] [4 4]} ))))

          (it "prints living cells in the same row"
              (should-contain "***  *"
                              (with-out-str (display #{[0 0] [1 0] [2 0] [5 0]} ))))

          (it "prints Game of Life"
              (should-contain "Game of Life"
                              (with-out-str (welcome))))

          (it "prints game over"
              (should-contain "Game of Life Complete"
                            (with-out-str (game-over))))

          (it "bumps up every negative number"
              (should= #{[0 0]}
                       (correct-coordinates #{[-1 -1]} )))

          (it "works on the lowest number"
              (should= #{[0 0] [1 0]}
                       (correct-coordinates #{[-2 0] [-1 0]})))

          (it "does not affect positive numbers"
              (should= #{ [1 1] [2 2]}
                       (correct-coordinates #{[1 1] [2 2]}))))

