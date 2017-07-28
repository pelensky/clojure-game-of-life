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

          (it "A cell with 4 live neighbours dies"
              (should= false
                       (live-on? [0 0] [[-1 -1] [-1 +1] [0 0] [+1 +1] [+1 -1]])))

          (it "Finds all neighbours of a cell"
              (should= [[-1 1] [0 1] [1 1] [-1 0] [1 0] [-1 -1] [0 -1] [1 -1] ]
                       (find-all-neighbours [0 0])))

          (it "Finds all neighbours of a cell in a different position"
              (should= [[0 2] [1 2] [2 2] [0 1] [2 1] [0 0] [1 0] [2 0]]
                       (find-all-neighbours [1 1])))

          (it "Counts the live neighbours of a grid with one cell"
              (should= 0
                       (count-live-neighbours [0 0] [[0 0]])))

          (it "counts the live neighbours of a grid with two cells"
              (should= 1
                       (count-live-neighbours [0 0] [[0 0] [0 1]])))

          (it "should count two live neighbours"
              (should= 2
                       (count-live-neighbours [1 0] [[0 0] [1 0] [2 0]])))

          (it "should count all live neighbours"
              (should= 8
                       (count-live-neighbours [5 5] [[4 6] [5 6] [6 6] [4 5] [5 5] [6 5] [4 4] [5 4] [6 4]])))

          (it "finds all non-living neighbours"
              (should= #{[-1 1] [0 1] [1 1] [-1 0] [1 0] [-1 -1] [0 -1] [1 -1] }
                (find-non-living-neighbours [0 0] [[0 0]])))

          (it "finds all non living neighbours of a cell not in position 0 0"
              (should= #{[0 2] [1 2] [2 2] [0 1] [2 1] [0 0] [1 0] [2 0]}
                       (find-non-living-neighbours [1 1] [[1 1]])))

          (it "finds all non living neighbours when there are actually some neighbours"
              (should= #{[-1 1] [1 1] [-1 0] [1 0]}
                       (find-non-living-neighbours [0 0] [[0 1] [-1 -1] [0 -1] [1 -1]])))

          (it "finds all non living neighbours of multiple cells"
              (should= #{[0 0] [1 0] [2 0] [0 1] [2 1] [3 1] [0 2] [1 2] [3 2] [1 3] [2 3] [3 3]}
                       (find-all-non-living-neighbours [[1 1] [2 2]] ))))

          (it "finds all non living neighbours of multiple cells - other"
              (should= #{[4 1] [5 1] [6 1] [4 2] [6 2] [7 2] [8 2] [4 3] [5 3] [6 3] [8 3] [6 4] [7 4] [8 4] }
                       (find-all-non-living-neighbours [[5 2] [7 3]] ))) 
