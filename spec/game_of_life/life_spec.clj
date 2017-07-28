(ns game-of-life.life-spec
  (:require [speclj.core :refer :all]
            [game-of-life.life :refer :all]))


(describe "Life"
          (it "An empty grid stays empty"
              (should= []
                       (evolve [])))

          (it "A single living cell can not support life"
              (should= []
                      (evolve [[0 0]])))

          (it "A live cell with 2 live neighbours lives on"
              (should= true
                    (live-on? [1 0] [[0 0] [1 0] [2 0]])))

          (it "A cell with 3 live neighbours lives on"
              (should= true
                       (live-on? [0 0] [[-1 0] [0 0] [-1 -1] [0 -1]])))

          (it "Finds all neighbours of a cell"
              (should= [[-1 1] [0 1] [1 1] [-1 0] [1 0] [-1 -1] [0 -1] [1 -1] ]
                       (find-all-neighbours [0 0])))

          (it "Counts the live neighbours of a grid with one cell"
              (should= 0
                       (count-live-neighbours [0 0] [[0 0]])))

          (it "counts the live neighbours of a grid with two cells"
              (should= 1
                       (count-live-neighbours [0 0] [[0 0] [0 1]]))))
