(ns game-of-life.display-spec
  (:require [speclj.core :refer :all]
            [game-of-life.display :refer :all]))

(describe "Format Rows"
          (it "returns an empty grid if no coordinates"
              (should= []
                (format-rows [] [] 0 0)))

          (it "returns the only cell if in position 0 1"
              (should= [["*"]]
                (format-rows [[0 0]] [] 0 0)))

          (it "returns two cells if given 2"
              (should= [["*"] ["*"]]
                (format-rows [[0 0] [0 1]] [] 0 0)))

          (it "returns a cell not in position zero"
              (should= [[" " " "] [" " "*"]]
                       (format-rows [[1 1]] [] 0 0)))

          (it "returns rows for a high number"
              (should= [[" " " " " " " " " "][" " " " " " " " " "] [" " " " " " " " " "] [" " " " " " " " " "] [" " " " " " " " " "] [" " " " " " " " " "] [" " " " " " " " " "] [" " " " " " " " " "] [" " " " " " " " " "] [" " " " " " " " "*"]]
                      (format-rows [[4 9]] [] 0 0) ))
          
          (it "returns living cells in different rows"
              (should= [["*" " " " " " " " "][" " "*" " " " " " "] [" " " " "*" " " " "] [" " " " " " "*" " "] [" " " " " " " " "*"]]
                      (format-rows [[0 0] [1 1] [2 2] [3 3] [4 4]] [] 0 0) ))

          (it "returns living cells in the same row"
              (should= [["*" "*" "*" " " " " "*"]]
                       (format-rows [[0 0] [1 0] [2 0] [5 0]] [] 0 0)))
          )
